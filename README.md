# LoginFormPasswordView
The library contains two type of password fields as a custom view for login(VisiblePasswordView) and signup(NewPasswordView).

#Features

1. Visible passwords
2. Password matching while confirming passwords
3. Determining password strength level
4. Min password length

#VisiblePasswordView 

Contains two component. One of them is a password field. Second one is an ImageView to show password.

**Sample**

```xml
    <com.serefakyuz.loginformlib.VisiblePasswordView
        android:id="@+id/VisiblePasswordView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:maxWidth="@dimen/form_et_max_width"
        app:passwordHint = "@string/password"
        app:passwordHintColor="@color/white_hint"
        />
```
# NewPasswordView

Contains two component. First one is a password field. Second one is an TextView that shows password status dynamically. There are four password status: INVALID, WEAK, NORMAL, STRONG. There is a simple password strength level determiner implementation.

There are two types of NewPasswordView. The types are **newPasswordView** and **confirmPasswordView**. Types are selected in xml by view attributes:

```xml
app:viewType="newPasswordView"
app:viewType="confirmPasswordView"
```


**Sample**

```xml
    
    <com.serefakyuz.loginformlib.NewPasswordView
            android:id="@+id/NewPasswordView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:maxWidth="@dimen/form_et_max_width"
            app:passwordHint = "@string/password"
            app:passwordHintColor="@color/white_hint"
            app:etTextColor="@color/colorPrimary"
            app:minPassLength="7"
            app:strongPassLengthLimit="10"
            app:viewType="newPasswordView"
            />

    <com.serefakyuz.loginformlib.NewPasswordView
        android:id="@+id/ConfirmPasswordView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:maxWidth="@dimen/form_et_max_width"
        app:passwordHint = "@string/password"
        app:passwordHintColor="@color/white_hint"
        app:etTextColor="@color/colorPrimary"
        app:viewType="confirmPasswordView"
        />
```


Full attribute list which is created both VisiblePasswordView and NewPasswordView is below:


```xml
    
<declare-styleable name="PasswordView">
   <attr name="passwordHint" format="string"/>
   <attr name="passwordHintColor" format="integer"/>
   <attr name="etBackground" format="integer"/>
   <attr name="etTextColor" format="integer"/>
   <attr name="showPasswordImageSrc" format="integer"/>
   <attr name="minPassLength" format="integer"/>
   <attr name="strongPassLengthLimit" format="integer"/>
   <attr name="viewType" format="enum">
       <enum name="newPasswordView" value="0"/>
       <enum name="confirmPasswordView" value="1"/>
   </attr>
</declare-styleable>
```
