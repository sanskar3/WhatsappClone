package com.backbencher.www.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.backbencher.www.R;
import com.backbencher.www.adapter.CallListAdapter;
import com.backbencher.www.model.CallList;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CallsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CallsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CallsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CallsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CallsFragment newInstance(String param1, String param2) {
        CallsFragment fragment = new CallsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_calls, container, false);


        RecyclerView recyclerView=view.findViewById(R.id.recyclerview3);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        List<CallList> lists=new ArrayList<>();
//
//        lists.add(new CallList("001","Aniket","08/10/20 , 09:45pm","https://scontent.frpr1-1.fna.fbcdn.net/v/t1.0-9/94138769_1218717148482079_8936823183349121024_o.jpg?_nc_cat=107&_nc_sid=09cbfe&_nc_ohc=lxu4i4Jvu44AX_VG99f&_nc_ht=scontent.frpr1-1.fna&oh=7d33deb3a7bd7321d3469f0654fe16e4&oe=5FA5647C","Income"));
//        lists.add(new CallList("002","Ritesh","08/10/20 , 09:36pm","https://scontent.frpr1-1.fna.fbcdn.net/v/t1.0-9/90235462_1074707249556891_1655917833449635840_o.jpg?_nc_cat=103&_nc_sid=09cbfe&_nc_ohc=e7FeOrLYJ28AX8uAASz&_nc_ht=scontent.frpr1-1.fna&oh=54dfd1708c616813cf3520382d8c6bf9&oe=5FA35CEA","Missed"));
//        lists.add(new CallList("003","Alfaaz","08/10/20 , 09:31pm","https://scontent.frpr1-1.fna.fbcdn.net/v/t1.0-9/50778363_2279651548978723_7208459194465255424_o.jpg?_nc_cat=111&_nc_sid=09cbfe&_nc_ohc=UT1B9hSDpP4AX-mBmGJ&_nc_ht=scontent.frpr1-1.fna&oh=f2f9c53b01239589c7a26be18623ebd5&oe=5FA31E62","Out"));

        recyclerView.setAdapter(new CallListAdapter(lists,getContext()));
        return view;
    }
}