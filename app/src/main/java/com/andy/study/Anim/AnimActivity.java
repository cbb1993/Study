package com.andy.study.Anim;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAnim2();
            }
        });
    }

    private void doAnim1(){
        ObjectAnimator.ofFloat(iv,"translationY",-100).start();
    }

    private void doAnim2(){
        ValueAnimator colorAnim = ObjectAnimator.ofInt(iv,"backgroundColor",0xffff8080,0xff8080ff);
        colorAnim.setDuration(3000);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatCount(ValueAnimator.INFINITE);
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.start();
    }

}
/**
 *   propertyName ：表示属性动画的作用对象的属性的名称
 *   duration ：表示动画的时长
 *   valueFrom ：表示属性的起始值
 *   valueTo ：表示属性的结束值
 *   startOffset ： 表示动画的延迟时间，当动画开始后，需要延迟多少毫秒才会真正播放此动画
 *   repeatCount ： 表示动画的重复次数  默认为0  -1表示无限循环
 *   repeatMode ： 表示动画的重复模式  repeat表示连续重复  reverse表示逆向重复
 *   valueType ： 表示propertyName所指定的属性的类型，又‘intType’和‘floatType’两个可选项，分别表示属性的类型为整型和浮点型
 *                但是如果属性名是表示颜色，则不需要指定valueType
* */
