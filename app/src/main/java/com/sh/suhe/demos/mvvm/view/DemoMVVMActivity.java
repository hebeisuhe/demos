package com.sh.suhe.demos.mvvm.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sh.suhe.demos.R;
import com.sh.suhe.demos.databinding.ActivityDemoMvvmBinding;
import com.sh.suhe.demos.mvvm.model.UIData;
import com.sh.suhe.demos.mvvm.viewmodel.UIViewModel;

public class DemoMVVMActivity extends  Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDemoMvvmBinding activityTesBinding = DataBindingUtil.setContentView(this,R.layout.activity_demo_mvvm);
        UIData user = new UIData();
        activityTesBinding.setUidata(user);
        activityTesBinding.setViewmodel(new UIViewModel(this,activityTesBinding));
    }
}
