package com.andy.study.mvp.model;

/**
 * Created by 坎坎 on 2018/1/23.
 */

public interface IUser {
    void login(String name,String password ,OnLoginListener loginListener);
}
