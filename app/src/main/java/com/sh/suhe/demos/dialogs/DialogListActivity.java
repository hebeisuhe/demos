package com.sh.suhe.demos.dialogs;

import android.service.carrier.CarrierService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sh.suhe.demos.R;

import net.lemonsoft.lemonhello.LemonHello;
import net.lemonsoft.lemonhello.LemonHelloAction;
import net.lemonsoft.lemonhello.LemonHelloInfo;
import net.lemonsoft.lemonhello.LemonHelloView;
import net.lemonsoft.lemonhello.interfaces.LemonHelloActionDelegate;

public class DialogListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_list);

    }
    public void click(View view){
        switch (view.getId()){
            case R.id.activity_dialog_list_ok:
                onBut();
                break;
            case R.id.activity_dialog_list_select:
                selectBut();
                break;
            case R.id.activity_dialog_list_alert:
                alertBut();
                break;
        }

    }
    public void onBut(){
        LemonHello.getSuccessHello("这是标题", "这是内容")
                // 添加action，实际就是添加对话框下面的按钮，同时需要设置标题和点击事件
                .addAction(new LemonHelloAction("确定", new LemonHelloActionDelegate() {
                    @Override
                    public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                        helloView.hide();// 隐藏对话框
                    }
                }))
                .show(DialogListActivity.this);// 显示吧~
    }
    public void selectBut(){
        LemonHello.getSuccessHello("请选择", "选择确认")
                // 添加action，实际就是添加对话框下面的按钮，同时需要设置标题和点击事件
                .addAction(new LemonHelloAction("确定", new LemonHelloActionDelegate() {
                    @Override
                    public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                        helloView.hide();// 隐藏对话框
                    }
                }))
                .addAction(new LemonHelloAction("取消", new LemonHelloActionDelegate() {
                    @Override
                    public void onClick(LemonHelloView helloView, LemonHelloInfo helloInfo, LemonHelloAction helloAction) {
                        helloView.hide();// 隐藏对话框
                    }
                }))
                .show(DialogListActivity.this);// 显示吧~
    }
    public void alertBut(){
        LemonHello.getSuccessHello("这是标题", "这是内容")
                // 添加action，实际就是添加对话框下面的按钮，同时需要设置标题和点击事件
                .show(DialogListActivity.this);// 显示吧~
    }
}
