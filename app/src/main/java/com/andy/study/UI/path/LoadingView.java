package com.andy.study.UI.path;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * loading 圆圈
 * Created by 坎坎 on 2018/1/15.
 */

public class LoadingView extends View{
    private Path circlePath;
    private Paint mPaint;
    private Path loadPath;
    private PathMeasure mPathMeasure;
    private float mLength;

    private float mAnimatorValue;

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        circlePath=new Path();
        circlePath.addCircle(300,300,200, Path.Direction.CW);
        loadPath=new Path();
        mPathMeasure=new PathMeasure();
        mPathMeasure.setPath(circlePath,true);
        mLength=mPathMeasure.getLength();

        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mAnimatorValue = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //关闭view的硬件加速
        setLayerType(View.LAYER_TYPE_SOFTWARE,null);

        mPaint.setColor(Color.BLUE);
        canvas.drawPath(circlePath,mPaint);

        mPaint.setColor(Color.RED);
        loadPath.reset();
        float stop = mLength * mAnimatorValue;
        float start = (float) (stop - ((0.5 - Math.abs(mAnimatorValue - 0.5)) * mLength));
        mPathMeasure.getSegment(start, stop, loadPath, true);
        canvas.drawPath(loadPath, mPaint);
    }
}
