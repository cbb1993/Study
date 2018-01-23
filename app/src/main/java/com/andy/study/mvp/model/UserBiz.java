package com.andy.study.mvp.model;

import android.util.Log;

/**
 * Created by 坎坎 on 2018/1/23.
 */

public class UserBiz implements IUser {
    @Override
    public void login(final String name, final String password, final OnLoginListener loginListener) {
    //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("111".equals(name) && "123".equals(password))
                {
                    User user = new User();
                    user.setName(name);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
