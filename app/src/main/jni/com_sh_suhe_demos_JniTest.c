#include"com_sh_suhe_demos_JniTest.h"

/*
 * Class:     com_sh_suhe_demos_JniTest
 * Method:    getCLanguageString
 * Signature: (Ljava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_sh_suhe_demos_JniTest_getCLanguageString
  (JNIEnv *env, jobject obj, jstring str){
    return (*env)->NewStringUTF(env,"This just a test for Android Studio NDK JNI developer!");
  }