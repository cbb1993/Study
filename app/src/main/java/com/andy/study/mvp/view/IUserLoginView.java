package com.andy.study.mvp.view;

import com.andy.study.mvp.model.User;

/**
 * Created by 坎坎 on 2018/1/23.
 */

public interface IUserLoginView
{
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

}
