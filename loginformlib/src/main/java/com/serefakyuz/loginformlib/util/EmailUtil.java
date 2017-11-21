package com.serefakyuz.loginformlib.util;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by seref-akyuz on 8/15/17.
 */

public class EmailUtil {

    /**
     *
     * @param email
     * @return
     */
    public static final boolean isEmailValid(String email){
        return isEmailEmpty(email) && isEmailMatchesPattern(email);
    }

    /**
     *
     * @param email
     * @return
     */
    public static final boolean isEmailEmpty(String email){
        return TextUtils.isEmpty(email);
    }

    /**
     *
     * @param email
     * @return
     */
    public static final boolean isEmailMatchesPattern(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
