package com.agoodkissapp.mvpdaggertesting.Login;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

/**
 * Created by doktor on 8/25/2015.
 */
public interface LoginView extends MvpView {
    void onLoginSuccess();
    void onLoginFailure();
    void showLoading();
}
