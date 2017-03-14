package com.sh.suhe.demos.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by suhe on 2017/2/28.
 * com.sh.suhe.demos.utils
 */

public class ToastUtils {

    public static void showShort(Context context,String tip){
        Toast.makeText(context,""+tip,Toast.LENGTH_SHORT).show();
    }
    public static void showShort(Context context,int tip){
        Toast.makeText(context,tip,Toast.LENGTH_SHORT).show();
    }
    public static void showLong(Context context,String tip){
        Toast.makeText(context,""+tip,Toast.LENGTH_LONG).show();
    }
    public static void showLong(Context context,int tip){
        Toast.makeText(context,tip,Toast.LENGTH_LONG).show();
    }
}
