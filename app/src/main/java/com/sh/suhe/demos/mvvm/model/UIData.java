package com.sh.suhe.demos.mvvm.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.sh.suhe.demos.BR;

/**
 * Created by suhe on 2017/2/27.
 * com.sh.suhe.demos.mvvm.model
 */

public class UIData extends BaseObservable {

    public UIData(){
        this.setName("哈哈你好");
        this.setAge(28);
    }

    String name;
    int age;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
}
