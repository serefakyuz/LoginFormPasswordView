package com.serefakyuz.loginlibrary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.serefakyuz.loginformlib.NewPasswordView;

public class SignupActivity extends AppCompatActivity {

    private NewPasswordView mNewPasswordView;
    private NewPasswordView mConfirmPasswordView;

    public static void startSignUpActivity(Context context){
        context.startActivity( new Intent(context, SignupActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mNewPasswordView = findViewById(R.id.NewPasswordView);
        mConfirmPasswordView = findViewById(R.id.ConfirmPasswordView);
        mConfirmPasswordView.setConfirmPasswordTextWatcher(this, mNewPasswordView);
    }
}
