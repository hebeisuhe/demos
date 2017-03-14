package com.sh.suhe.demos.mvvm.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.sh.suhe.demos.Gesture.GestureTestActivity;
import com.sh.suhe.demos.activitylife.LifeLogActivity;
import com.sh.suhe.demos.databinding.ActivityMainMvvmBinding;
import com.sh.suhe.demos.mvvm.view.DemoListActivity;
import com.sh.suhe.demos.mvvm.view.DemoMVVMActivity;

/**
 * Created by suhe on 2017/2/28.
 * com.sh.suhe.demos.mvvm.viewmodel
 */

public class MainViewModel {
    Activity mActivity;
    public MainViewModel(Activity activity, ActivityMainMvvmBinding binding){
        this.mActivity = activity;
    }

    public void show(View view){
        Intent intent = new Intent();
        intent.setClass(mActivity, DemoMVVMActivity.class);
        mActivity.startActivity(intent);

    }
    public void list(View view){
        Intent intent = new Intent();
        intent.setClass(mActivity, DemoListActivity.class);
        mActivity.startActivity(intent);
    }
    public void life(View view){
        Intent intent = new Intent();
        intent.setClass(mActivity, LifeLogActivity.class);
        mActivity.startActivity(intent);
    }
    public void gesture(View view){
        Intent intent = new Intent();
        intent.setClass(mActivity, GestureTestActivity.class);
        mActivity.startActivity(intent);
    }


}
