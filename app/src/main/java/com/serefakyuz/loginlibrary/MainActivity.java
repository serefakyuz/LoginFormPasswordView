package com.serefakyuz.loginlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.serefakyuz.loginformlib.VisiblePasswordView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.TextViewLogin:
                LoginActivity.startLoginActivity(this);
                break;
            case R.id.TextViewSignUp:
                SignupActivity.startSignUpActivity(this);
                break;
        }
    }
}
