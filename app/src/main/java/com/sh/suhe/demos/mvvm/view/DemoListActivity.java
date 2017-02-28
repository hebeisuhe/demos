package com.sh.suhe.demos.mvvm.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sh.suhe.demos.BR;
import com.sh.suhe.demos.R;
import com.sh.suhe.demos.databinding.ActivityDemoListBinding;
import com.sh.suhe.demos.databinding.ActivityDemoMvvmBinding;
import com.sh.suhe.demos.mvvm.model.ListItemData;
import com.sh.suhe.demos.mvvm.utils.CommonAdapter;
import com.sh.suhe.demos.mvvm.viewmodel.DemoListViewModel;

import java.util.ArrayList;
import java.util.List;

public class DemoListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDemoListBinding activityTesBinding = DataBindingUtil.
                setContentView(this,R.layout.activity_demo_list);

        activityTesBinding.setListviewmodel(new DemoListViewModel(activityTesBinding));

    }
}
