package com.andy.study.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.andy.study.R;
import com.andy.study.mvp.model.User;
import com.andy.study.mvp.presenter.UserLoginPresenter;

/**
 * Created by 坎坎 on 2018/1/23.
 */

public class LoginActivity extends AppCompatActivity implements IUserLoginView {

    private EditText ev_name, ev_password;
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ev_name=findViewById(R.id.ev_name);
        ev_password=findViewById(R.id.ev_password);
    }

    public void login(View v){
        mUserLoginPresenter.login();
    }

    @Override
    public String getUserName() {
        return ev_name.getText().toString();
    }

    @Override
    public String getPassword() {
        return ev_password.getText().toString();
    }

    @Override
    public void clearUserName() {

    }

    @Override
    public void clearPassword() {

    }

    @Override
    public void showLoading() {
            Log.e("LoginActivity：","loading...show");
    }

    @Override
    public void hideLoading() {
        Log.e("LoginActivity：","loading...dismiss");
    }

    @Override
    public void toMainActivity(User user) {
        Log.e("LoginActivity：","success");
    }

    @Override
    public void showFailedError() {
        Log.e("LoginActivity：","failed");
    }
}
