package com.sh.suhe.demos.mvvm.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.sh.suhe.demos.R;
import com.sh.suhe.demos.databinding.ActivityMainMvvmBinding;
import com.sh.suhe.demos.mvvm.viewmodel.MainViewModel;

public class MainMVVMActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainMvvmBinding activityMainMvvmBinding = DataBindingUtil.
                setContentView(this,R.layout.activity_main_mvvm);
        activityMainMvvmBinding.setMainviewmodel(new MainViewModel(this,activityMainMvvmBinding));
    }
}
