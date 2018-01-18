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
import android.util.Log;
import android.view.View;

/**
 * Created by 坎坎 on 2018/1/17.
 */

public class SearchTestView extends View{
    private Paint mPaint;
    private Path mPath;
    private PathMeasure mPathMeasure;
    private float length;
    private float mAnimatorValue;
    private Path searchPath;
    private Path circlePath;

    public SearchTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath=new Path();
        circlePath=new Path();
        circlePath.addCircle(200,200,100, Path.Direction.CCW);
        mPath.moveTo(400,200);
        mPath.lineTo(300,200);
        mPath.addPath(circlePath);
        mPath.close();
        searchPath=new Path();

        mPathMeasure=new PathMeasure(mPath,true);
        mPathMeasure.setPath(circlePath,true);
        length=mPathMeasure.getLength();
        Log.e("=========","==="+length);

        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mAnimatorValue = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setDuration(10000);
        valueAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        searchPath.reset();
        float stop = (1-mAnimatorValue)*length;
        float start = 0;
        mPathMeasure.getSegment(start, stop, searchPath, true);

        canvas.drawPath(mPath,mPaint);
    }
}
