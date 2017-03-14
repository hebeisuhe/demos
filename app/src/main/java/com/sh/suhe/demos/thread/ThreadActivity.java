package com.sh.suhe.demos.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.MessageQueue;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sh.suhe.demos.R;

public class ThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        HandlerThread a;
        Message msg;
        Handler handler;

       // Message 创建时存储着对应的Handler。
        //Handler中存储着消息队列MessageQueue（也是Looper的消息队列），handler通过sendMessage把Message对象放入MessageQueue中；
        //MessageQueue执行到对应的Message后，Message会调用自己存储的Handler的dispatchMessage回调方法
        //
    }
}
