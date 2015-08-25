package com.agoodkissapp.mvpdaggertesting;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.agoodkissapp.mvpdaggertesting.Login.LoginPresenter;
import com.agoodkissapp.mvpdaggertesting.Login.LoginView;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends MvpActivity<LoginView, LoginPresenter> implements LoginView {

    public static String TAG = "MainActivity";

    @Bind(R.id.et_username) EditText etUsername;

    @Bind(R.id.et_password) EditText etPassword;

    @OnClick(R.id.button)
    public void login(){
        presenter.login(etUsername.getText().toString(), etPassword.getText().toString());
    }

    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onLoginFailure() {
        Log.d(TAG, "login failure");
    }

    @Override
    public void onLoginSuccess() {
        Log.d(TAG, "login success");
    }

    @Override
    public void showLoading(){

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
