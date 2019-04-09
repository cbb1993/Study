package com.andy.study.Anim;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.andy.study.R;

/**
 * Created by 坎坎 on 2018/1/24.
 */

public class AnimActivity extends AppCompatActivity{
    ImageView iv;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        iv=findViewById(R.id.iv);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAnimate(iv,0,1000);
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

    private void performAnimate(final View target, final int start, final int end){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(1,100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            private IntEvaluator intEvaluator =new IntEvaluator();
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                int currentValue =(int) animation.getAnimatedValue();
//                Log.e("anim","value="+currentValue);
                float f =animation.getAnimatedFraction(); // 获得当前动画的比例 0-1
                target.getLayoutParams().width = intEvaluator.evaluate(f,start,end);
                target.requestLayout();
            }
        });
        valueAnimator.setDuration(5000).start();
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


/**
 *   动画生效的两个条件
 *   1. 必须要提供set方法，如果动画的时候没有传递初始值，那么还要提供get方法，因为系统需要获取属性的初始值
 *   2. set方法对属性所做的改变必须能通过某种方法反映出来，比如ui的改变之类的
 *
 *
 *   底层代码都是通过反射set和get属性值的
 * */
