package com.andy.study.UI.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

import com.andy.study.R;

/**
 * Created by 坎坎 on 2018/1/10.
 */

public class MyCanvasView extends View{

    private Bitmap mBitmap;
    private BitmapShader mBitmapShader;

    public MyCanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);

        /*-------绘制图片--------*/
     /*   mBitmap = ((BitmapDrawable)getResources().getDrawable(R.drawable.xyjy2)).getBitmap();
        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paint.setShader(mBitmapShader);
        paint.setAntiAlias(true);
        canvas.drawRect(0, 0, 1500, 1500, paint);*/

        /*--------绘制直线---------*/
       /* canvas.drawLine(0, 0, 100, 100, paint);
        float []pts = {0,0,100,100,200,200,300,300};
		canvas.drawLines(pts, paint);*/

       /*---------绘制点---------*/
//         canvas.drawPoint(500, 500, paint);
       /* float []pts = {0,0,100,100,200,200,300,300};
		canvas.drawPoints(pts, paint);*/

		/*---------绘制矩形-----------*/
        //Rect int和RectF float
	/*	RectF r = new RectF(100, 100, 400, 500);
		canvas.drawRect(r, paint);*/
//		canvas.drawRect(left, top, right, bottom, paint);

        /*---------绘制圆角矩形-----------*/
        //x-radius ,y-radius圆角的半径
        /*RectF r = new RectF(100, 100, 400, 500);
		canvas.drawRoundRect(r, 30, 30, paint);*/

        /*---------绘制圆-----------*/
//        canvas.drawCircle(300, 300, 200, paint);

         /*---------绘制椭圆-----------*/
       /* RectF r = new RectF(100, 100, 400, 500);
        canvas.drawOval(r, paint);*/

       /*---------绘制扇形-----------*/
        //		canvas.drawArc(
//				r,
//				startAngle, //其实角度，相对X轴正方向
//				sweepAngle, //画多少角度的弧度
//				useCenter, //boolean, false：只有一个纯弧线；true：闭合的边
//				paint)；
        /**
         * @param oval  矩形区域
         *@param startAngle 其实角度，相对X轴正方向
         *@param sweepAngle, 画多少角度的弧度
         *@param useCenter, boolean, false：只有一个纯弧线；true：闭合的边
         *@param paint
        * */
      /*  RectF r = new RectF(100, 100, 400, 400);
		canvas.drawArc(r, 0, 90, true, paint);*/

       /*---------绘制路径-----------*/
      /*  Path path = new Path();
		path.moveTo(100, 100);//画笔落笔的位置
		//移动
		path.lineTo(200, 100);
		path.lineTo(200, 200);
		path.cubicTo(250, 200, 350, 300, 450, 400);
		path.close();
		canvas.drawPath(path, paint);*/

        /*---------圆角矩形路径-----------*/
        /*RectF r = new RectF(100, 100, 600, 800);
        Path path = new Path();
        float radii[] = {10,10,10,10,10,10,50,60};
        path.addRoundRect(r, radii, Path.Direction.CCW);
        canvas.drawPath(path, paint);*/

        /*---------path和region交集-----------*/
       /* Path path = new Path();
        RectF r = new RectF(100, 100, 800, 200);
        path.addRect(r, Path.Direction.CCW);
        Region region = new Region(100, 100, 200, 800);
        Region region1 = new Region();
        region1.setPath(path, region);//path的椭圆区域和矩形区域进行交集
        //结合区域迭代器使用（得到图形里面的所有的矩形区域）
        RegionIterator iterator = new RegionIterator(region1);
        Rect rect = new Rect();
        while (iterator.next(rect)) {
            canvas.drawRect(rect, paint);
        }*/

       /*------region和region的重叠---------*/
      /*  Region region = new Region(100, 100, 200, 800);
        Region region1 = new Region(100, 100, 800, 200);
        *//**
         * @param op DIFFERENCE 补集
         *           INTERSECT 交集
         *           REPLACE 替换
         *           REVERSE_DIFFERENCE 反转补集
         *           UNION 并集
         *           XOR 异并集
        * *//*
        region1.op(region, Region.Op.INTERSECT);
        RegionIterator iterator = new RegionIterator(region1);
        Rect rect = new Rect();
        while (iterator.next(rect)) {
            canvas.drawRect(rect, paint);
        }*/
    }
}
