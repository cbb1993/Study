package com.andy.study.Anim;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.andy.study.R;

/**
 * Created by 坎坎 on 2018/1/24.
 */

public class AnimActivty extends AppCompatActivity{
    ImageView iv;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        iv=findViewById(R.id.iv);

        /*----------属性动画基础-------------*/
        /*iv.setTranslationX(100);

		iv.setScaleX(0.5f);
		iv.setAlpha(0.5f);
		iv.setRotation(90);
        iv.setBackgroundColor(Color.RED);*/
         /*----------只要view里面有setXXX()方法就可以通过反射达到变化的目的-------------*/
		/*ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "translationX", 0f,200f);
		oa.setDuration(500);
		oa.start();*/

        //2.-------------多个动画同时执行----------------------
    }
}
