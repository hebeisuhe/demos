package com.sh.suhe.demos;

/**
 * Created by suhe on 2017/2/4.
 * com.sh.suhe.demos
 */

public class JniTest {
//    public native String getCLanguageString(String str);

    static {
        System.loadLibrary("jnitest");
    }
}
