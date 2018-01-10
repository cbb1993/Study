package com.andy.study.UI.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.andy.study.R;

/**
 *混合滤镜图片处理
 * Created by 坎坎 on 2018/1/10.
 */

public class FilterView extends View{

    Paint paint;
    Bitmap bitmap;
    private int progress;

    public FilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.xyjy2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //关闭view的硬件加速
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        RectF rectF = new RectF(0, 100, bitmap.getWidth(), bitmap.getHeight());
        paint.reset();
        paint.setColor(Color.RED);

        ColorMatrix colorMartrix = new ColorMatrix();
        //亮度
        //colorMartrix.setScale(1.2f,1.2f,1.2f,1);
        //饱和度
//        colorMartrix.setSaturation(progress);
        //色调
        //aixs-- 0 红色轴，1，绿色，2，蓝色
        // degrees -- 旋转的角度
//        colorMartrix.setRotate(1,progress);
        // 混合多个colorMartrix 叠加
        //colorMartrix.setConcat(matA,matB);
//        paint.setColorFilter(new ColorMatrixColorFilter(colorMartrix));
        // LightingColorFilter只是修改RGB值
        //paint.setColorFilter(new LightingColorFilter(0x00ff00,0xff0000));
//        paint.setColorFilter(new LightingColorFilter(0xffffff,progress));
        //混合过滤器
//        paint.setColorFilter(new PorterDuffColorFilter(Color.BLUE, PorterDuff.Mode.DST_IN));
//        paint.setColorFilter(new PorterDuffColorFilter(Color.argb(255,140,90,200), PorterDuff.Mode.MULTIPLY));
        canvas.drawBitmap(bitmap,null, rectF,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                progress += 1f;
                //progress += 20f;
//                progress = 0xff0000;
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
//                progress = 0x000000;
//                invalidate();
                break;
        }
        return true;

    }
}
