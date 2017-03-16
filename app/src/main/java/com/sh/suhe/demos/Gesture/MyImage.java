package com.sh.suhe.demos.Gesture;

import android.content.Context;
import android.gesture.Gesture;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.TintContextWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by suhe on 2017/3/14.
 * com.sh.suhe.demos.Gesture
 */

public class MyImage extends android.support.v7.widget.AppCompatImageView implements ScaleGestureDetector.OnScaleGestureListener,
         GestureDetector.OnDoubleTapListener,View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    static String TAG = MyImage.class.getSimpleName();
    GestureDetector gd;
    Context context;
    float SCALE_MAX = 4 ;//最大放大比例
    float initScale = 1 ; //最小缩放比例
    /**   当前Matrix*/
    private Matrix mCurrentMatrix = new Matrix();
    /**  模板Matrix，用以初始化 */
    private  Matrix mMatrix=new Matrix();
    float mImageWidth ;//图片宽度
    float mImageHeight; //图片高度
    ScaleGestureDetector mScaleGestureDetector;
    public MyImage(Context context) {
        super(context);
        this.context = context;
        setFocusable(true);
        requestFocus();
        this.setLongClickable(true);
        this.setOnTouchListener(this);
        setFocusable(true);
        mScaleGestureDetector = new ScaleGestureDetector(context, this);
//        gd = new GestureDetector(context,this);// 这里或者可以直接传递this参数，因为本类已经继承了OnGestureListener接口，也可以把new
        // MySimpleGesture()，它继承了SimpleOnGestureListener类；，两种方法都可以，只是把两种方法归在一个里面，方便学习；
        // 。实惠屏幕触控事件；
//        gd.setIsLongpressEnabled(true);
    }
    public MyImage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.context = context;
        setFocusable(true);
        requestFocus();
        this.setLongClickable(true);
        this.setOnTouchListener(this);
        setFocusable(true);
        mScaleGestureDetector = new ScaleGestureDetector(context, this);
//        gd = new GestureDetector(context,this);// 这里或者可以直接传递this参数，因为本类已经继承了OnGestureListener接口，也可以把new
        // MySimpleGesture()，它继承了SimpleOnGestureListener类；，两种方法都可以，只是把两种方法归在一个里面，方便学习；
        // 。实惠屏幕触控事件；
//        gd.setIsLongpressEnabled(true);
    }

    public MyImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(TintContextWrapper.wrap(context), attrs, defStyleAttr);
        this.context = context;
        setFocusable(true);
        requestFocus();
        this.setLongClickable(true);
        this.setOnTouchListener(this);
        setFocusable(true);
        mScaleGestureDetector = new ScaleGestureDetector(context, this);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
//        gd = new GestureDetector(context,this);// 这里或者可以直接传递this参数，因为本类已经继承了OnGestureListener接口，也可以把new
        // MySimpleGesture()，它继承了SimpleOnGestureListener类；，两种方法都可以，只是把两种方法归在一个里面，方便学习；
        // 。实惠屏幕触控事件；
