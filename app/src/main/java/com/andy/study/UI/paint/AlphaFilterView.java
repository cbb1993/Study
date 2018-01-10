package com.andy.study.UI.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.andy.study.R;

/**
 * 图片滤镜处理
 * Created by 坎坎 on 2018/1/4.
 */

public class AlphaFilterView extends View {

    Paint paint;

    Bitmap bitmap;

    public AlphaFilterView(Context context, @Nullable AttributeSet attrs) {
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
        setLayerType(View.LAYER_TYPE_SOFTWARE,null);

        RectF rectF = new RectF(0,100,bitmap.getWidth(),bitmap.getHeight());
        paint.reset();
        paint.setColor(Color.RED);

        /**
         * Create a blur maskfilter.
         *
         * @param radius 阴影的半径
         * @param style  NORMOL -- 整个图像都被模糊掉
         *               SOLID -- 图像边界外产生一层与Paint颜色一致阴影效果，不影响图像的本身
         *               OUTER -- 图像边界外产生一层阴影，并且将图像变成透明效果
         *               INNER -- 在图像内部边沿产生模糊效果
         * @return
         */
//        paint.setMaskFilter(new BlurMaskFilter(100, BlurMaskFilter.Blur.INNER));

        /**
         * Create an emboss maskfilter
         *
         * @param direction  指定光源的位置，长度为xxx的数组标量[x,y,z]
         * @param ambient    环境光的因子 （0~1），越接近0，环境光越暗
         * @param specular   镜面反射系数 越接近0，镜面反射越强
         * @param blurRadius 模糊半径 值越大，模糊效果越明显
         */
        paint.setMaskFilter(new EmbossMaskFilter(new float[]{1,1,1},0.2f,60,80));


        canvas.drawBitmap(bitmap,null,rectF,paint);
    }
}
