package com.backbencher.www;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import com.backbencher.www.databinding.ActivityMain2Binding;
import com.backbencher.www.menu.CallsFragment;
import com.backbencher.www.menu.ChatFragment;
import com.backbencher.www.menu.StatusFragment;
import com.backbencher.www.view.starup.setting.SettingActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);


        setUpWithViewPager(binding.viewPager);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        setSupportActionBar(binding.toolbar);

        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeFebIcon(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


   }
      private void setUpWithViewPager(ViewPager viewPager){
          MainActivity2.sectionsPagerAdapter adapter = new sectionsPagerAdapter(getSupportFragmentManager());
          adapter.addFragment(new ChatFragment(), "Chats");
          adapter.addFragment(new CallsFragment(),"Calls");
          adapter.addFragment(new StatusFragment(),"Status");
          viewPager.setAdapter(adapter);


      }
      private static class sectionsPagerAdapter extends FragmentPagerAdapter{

        private final List<Fragment> mFragmentList =new ArrayList<>();
        private final List<String> mFragmentTitleList=new ArrayList<>();

          public sectionsPagerAdapter(@NonNull FragmentManager fm) {
              super(fm);
          }

          public sectionsPagerAdapter(@NonNull FragmentManager fm, int behavior) {
              super(fm, behavior);
          }

          @NonNull
          @Override
          public Fragment getItem(int position) {
              return mFragmentList.get(position);
          }

          @Override
          public int getCount() {
              return mFragmentList.size();
          }

          public void addFragment(Fragment fragment,String title){
              mFragmentList.add(fragment);
              mFragmentTitleList.add(title);
          }
          @Override
          public CharSequence getPageTitle(int position){
              return mFragmentTitleList.get(position);
          }
      }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.menu_search:
                Toast.makeText(MainActivity2.this, "Action Search", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_new_group:
                Toast.makeText(MainActivity2.this, "Action new group", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_new_broadcast:
                Toast.makeText(MainActivity2.this, "Action More", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_wa_web:
                Toast.makeText(MainActivity2.this, "Action wed", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_starred_message:
                Toast.makeText(MainActivity2.this, "Action starred ", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_setting:
                startActivity(new Intent(MainActivity2.this, SettingActivity.class));
                break;


        }
        return super.onOptionsItemSelected(item);
    }

    private void changeFebIcon( final int index){
        binding.fabAction.hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (index){
                    case 0 : binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_baseline_chat_24));break;
                    case 1 : binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_baseline_camera_alt_24));break;
                    case 3 : binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_baseline_call_24));break;



                }
                binding.fabAction.show();
            }
        },400);

    }
}
