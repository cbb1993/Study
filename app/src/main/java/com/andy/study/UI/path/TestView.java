package com.andy.study.UI.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 坎坎 on 2018/1/17.
 */

public class TestView extends View{
    private Paint mPaint;

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(2);
    }

    /**
     *  1.rLineTo，rMoveTo 带r开头 前一个点的相对位置  ,   LineTo，MovoTo 不带r开头的，传的是我们的绝对位置
     *  2.Path.Direction.CCW 顺时针  , Path.Direction.CW 逆时针
     *  3.如果有多次绘制 ，需调用 mPath.reset();
     * */

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 测试FillType
//        testFillType(canvas);

        //测试Path.Op
        testPathOp(canvas);
    }

    /**
     *  WINDING 模式 --- 取Path所有所在的区域 -- 默认的模式
     *  EVEN_ODD 模式 --- 取Path所在不相交的区域
     *  INVERSE_WINDING 模式 -- 取path所有未占的区域
     *  INVERSE_EVEN_ODD 模式 --- 取path所有未占和相交的区域
    * */
    private void testFillType(Canvas canvas){
        Path mPath = new Path();
        mPath.offset(100,100);
        mPath.addCircle(200, 200, 100, Path.Direction.CW);
        mPath.addCircle(300, 300, 100, Path.Direction.CW);
        mPath.setFillType(Path.FillType.EVEN_ODD);
        canvas.drawPath(mPath,mPaint);
    }

    /**
     *  DIFFERENCE -- 减去Path2后Path1区域剩下的部分
     *  INTERSECT --- 保留Path2 和 Path1 共同的部分
     *  UNION -- 保留Path1 和 Path 2
     *  XOR --- 保留Path1 和 Path2 还有共同的部分
     *  REVERSE_DIFFERENCE --- 减去Path1后Path2区域剩下的部分
    * */
    private void testPathOp(Canvas canvas){
        Path path1 = new Path();
        path1.addCircle(150, 150, 100, Path.Direction.CW);
        Path path2 = new Path();
        path2.addCircle(200, 200, 100, Path.Direction.CW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            path1.op(path2, Path.Op.DIFFERENCE);
        }
        canvas.drawPath(path1, mPaint);
    }
}
