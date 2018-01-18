package com.andy.study.UI.path;

/**
 * Created by 坎坎 on 2018/1/17.
 */

import android.view.View;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static android.animation.ValueAnimator.INFINITE;
import static android.animation.ValueAnimator.REVERSE;

/**
 * Created by fangda on 2017/5/25.
 */

public class STV extends View {
    private static final int DEFAULT = 0;
    private static final int FIRST_ANIM = 1;
    private static final int SECOND_ANIM = 2;

    @IntDef(flag = true,
            value = {
                    DEFAULT,
                    FIRST_ANIM,
                    SECOND_ANIM
            })
    @Retention(RetentionPolicy.SOURCE)
    private @interface STATE {
    }

    private final float SHORT_LENGTH = 30f;
    private final float RADIUS = 200f;
    private final float LINEAR_LENGTH = 200f;

    private @STATE
    int state = DEFAULT;

    private Paint mPaint;
    private Path path;
    private PathMeasure pathMeasure;
    private float position = 0;
    private float circleCircumference;
    private ValueAnimator valueAnimator;

    public STV(Context context) {
        super(context);
        init();
    }

    public STV(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        circleCircumference = (float) (2 * Math.PI * RADIUS);
        RectF rect = new RectF(-RADIUS, -RADIUS, RADIUS, RADIUS);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(4f);

        Path path1 = new Path();
        path1.moveTo(0, 200);
        path1.arcTo(rect, 0, 359.99f, false);
        path1.lineTo(400, 0);
        PathMeasure pathMeasure1 = new PathMeasure(path1, false);
        Toast.makeText(getContext(), "pathMeasure1" + pathMeasure1.getLength(), Toast.LENGTH_SHORT).show();

        path = new Path();
        path.moveTo(RADIUS + LINEAR_LENGTH, 0);
        path.lineTo(RADIUS, 0); //圆的90度起点
        path.arcTo(rect, 0, 359.99f, false);
        pathMeasure = new PathMeasure(path, false);

        Toast.makeText(getContext(), "pathMeasure2" + pathMeasure.getLength(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);
        canvas.rotate(45, 0, 0);
        Path dstPath = new Path();
        switch (state) {
            case DEFAULT:
            case FIRST_ANIM:
                float start = position - (circleCircumference - SHORT_LENGTH - LINEAR_LENGTH);
                pathMeasure.getSegment(start > 0 ? start : 0, pathMeasure.getLength() - position, dstPath, true);
                canvas.drawPath(dstPath, mPaint);
                break;
            case SECOND_ANIM:
                pathMeasure.getSegment(position, position + SHORT_LENGTH, dstPath, true);
                canvas.drawPath(dstPath, mPaint);
                break;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                firstAnim();
                break;
        }
        return super.onTouchEvent(event);
    }

    private void firstAnim() {
        if (valueAnimator != null && valueAnimator.isRunning()) valueAnimator.end();
        state = FIRST_ANIM;
//        Log.e("circleCircumference", circleCircumference + "");
//        Log.e("pathMeasure.length", pathMeasure.getLength() + "");
        valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(0f, circleCircumference - SHORT_LENGTH);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                position = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                secondAnim();
            }
        });
        valueAnimator.start();
    }

    private void secondAnim() {
        state = SECOND_ANIM;
        valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(LINEAR_LENGTH, LINEAR_LENGTH + circleCircumference - SHORT_LENGTH);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(5000);
        valueAnimator.setRepeatMode(REVERSE);
        valueAnimator.setRepeatCount(INFINITE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                position = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();
    }

}

