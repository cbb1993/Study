package com.andy.study.UI.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 坎坎 on 2018/1/10.
 */

public class CanvasStatusTestView extends View {

    public CanvasStatusTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        Rect r1=new Rect(0,0,getWidth(),getHeight());
        canvas.drawRect(r1,paint);

        /*--------------canvas状态栈---------------*/
       /* int id1=canvas.save();//保存状态
            // 绘图坐标系平移
        canvas.translate(100, 100);
        paint.setColor(Color.GREEN);
        Rect r2=new Rect(000,000,100,100);
        canvas.drawRect(r2,paint);
        int id2=canvas.save();//保存状态
           // 绘图坐标系平移
        canvas.translate(100, 100);
        paint.setColor(Color.GREEN);
        Rect r3=new Rect(000,000,100,100);
        canvas.drawRect(r3,paint);
        canvas.restoreToCount(id2);//返回之前保存的状态
        paint.setColor(Color.BLUE);
        Rect r4=new Rect(0,0,100,100);
        canvas.drawRect(r4,paint);*/


        /*-------------------canvas Layer栈-----------------*/

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

            /*------ 入栈-----*/
          /*  paint.setColor(Color.BLUE);
            int id1=canvas.saveLayer(new RectF(100,100,getWidth(),getHeight()),paint);
            RectF r2 = new RectF(0, 0, 200, 200);
            canvas.drawRect(r2,paint); */

            //我们有上面的图可以看出 我们设置开始的是200*200的矩形， 但是我们只绘了一个蓝色100*100的矩形
            //可以看出 r2是绘制在新的layer上的 ，但是layer的绘图坐标系继承的canvas的绘图坐标系，所以还是从0.0开始，
            //得出--》实际绘制区域（100，100，200，200）

         /*-------出栈------*/
            paint.setColor(Color.BLUE);
            int id1=canvas.saveLayer(new RectF(100,100,getWidth(),getHeight()),paint);
            RectF r2 = new RectF(0, 0, 200, 200);
            canvas.drawRect(r2,paint);

            paint.setColor(Color.BLUE);
            int id2=canvas.saveLayer(new RectF(200,200,getWidth(),getHeight()),paint);
            RectF r3 = new RectF(0, 0, 300, 300);
            canvas.drawRect(r3,paint);

            paint.setColor(Color.BLACK);
            canvas.restoreToCount(id2);
            canvas.drawCircle(50,50,50,paint);

            // 经过测试 我们得出  canvas.restoreToCount(id2)方法会将id2层出栈
            //此时 绘图坐标系 （0,0） ，id1为（100,100,getWidth(),getHeight()）
            //当我们绘制circle（50，50，50），是看不见的
            //当坐标原点>100,才能绘制，绘制在id1层
        }

    }
}
