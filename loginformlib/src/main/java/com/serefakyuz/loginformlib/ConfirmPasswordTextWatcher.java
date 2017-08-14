package com.serefakyuz.loginformlib;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;


/**
 * Created by seref-akyuz on 1/23/17.
 */
public class ConfirmPasswordTextWatcher implements TextWatcher {



    private Context mContext;
    private TextView mTextViewPassStatus;
    private NewPasswordView mNewPasswordView;

    public ConfirmPasswordTextWatcher(Context context, TextView textView, NewPasswordView newPasswordView){
        this.mContext = context;
        this.mTextViewPassStatus = textView;
        this.mNewPasswordView = newPasswordView;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if(s.toString().length() == 0){
            return;
        }
        switch (getPasswordStatus(s.toString())){
            case INVALID:
                mTextViewPassStatus.setText(R.string.passwords_not_matching);
                mTextViewPassStatus.setTextColor(mContext.getResources().getColor(R.color.invalid_pass));
                break;
            default:
                mTextViewPassStatus.setText(R.string.passwords_matched);
                mTextViewPassStatus.setTextColor(mContext.getResources().getColor(R.color.strong_pass));
                break;
        }
    }


    private PasswordValidationState getPasswordStatus(String password){
        if(password.equals(mNewPasswordView.getPassword())){
            return PasswordValidationState.NORMAL;
        }else{
           return PasswordValidationState.INVALID;
        }
    }
}
