package com.andy.study.UI.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.andy.study.R;

/**
 * Shader的使用
 * Created by 坎坎 on 2017/12/21.
 */

public class MyGradientView extends View {
    private Bitmap mBitMap;
    private Paint mPaint;
    private int[] mColors={Color.RED,Color.GREEN,Color.GREEN,Color.BLACK};


    public MyGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mBitMap =((BitmapDrawable)getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap();
        mPaint=new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        /**
        *  BitmapShadow
        * */
        //TileMode.CLAMP 边缘像素填充
        //TileMode.MIRROR 镜像
        //TileMode.REPEAT 重复
//        BitmapShader bitmapShader =new BitmapShader(mBitMap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
//        mPaint.setShader(bitmapShader);
//        mPaint.setAntiAlias(true);
//        canvas.drawCircle(200,200,150,mPaint);
        //使用shapeDrawable绘制
        //OvalShape 圆
//        ShapeDrawable shapeDrawable =new ShapeDrawable(new OvalShape());
//        shapeDrawable.getPaint().setShader(bitmapShader);
        // 设置矩形
//        shapeDrawable.setBounds(0,0,200,200);
//        shapeDrawable.draw(canvas);

        /**
         *  LinearGradient
         * */
//        LinearGradient linearGradient =new LinearGradient(250,0,450,200,mColors,null, Shader.TileMode.CLAMP);
//        mPaint.setShader(linearGradient);
//        canvas.drawRect(new Rect(0,0,200,200),mPaint);


        /**
         *  RadialGradient
         * */
//        RadialGradient radialGradient =new RadialGradient(200,450,150,mColors,null, Shader.TileMode.CLAMP);
//        mPaint.setShader(radialGradient);
//        canvas.drawCircle(200,450,150,mPaint);

        /**
         *  SweepGradient
         * */
//        SweepGradient sweepGradient =new SweepGradient(600,450,mColors,null);
//        mPaint.setShader(sweepGradient);
//        canvas.drawCircle(600,450,150,mPaint);


        /**
         *  SweepGradient
         * */
//        ComposeShader composeShader =new ComposeShader(bitmapShader,linearGradient, PorterDuff.Mode.SRC_ATOP);
//        mPaint.setShader(composeShader);
//        canvas.drawRect(new Rect(0,0,200,200),mPaint);
    }
}
