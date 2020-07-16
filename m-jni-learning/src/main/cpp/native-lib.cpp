#include <jni.h>
#include <string>
#include <android/log.h>  // 调用Android 方法打印日志

#define TAG  "JniLearningActivity"
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,TAG ,__VA_ARGS__) // 定义LOGE类型，__VA_ARGS__ 为可变参数的宏定义


extern "C"
JNIEXPORT jstring JNICALL
Java_win_techflowing_android_jni_JniLearningActivity_stringFromJNI(JNIEnv *env, jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT void JNICALL
Java_win_techflowing_android_jni_JniLearningActivity_sayHello(JNIEnv *env, jobject thiz) {
    printf("Hello JNI");
    LOGE("Hello JNI");
}

extern "C"
JNIEXPORT void JNICALL
Java_win_techflowing_android_jni_JniLearningActivity_testBasicType(JNIEnv *env, jobject thiz, jint j_int, jbyte j_byte, jshort j_short,
                                                                   jlong j_long, jfloat j_float, jdouble j_double, jchar j_char,
                                                                   jboolean j_boolean) {
    LOGE("Boolean: %hhu", j_boolean);
    LOGE("Byte: %hhd", j_byte);
    LOGE("Char: %hu", j_char);
    LOGE("Char: %c", j_char);
    LOGE("Short: %hd", j_short);
    LOGE("Int: %d", j_int);
    LOGE("Long: %ld", j_long);
    LOGE("Float: %f", j_float);
    LOGE("Double: %f", j_double);
}

extern "C"
JNIEXPORT void JNICALL
Java_win_techflowing_android_jni_JniLearningActivity_testReferenceType(JNIEnv *env, jobject thiz) {

}