package com.andy.study.mvp.model;

/**
 * Created by 坎坎 on 2018/1/23.
 */

public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
