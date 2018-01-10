package com.andy.study.UI.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.andy.study.R;

/**
 * RGB  Matrix 滤镜图片处理
 * Created by 坎坎 on 2018/1/10.
 */

public class ColorMatrixFilterView extends View{
    Paint paint;

    Bitmap bitmap;

    public ColorMatrixFilterView(Context context, @Nullable AttributeSet attrs) {
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

        //默认
       /* ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                1,0,0,0,0,
                0,1,0,0,0,
                0,0,1,0,0,
                0,0,0,1,0
        });*/

        // 平移运算---加法
       /* ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                1,0,0,0,0,
                0,1,0,0,100,
                0,0,1,0,0,
                0,0,0,1,0
        });*/
        // 反相效果 -- 底片效果
        /*ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                -1, 0,0,0,255,
                0,-1,0,0,255,
                0,0,-1,0,255,
                0,0,0,1,0
        });*/
        // 缩放运算---乘法 -- 颜色增强
        /*ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                1.2f, 0,0,0,0,
                0,1.2f,0,0,0,
                0,0,1.2f,0,0,
                0,0,0,1.2f,0,
        });*/

        // 黑白照片
        // 去色原理：只要把R G B 三通道的色彩信息设置成一样，那么图像就会变成灰色，
        // 同时为了保证图像亮度不变，同一个通道里的R+G+B =1
        //
      /*  ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                0.213f, 0.715f,0.072f,0,0,
                0.213f, 0.715f,0.072f,0,0,
                0.213f, 0.715f,0.072f,0,0,
                0,0,0,1,0,
        });*/

        // 发色效果---（比如红色和绿色交换）
        /*ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                0,1,0,0,0,
                1, 0,0,0,0,
                0,0,1,0,0,
                0,0,0,1,0,
        });*/
        // 复古效果
       /* ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                1/2f,1/2f,1/2f,0,0,
                1/3f, 1/3f,1/3f,0,0,
                1/4f,1/4f,1/4f,0,0,
                0,0,0,1,0,
        });*/
        // 颜色通道过滤
        ColorMatrix colorMartrix = new ColorMatrix(new float[]{
                1, 0,0,0,0,
                0,0,0,0,0,
                0,0,0,0,0,
                0,0,0,1,0,
        });

        paint.setColorFilter(new ColorMatrixColorFilter(colorMartrix));
        canvas.drawBitmap(bitmap,null, rectF,paint);
    }
}
