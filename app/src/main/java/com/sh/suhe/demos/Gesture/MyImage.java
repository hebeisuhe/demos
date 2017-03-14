package com.sh.suhe.demos.Gesture;

import android.content.Context;
import android.gesture.Gesture;
import android.support.v7.widget.TintContextWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by suhe on 2017/3/14.
 * com.sh.suhe.demos.Gesture
 */

public class MyImage extends android.support.v7.widget.AppCompatImageView implements
        GestureDetector.OnGestureListener,View.OnTouchListener {
    static String TAG = MyImage.class.getSimpleName();
    GestureDetector gd;
    Context context;
    public MyImage(Context context) {
        super(context);
        this.context = context;
        setFocusable(true);
        requestFocus();
        this.setLongClickable(true);
        this.setOnTouchListener(this);
        setFocusable(true);
        gd = new GestureDetector(context,this);// 这里或者可以直接传递this参数，因为本类已经继承了OnGestureListener接口，也可以把new
        // MySimpleGesture()，它继承了SimpleOnGestureListener类；，两种方法都可以，只是把两种方法归在一个里面，方便学习；
        // 。实惠屏幕触控事件；
        gd.setIsLongpressEnabled(true);
    }
    public MyImage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.context = context;
        setFocusable(true);
        requestFocus();
        this.setLongClickable(true);
        this.setOnTouchListener(this);
        setFocusable(true);
        gd = new GestureDetector(context,this);// 这里或者可以直接传递this参数，因为本类已经继承了OnGestureListener接口，也可以把new
        // MySimpleGesture()，它继承了SimpleOnGestureListener类；，两种方法都可以，只是把两种方法归在一个里面，方便学习；
        // 。实惠屏幕触控事件；
        gd.setIsLongpressEnabled(true);
    }

    public MyImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(TintContextWrapper.wrap(context), attrs, defStyleAttr);
        this.context = context;
        setFocusable(true);
        requestFocus();
        this.setLongClickable(true);
        this.setOnTouchListener(this);
        setFocusable(true);
        gd = new GestureDetector(context,this);// 这里或者可以直接传递this参数，因为本类已经继承了OnGestureListener接口，也可以把new
        // MySimpleGesture()，它继承了SimpleOnGestureListener类；，两种方法都可以，只是把两种方法归在一个里面，方便学习；
        // 。实惠屏幕触控事件；
        gd.setIsLongpressEnabled(true);

    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.d(TAG,"onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.d(TAG,"onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.d(TAG,"onSingleTapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.d(TAG,"onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.d(TAG,"onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        // TODO Auto-generated method stub
        Log.d(TAG,"onFling");
        // 参数解释：
        // e1：第1个ACTION_DOWN MotionEvent
        // e2：最后一个ACTION_MOVE MotionEvent
        // velocityX：X轴上的移动速度，像素/秒
        // velocityY：Y轴上的移动速度，像素/秒

        // 触发条件 ：
        // X轴的坐标位移大于FLING_MIN_DISTANCE，且移动速度大于FLING_MIN_VELOCITY个像素/秒
        final int FLING_MIN_DISTANCE = 100, FLING_MIN_VELOCITY = 200;
        if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE
                && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
            // Fling left
            Log.i("MyGesture", "Fling left");
            Toast.makeText(context, "Fling Left", Toast.LENGTH_SHORT).show();
        } else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE
                && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
            // Fling right
            Log.i("MyGesture", "Fling right");
            Toast.makeText(context, "Fling Right", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d(TAG,"onTouch");
        return gd.onTouchEvent(event);
    }
}