//        gd.setIsLongpressEnabled(true);

    }

    @Override
    public void setImageBitmap(Bitmap bm) {
        Log.d(TAG,"setImageBitmap");
            super.setImageBitmap(bm);
            //设置完图片后，获取该图片的坐标变换矩阵
            mMatrix.set(getImageMatrix());
            float[] values=new float[9];
            mMatrix.getValues(values);
            //图片宽度为屏幕宽度除缩放倍数
            mImageWidth=getWidth()/values[Matrix.MSCALE_X];
            mImageHeight=(getHeight()-values[Matrix.MTRANS_Y]*2)/values[Matrix.MSCALE_Y];
    }

    @Override
    public void setImageDrawable(@Nullable Drawable drawable) {
        Log.d(TAG,"setImageDrawable");
        super.setImageDrawable(drawable);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d(TAG,"onTouch");
        return mScaleGestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.d(TAG,"onSingleTapConfirmed");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d(TAG,"onDoubleTap");
        //双击放大2倍和还原
        float x = e.getX();
        float y = e.getY();
        if (getScale() <2) {
            postDelayed(new AutoScaleRunnable(2, x, y), 16);
        }else {
            postDelayed(new AutoScaleRunnable(1, x, y), 16);
        }
        return false;
    }

    private void setScale(float scale) {
        mCurrentMatrix.set(mMatrix);//初始化Matrix
        mCurrentMatrix.postScale(scale, scale,getWidth()/2,getHeight()/2);
        setImageMatrix(mCurrentMatrix);
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.d(TAG,"onDoubleTapEvent");
        return false;
    }
    /**
     * 获取当前图片的缩放值
     *
     * @return
     */
    public float getScale() {
        float[] values = new float[9];
        mMatrix.getValues(values);
        return values[Matrix.MSCALE_X];
    }

    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        float scale = getScale();
        float scaleFactor = detector.getScaleFactor();

        if (getDrawable() == null)
            return true;

        /**
         * 缩放的范围控制
         */
        if ((scale < SCALE_MAX && scaleFactor > 1.0f)|| (scale > initScale && scaleFactor < 1.0f))
        {
            /**
             * 最大值最小值判断
             */
            if (scaleFactor * scale < initScale)
            {
                scaleFactor = initScale / scale;
            }
            if (scaleFactor * scale > SCALE_MAX)
            {
                scaleFactor = SCALE_MAX / scale;
            }
            /**
             * 设置缩放比例
             */
            mMatrix.postScale(scaleFactor, scaleFactor, getWidth() / 2,
                    getHeight() / 2);
            setImageMatrix(mMatrix);
        }
        return true;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {

    }
    boolean once = true ;
    @Override
    public void onGlobalLayout() {
        if(once){

            int widthScreen = getWidth();
            int heightScreen = getHeight();
            int width = this.getDrawable().getIntrinsicWidth();
            int height = this.getDrawable().getIntrinsicHeight();
            mMatrix.setScale(1,1,widthScreen/2,heightScreen/2);
            mMatrix.postTranslate((widthScreen-width)/2,(heightScreen-height)/2);
            setImageMatrix(mMatrix);
            once = false;
            getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /**
     * 自动放大与缩小
     *
     * @author zhangyan@lzt.com.cn
     *
     */
    private class AutoScaleRunnable implements Runnable {
        /**
         * 缩放的目标值
         */
        private float mTargetScale;
        // 缩放的中心点
        private float x;
        private float y;

        private final float BIGGER = 1.07f;
        private final float SMALL = 0.93f;

        private float tmpScale;

        /**
         * @param mTargetScale
         * @param x
         * @param y
         */
        public AutoScaleRunnable(float mTargetScale, float x, float y) {
            this.mTargetScale = mTargetScale;
            this.x = x;
            this.y = y;

            if (getScale() < mTargetScale) {
                tmpScale = BIGGER;
            }
            if (getScale() > mTargetScale) {
                tmpScale = SMALL;
            }
        }

        @Override
        public void run() {
            //进行缩放
            mMatrix.postScale(tmpScale, tmpScale, x, y);
            checkBorderAndCenterWhenScale();
            setImageMatrix(mMatrix);

            float currentScale = getScale();

            if ((tmpScale >1.0f && currentScale <mTargetScale) ||(tmpScale<1.0f &&currentScale>mTargetScale)) {
                //这个方法是重新调用run()方法
                postDelayed(this, 16);
            }else{
                //设置为我们的目标值
                float scale = mTargetScale/currentScale;
                mMatrix.postScale(scale, scale, x, y);
                checkBorderAndCenterWhenScale();
                setImageMatrix(mMatrix);

//                isAutoScale = false;
            }
        }
    }
    /**
     * 获得图片放大缩小以后的宽和高，以及left，right，top，bottom
     *
     * @return
     */
    private RectF getMatrixRectF() {
        Matrix matrix = mMatrix;
        RectF rectF = new RectF();
        Drawable d = getDrawable();
        if (d != null) {
            rectF.set(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }
    /**
     * 在缩放的时候进行边界以及我们的位置的控制
     */
    private void checkBorderAndCenterWhenScale() {
        RectF rectF = getMatrixRectF();
        float deltaX = 0;
        float deltaY = 0;

        int width = getWidth();
        int height = getHeight();

        // 缩放时进行边界检测，防止出现白边
        if (rectF.width() >= width) {
            if (rectF.left > 0) {
                deltaX = -rectF.left;
            }
            if (rectF.right < width) {
                deltaX = width - rectF.right;
            }
        }

        if (rectF.height() >= height) {
            if (rectF.top > 0) {
                deltaY = -rectF.top;
            }
            if (rectF.bottom < height) {
                deltaY = height - rectF.bottom;
            }
        }

        /**
         * 如果宽度或高度小于空间的宽或者高，则让其居中
         */
        if (rectF.width() < width) {
            deltaX = width / 2f - rectF.right + rectF.width() / 2f;
        }

        if (rectF.height() < height) {
            deltaY = height / 2f - rectF.bottom + rectF.height() / 2f;
        }

        mMatrix.postTranslate(deltaX, deltaY);
    }
}
