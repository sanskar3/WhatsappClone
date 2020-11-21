package com.backbencher.www.view.starup.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backbencher.www.MainActivity2;
import com.backbencher.www.R;
import com.backbencher.www.databinding.ActivityPhoneLoginBinding;
import com.backbencher.www.model.user.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.TimeUnit;

public class ManageOtp extends AppCompatActivity {

    EditText t2;
    Button b2;
    String phoneNumber;
    String otpId;
    FirebaseAuth mAuth;
    private ActivityPhoneLoginBinding binding;


    FirebaseUser firebaseUser;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_manage_otp);


        phoneNumber= getIntent().getStringExtra("mobile").toString();
        t2=(EditText)findViewById(R.id.t2);
        b2=(Button)findViewById(R.id.b2);
        mAuth=FirebaseAuth.getInstance();
//        firestore=FirebaseFirestore.getInstance();


        initiateotp();

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.btnNext.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),"Blank field can not processed",Toast.LENGTH_LONG).show();
                else if (t2.getText().toString().length()!=6)
                    Toast.makeText(getApplicationContext(),"Invalid OTP",Toast.LENGTH_LONG).show();
                else {
                    PhoneAuthCredential credential=PhoneAuthProvider.getCredential(otpId,t2.getText().toString());
                    signInWithPhoneAuthCredential(credential);
                }

            }
        });
    }

    private void initiateotp() {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                       otpId=s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                        signInWithPhoneAuthCredential(phoneAuthCredential);

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });        // OnVerificationStateChangedCallbacks
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

//                            FirebaseUser user=task.getResult().getUser();
//
//
//                            if (user != null) {
//                                String userId=user.getUid();
//                                Users users = new Users(userId,
//                                        "",
//                                        user.getPhoneNumber(),
//                                        "",
//                                        "",
//                                        "",
//                                        "",
//                                        "",
//                                        "",
//                                        "");
//
//                                firestore.collection("Users").document("UserInfo").collection(userId)
//                                        .add(users).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                                    @Override
//                                    public void onSuccess(DocumentReference documentReference) {
                                        startActivity(new Intent(ManageOtp.this, SetUserInfoActivity.class));
                                        finish();

//                                    }
//                                });
//                            }


                            }else  {
                                Toast.makeText(getApplicationContext(),"something Error",Toast.LENGTH_LONG).show();

                        }

                    }
                });
    }
}