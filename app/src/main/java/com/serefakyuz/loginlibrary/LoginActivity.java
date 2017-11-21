package com.serefakyuz.loginlibrary;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.serefakyuz.loginformlib.util.EmailUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText mEditTextEmail;

    public static void startLoginActivity(Context context){
        context.startActivity( new Intent(context, LoginActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEditTextEmail = findViewById(R.id.EditTextEmail);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.TextViewLogin:
                checkIsMailValid(mEditTextEmail.getText().toString());
                break;
        }
    }

    private void checkIsMailValid(String s) {
        if(!EmailUtil.isEmailMatchesPattern(s)){
            Toast.makeText(this, R.string.mail_validation_fail, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, R.string.mail_validation_success, Toast.LENGTH_SHORT).show();
        }
    }
}
