package com.serefakyuz.loginformlib;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;


/**
 * Created by seref-akyuz on 1/23/17.
 */
public class NewPasswordTextWatcher implements TextWatcher {


    private int minPassLength;
    private int strongPassLengthLimit;

    private Context mContext;
    private TextView mTextViewPassStatus;

    public NewPasswordTextWatcher(Context context, TextView textView, int minPassLength, int strongPassLengthLimit){
        this.mContext = context;
        this.mTextViewPassStatus = textView;
        this.minPassLength = minPassLength;
        this.strongPassLengthLimit = strongPassLengthLimit;
        mTextViewPassStatus.setText(String.format(mContext.getResources().getString(R.string.invalid_password), minPassLength));
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        switch (getPasswordStatus(s.toString())){
            case INVALID:
                mTextViewPassStatus.setText(String.format(mContext.getResources().getString(R.string.invalid_password), minPassLength));
                mTextViewPassStatus.setTextColor(mContext.getResources().getColor(R.color.invalid_pass));
                break;
            case WEAK:
                mTextViewPassStatus.setText(R.string.weak_password);
                mTextViewPassStatus.setTextColor(mContext.getResources().getColor(R.color.weak_pass));
                break;
            case NORMAL:
                mTextViewPassStatus.setText(R.string.normal_password);
                mTextViewPassStatus.setTextColor(mContext.getResources().getColor(R.color.normal_pass));
                break;
            case STRONG:
                mTextViewPassStatus.setText(R.string.strong_password);
                mTextViewPassStatus.setTextColor(mContext.getResources().getColor(R.color.strong_pass));
                break;
        }
    }


    private PasswordValidationState getPasswordStatus(String password){
        if(password.length() < minPassLength){
            return PasswordValidationState.INVALID;
        }
        if(password.matches("^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]+$")){
            if(password.length() >= strongPassLengthLimit){
                return PasswordValidationState.STRONG;
            }else{
                return PasswordValidationState.NORMAL;
            }
        }else{
            if(password.length() >= strongPassLengthLimit){
                return PasswordValidationState.NORMAL;
            }else{
                return PasswordValidationState.WEAK;
            }
        }
    }
}
