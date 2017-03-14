package com.sh.suhe.demos.activitylife;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.LightingColorFilter;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.sh.suhe.demos.R;

public class LifeLogActivity extends AppCompatActivity {
    private  static final  String TAG = LifeLogActivity.class.getSimpleName();
    TextView life_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_log);
        life_tv = (TextView) findViewById(R.id.life_tv);
        life_tv.setText(Datas.getStr("--onCreate"));
        Log.e(TAG,"onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"onStart");
        life_tv.setText(Datas.getStr("onStart"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        life_tv.setText(Datas.getStr("onResume"));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG,"onRestart");
        life_tv.setText(Datas.getStr("onRestart"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"onPause");
        life_tv.setText(Datas.getStr("onPause"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"onStop");
        life_tv.setText(Datas.getStr("onStop"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
        life_tv.setText(Datas.getStr("onDestroy"));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        life_tv.setText(Datas.getStr("onRestoreInstanceState"));
    }

    @Override
    public void onSaveInstanceState(Bundle outState ) {
        super.onSaveInstanceState(outState);
        life_tv.setText(Datas.getStr("onSaveInstanceState"));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        life_tv.setText(Datas.getStr("onNewIntent"));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        life_tv.setText(Datas.getStr("onConfigurationChanged"));
    }
}
