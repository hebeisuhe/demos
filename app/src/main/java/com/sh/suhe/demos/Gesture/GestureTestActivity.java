package com.sh.suhe.demos.Gesture;

import android.graphics.BitmapFactory;
import android.media.Image;
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
        gesture_test_img.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
    }

}
