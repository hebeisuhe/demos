package com.sh.suhe.demos.mvvm.viewmodel;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;


import com.sh.suhe.demos.databinding.ActivityDemoMvvmBinding;
import com.sh.suhe.demos.mvvm.model.UIData;

/**
 * Created by suhe on 2017/2/27.
 * com.sh.suhe.demos.mvvm.viewmodel
 */

public class UIViewModel {
    ActivityDemoMvvmBinding activityMainBinding;
    Activity activity;
//    private ContentDemoMvvmBinding contentMainBinding;
    public UIViewModel(Activity activity, ActivityDemoMvvmBinding activityMainBinding){
        this.activity = activity;
        this.activityMainBinding = activityMainBinding;
//          activityMainBinding.;
        init();
    }

    public void init(){
//        contentMainBinding.setViewModel(this);

    }
    public void saveData(View view){
       UIData data = activityMainBinding.getUidata();

        //输出editText的数据
//        activityMainBinding
        Toast.makeText(activity,"name:"+data.getName()+"age:"+data.getAge(),Toast.LENGTH_SHORT).show();
        //以下两种方式也可以改变值
//        activityMainBinding.nameTv.setText(data.getName());
//        activityMainBinding.ageTv.setText(""+data.getAge());
        //        data.setName(data.getName());
//        data.setAge(data.getAge());
    }

}
