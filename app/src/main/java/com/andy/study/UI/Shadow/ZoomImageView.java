package com.andy.study.UI.Shadow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.andy.study.R;

/**
 * 放大镜效果图
 * Created by 坎坎 on 2017/12/21.
 */
public class ZoomImageView extends View {
    private Bitmap mBitmap;
    private Bitmap mScaleBitmap;
    private ShapeDrawable mShapeDrawable;
    private Matrix matrix;
    private static final int FACTOR = 2; //放大系数
    private static final int RADIUS = 100;//放大镜半径
    public ZoomImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mBitmap= BitmapFactory.decodeResource(getResources(),R.drawable.test_img);

        //放大镜
        mScaleBitmap=Bitmap.createScaledBitmap(mBitmap,mBitmap.getWidth() * FACTOR
                                                ,mBitmap.getHeight() * FACTOR,true);
        BitmapShader bitmapShader= new BitmapShader(mScaleBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        mShapeDrawable=new ShapeDrawable(new OvalShape());
        mShapeDrawable.getPaint().setShader(bitmapShader);
        mShapeDrawable.setBounds(0,0,RADIUS*2,RADIUS*2);

        matrix=new Matrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 1 .画原图
        canvas.drawBitmap(mBitmap,0,0,null);

        //2 .画放大镜的图
        mShapeDrawable.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x= (int) event.getX();
        int y= (int) event.getY();
        //手指移动时  将放大的整张大图向相反的位置移动  显示的放大镜才能显示正确图片
        matrix.setTranslate(RADIUS - x * FACTOR ,RADIUS - y * FACTOR);
        mShapeDrawable.getPaint().getShader().setLocalMatrix(matrix);
        mShapeDrawable.setBounds(x-RADIUS,y-RADIUS,x+RADIUS,y+RADIUS);
        invalidate();
        return true;
    }
}
