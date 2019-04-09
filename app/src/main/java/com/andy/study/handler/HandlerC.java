package com.andy.study.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;

import com.andy.study.R;

public class HandlerC extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        handler.sendEmptyMessage(1);
    }

    static Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

}



/** 基本构成
 *  handler 创建的时候会采用当前线程的Looper来构造消息循环系统
 *  MessageQueue----消息队列（实际是单链表的数据结构）--- 消息存储单元  --- 以队列的形式对外提供插入和删除操作
 *  Looper --线程默认是没有Looper的，如果需使用Handler就必须为线程创建Looper
 *  ThreadLocal -- 可以在每个线程中互不干扰的存储和提取数据 --- 获取每个线程的Looper
 * */



