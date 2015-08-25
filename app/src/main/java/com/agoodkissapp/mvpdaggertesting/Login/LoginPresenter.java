package com.agoodkissapp.mvpdaggertesting.Login;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

/**
 * Created by doktor on 8/25/2015.
 */
public class LoginPresenter extends MvpBasePresenter<LoginView> {

    public void login(String uname, String passwrd){
        if (uname.equals("a") && passwrd.equals("a")){
            getView().onLoginSuccess();
        }else{
            getView().onLoginFailure();
        }
    }
}
