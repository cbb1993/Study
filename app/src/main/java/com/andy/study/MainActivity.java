package com.andy.study;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.andy.study.UI.贝塞尔曲线.QqBubble;

/**
 * Created by 坎坎 on 2017/12/21.
 */

public class MainActivity extends Activity{

    private QqBubble mQqBubble;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
