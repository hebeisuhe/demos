package com.sh.suhe.demos.activitylife;


/**
 * Created by suhe on 2017/3/13.
 * com.sh.suhe.demos.activitylife
 */

public class Datas {
    public static  String mStr="";
    public static String getStr(String str){
        if (null != str && !"".equals(str)){
            mStr = mStr +"\n"+ str;
        }
        return mStr;
    }
}
