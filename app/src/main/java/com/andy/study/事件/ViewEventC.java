package com.andy.study.事件;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.andy.study.R;

public class ViewEventC extends Activity {

    private View iv ;
    private View ll;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);


        iv= findViewById(R.id.iv);



    }
}

/**
 * 事件传递
 * */
