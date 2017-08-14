package com.serefakyuz.loginformlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * Created by seref-akyuz on 10/24/16.
 */
public class VisiblePasswordView extends LinearLayout {

    private EditText mEditTextPassword;
    private ImageView mImageViewShowPassword;

    private LayoutInflater mInfilater;
    private TypedArray mTypedArray;

    public VisiblePasswordView(Context context) {
        super(context);
        mInfilater = LayoutInflater.from(context);
        init(context);
    }

    public VisiblePasswordView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInfilater = LayoutInflater.from(context);
        mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.PasswordView, 0, 0);
        init(context);
    }

    public VisiblePasswordView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInfilater = LayoutInflater.from(context);
        mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.PasswordView, defStyleAttr, 0);
        init(context);
    }


    private void init(final Context context){
        View view = mInfilater.inflate(R.layout.view_visible_password, this, true);
        mEditTextPassword = (EditText) view.findViewById(R.id.EditTextPassword);
        mImageViewShowPassword = (ImageView) view.findViewById(R.id.ImageViewViewPass);
        final int textType =  mEditTextPassword.getInputType();
        mImageViewShowPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mEditTextPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    mEditTextPassword.setInputType(textType);
                }
                mEditTextPassword.setSelection(mEditTextPassword.getText().toString().length());

                return true;
            }
        });


        String hint = mTypedArray.getString(R.styleable.PasswordView_passwordHint);
        int textColor = mTypedArray.getInt(R.styleable.PasswordView_etTextColor, R.color.white);
        int textColorHint = mTypedArray.getInt(R.styleable.PasswordView_passwordHintColor, R.color.dark_gray);
        try {
            mEditTextPassword.setHint(hint);
        }catch (NullPointerException ex){

        }
        mEditTextPassword.setHintTextColor(textColorHint);
        mEditTextPassword.setTextColor(textColor);
        mTypedArray.recycle();
    }

    /**
     *
     * @return
     */
    public String getPassword(){
        return mEditTextPassword.getText().toString();
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
     * @param resId
     */
    public void setShowPasswordEyeImageResource(int resId){
        mImageViewShowPassword.setImageResource(resId);
    }


    /**
     *
     * @param color
     */
    public void setShowPasswordEyeImageBackgroundColor(int color){
        mImageViewShowPassword.setBackgroundColor(color);
    }

    /**
     *
     * @param resId
     */
    public void setShowPasswordEyeImageBackgroundResource(int resId){
        mImageViewShowPassword.setBackgroundResource(resId);
    }

    /**
     *
     * @return
     */
    public boolean isEmpty(){
        return TextUtils.isEmpty(mEditTextPassword.getText());
    }

}
