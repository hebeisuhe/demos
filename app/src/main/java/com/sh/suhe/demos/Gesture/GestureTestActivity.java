package com.sh.suhe.demos.Gesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.sh.suhe.demos.R;

public class GestureTestActivity extends AppCompatActivity {
    static String TAG = GestureTestActivity.class.getSimpleName();
    ImageView gesture_test_img;
    GestureDetector  gDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_test);
        gesture_test_img = (ImageView) findViewById(R.id.gesture_test_img);
    }
    private View.OnTouchListener gestureTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return gDetector.onTouchEvent(event);
        }
    };

    public class MySimpleOnGestureListener  extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDown(MotionEvent e) {
            //填写自己要处理的代码
            Log.d(TAG,"onDown");
             return false;
            //
        }

        @Override
        public boolean onContextClick(MotionEvent e) {
            Log.d(TAG,"onContextClick");
            return super.onContextClick(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.d(TAG,"onDoubleTap");
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.d(TAG,"onDoubleTapEvent");
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.d(TAG,"onFling");
            return super.onFling(e1, e2, velocityX, velocityY);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.d(TAG,"onScroll");
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            Log.d(TAG,"onSingleTapConfirmed");
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.d(TAG,"onSingleTapUp");
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            Log.d(TAG,"onLongPress");
            super.onLongPress(e);
        }

        @Override
        public void onShowPress(MotionEvent e) {
            Log.d(TAG,"onShowPress");
            super.onShowPress(e);
        }
    }

}
