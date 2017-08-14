package com.serefakyuz.loginformlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by seref-akyuz on 10/24/16.
 */
public class NewPasswordView extends LinearLayout {
    private static final int DEFAULT_MIN_PASS_LENGTH = 6;
    private static final int DEFAULT_STRONG_PASS_LENGTH_LIMIT = 10;
    private static final int VIEW_TYPE_NEW_PASSWORD_VIEW = 0;
    private static final int VIEW_TYPE_CONFIRM_PASSWORD_VIEW = 1;

    private EditText mEditTextPassword;
    public TextView mTextViewPassStatus;

    private LayoutInflater mInflater;
    private TypedArray mTypedArray;

    public NewPasswordView(Context context) {
        super(context);
        mInflater = LayoutInflater.from(context);
        init(context);
    }

    public NewPasswordView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = LayoutInflater.from(context);
        mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.PasswordView, 0, 0);
        init(context);
    }

    public NewPasswordView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(context);
        mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.PasswordView, defStyleAttr, 0);
        init(context);
    }

    public void setConfirmPasswordTextWatcher(Context context, NewPasswordView passwordView){
        setPasswordStatusVisibility(VISIBLE);
        mEditTextPassword.addTextChangedListener(new ConfirmPasswordTextWatcher(context, mTextViewPassStatus, passwordView));
        mTextViewPassStatus.setText("");
    }


    private void init(Context context){
        View view = mInflater.inflate(R.layout.view_new_password, this, true);
        mEditTextPassword = (EditText) view.findViewById(R.id.EditTextPassword);
        mTextViewPassStatus = (TextView) view.findViewById(R.id.TextViewPasswordStatus);



        String hint = mTypedArray.getString(R.styleable.PasswordView_passwordHint);
        Drawable etBackgroundColor = mTypedArray.getDrawable(R.styleable.PasswordView_etBackground);
        int etTextColor = mTypedArray.getInt(R.styleable.PasswordView_etTextColor, R.color.black);
        int minPassLength = mTypedArray.getInt(R.styleable.PasswordView_minPassLength, DEFAULT_MIN_PASS_LENGTH);
        int strongPassLengthLimit = mTypedArray.getInt(R.styleable.PasswordView_strongPassLengthLimit, DEFAULT_STRONG_PASS_LENGTH_LIMIT);
        int textColorHint = mTypedArray.getInt(R.styleable.PasswordView_passwordHintColor, R.color.dark_gray);
        int viewType = mTypedArray.getInt(R.styleable.PasswordView_viewType, 0);


        try {
            mEditTextPassword.setHint(hint);
        }catch (NullPointerException ex){
        }

        try {
            mEditTextPassword.setBackground(etBackgroundColor);
        }catch (NullPointerException ex){
        }
        mEditTextPassword.setTextColor(etTextColor);
        mEditTextPassword.setHintTextColor(textColorHint);
        if(viewType == VIEW_TYPE_NEW_PASSWORD_VIEW) {
            mEditTextPassword.addTextChangedListener(new NewPasswordTextWatcher(context, mTextViewPassStatus, minPassLength, strongPassLengthLimit));
        }else if(viewType == VIEW_TYPE_CONFIRM_PASSWORD_VIEW){
            mTextViewPassStatus.setVisibility(GONE);
        }
        mTypedArray.recycle();
    }

    public String getPassword(){
        return mEditTextPassword.getText().toString().trim();
    }

    /**
     *
     * @param color
     */
    public void setPasswordETTextColor(int color){
        mEditTextPassword.setTextColor(color);
    }

    /**
     *
     * @param color
     */
    public void setPasswordETBackgroundColor(int color){
        mEditTextPassword.setBackgroundColor(color);
    }

    /**
     *
     * @param resId
     */
    public void setPasswordETBackgroundResource(int resId){
        mEditTextPassword.setBackgroundResource(resId);
    }

    /**
     *
     * @param color
     */
    public void setPasswordStatusTextViewTextColor(int color){
        mTextViewPassStatus.setTextColor(color);
    }

    /**
     *
     * @param color
     */
    public void setPasswordStatusTextViewBackgroundColor(int color){
        mTextViewPassStatus.setBackgroundColor(color);
    }

    /**
     *
     * @param resId
     */
    public void setPasswordStatusTextViewBackgroundResource(int resId){
        mTextViewPassStatus.setBackgroundResource(resId);
    }

    /**
     *
     * @param visibility
     */
    public void setPasswordStatusVisibility(int visibility){
        mTextViewPassStatus.setVisibility(visibility);
    }


    public boolean isEmpty(){
        return TextUtils.isEmpty(mEditTextPassword.getText());
    }

    public void setEnabled(boolean isEnabled){
        mEditTextPassword.setEnabled(isEnabled);
    }

}
