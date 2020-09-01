#include <jni.h>
#include <string>
#include <android/log.h>  // 调用Android 方法打印日志

#define TAG  "JNI-Learning"
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
    LOGE("Long: %lld", j_long);
    LOGE("Float: %f", j_float);
    LOGE("Double: %f", j_double);
}
extern "C"
JNIEXPORT void JNICALL
Java_win_techflowing_android_jni_JniLearningActivity_testReferenceType(JNIEnv *env, jobject thiz, jclass clz, jthrowable throwable,
                                                                       jstring string, jobject object, jobjectArray javaObjects,
                                                                       jbooleanArray booleans, jbyteArray bytes, jcharArray chars,
                                                                       jshortArray shorts, jintArray ints, jlongArray longs,
                                                                       jfloatArray floats, jdoubleArray doubles) {
    LOGE("JNI 引用类型测试>>>");

    // Java 对象，jclass
    jmethodID construct = env->GetMethodID(clz, "<init>", "()V");
    jobject obj = env->NewObject(clz, construct);
    jfieldID numField = env->GetFieldID(clz, "num", "I");
    int num = env->GetIntField(obj, numField);
    LOGE("获取Model对象中的num属性值：%d", num);

    // Throwable
    // env->Throw(throwable);

    // String
    const char *charString = env->GetStringUTFChars(string, NULL);
    if (charString != NULL) {
        LOGE("String 内容为《 %s 》，字符串长度：%d", charString, env->GetStringLength(string));
    }
    env->ReleaseStringUTFChars(string, charString);

    // Object 对象
    jfieldID fieldID = env->GetFieldID(env->GetObjectClass(object), "num", "I");
    LOGE("获取Model对象中的num属性值：%d", env->GetIntField(object, fieldID));

    // Object 数组
    // 获取第0个元素
    jobject jobject1 = env->GetObjectArrayElement(javaObjects, 0);
    jfieldID jfieldId = env->GetFieldID(env->GetObjectClass(jobject1), "num", "I");
    LOGE("获取Model对象中的num属性值：%d", env->GetIntField(jobject1, fieldID));

    // Bool 数组
    jboolean *jboolean = env->GetBooleanArrayElements(booleans, NULL);
    for (int i = 0; i < env->GetArrayLength(booleans); ++i) {
        LOGE("Boolean 数组[%d]元素: %hhu", i, *(jboolean + i));
    }
    env->ReleaseBooleanArrayElements(booleans, jboolean, 0);

    // Byte 数组
    jbyte *jbyte1 = env->GetByteArrayElements(bytes, NULL);
    for (int i = 0; i < env->GetArrayLength(bytes); ++i) {
        LOGE("Byte 数组[%d]元素: %hhd", i, *(jbyte1 + i));
    }
    env->ReleaseByteArrayElements(bytes, jbyte1, 0);

    // Char 数组
    jchar *jchar1 = env->GetCharArrayElements(chars, NULL);
    for (int i = 0; i < env->GetArrayLength(chars); ++i) {
        LOGE("Char 数组[%d]元素: %c", i, *(jchar1 + i));
    }
    env->ReleaseCharArrayElements(chars, jchar1, 0);

    // Short 数组
    jshort *jshort1 = env->GetShortArrayElements(shorts, NULL);
    for (int i = 0; i < env->GetArrayLength(shorts); ++i) {
        LOGE("Short 数组[%d]元素: %hd", i, *(jshort1 + i));
    }
    env->ReleaseShortArrayElements(shorts, jshort1, 0);

    // Int 数组
    jint *jint = env->GetIntArrayElements(ints, NULL);
    for (int i = 0; i < env->GetArrayLength(ints); ++i) {
        LOGE("Int 数组[%d]元素: %d", i, *(jint + i));
    }
    env->ReleaseIntArrayElements(ints, jint, 0);

    // Long 数组
    jlong *jlong1 = env->GetLongArrayElements(longs, NULL);
    for (int i = 0; i < env->GetArrayLength(longs); ++i) {
        LOGE("Long 数组[%d]元素: %lld", i, *(jlong1 + i));
    }
    env->ReleaseLongArrayElements(longs, jlong1, 0);

    // Float 数组
    jfloat *jfloat1 = env->GetFloatArrayElements(floats, NULL);
    for (int i = 0; i < env->GetArrayLength(floats); ++i) {
        LOGE("Float 数组[%d]元素: %f", i, *(jfloat1 + i));
    }
    env->ReleaseFloatArrayElements(floats, jfloat1, 0);

    // Double 数组
    jdouble *jdouble1 = env->GetDoubleArrayElements(doubles, NULL);
    for (int i = 0; i < env->GetArrayLength(doubles); ++i) {
        LOGE("Double 数组[%d]元素: %f", i, *(jdouble1 + i));
    }
    env->ReleaseDoubleArrayElements(doubles, jdouble1, 0);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_win_techflowing_android_jni_JniLearningActivity_stringCatFromJNI(JNIEnv *env, jobject thiz, jstring string) {
    const char *charString = env->GetStringUTFChars(string, NULL);
    jint length = env->GetStringLength(string);
    char *dest = static_cast<char *>(malloc(length));
    strcat(strcpy(dest, charString), " 这是 JNI 拼接的内容");
    return env->NewStringUTF(dest);
}

extern "C"
JNIEXPORT void JNICALL
Java_win_techflowing_android_jni_JniLearningActivity_accessField(JNIEnv *env, jobject thiz, jobject java_class) {
    jclass jclass1 = env->GetObjectClass(java_class);
    jfieldID jfieldId = env->GetFieldID(jclass1, "name", "Ljava/lang/String;");
    jstring value = (jstring) (env->GetObjectField(java_class, jfieldId));
    const char *string = env->GetStringUTFChars(value, NULL);
    if (string != NULL) {
        LOGE("String 内容为《 %s 》，字符串长度：%d", string, env->GetStringLength(value));
    }
    env->ReleaseStringUTFChars(value, string);
}

extern "C"
JNIEXPORT void JNICALL
Java_win_techflowing_android_jni_JniLearningActivity_accessStaticField(JNIEnv *env, jobject thiz, jclass clz) {

    jfieldID jfieldId = env->GetStaticFieldID(clz, "staticName", "Ljava/lang/String;");
    jstring value = (jstring) env->GetStaticObjectField(clz, jfieldId);
    const char *string = env->GetStringUTFChars(value, NULL);
    if (string != NULL) {
        LOGE("String 内容为《 %s 》，字符串长度：%d", string, env->GetStringLength(value));
    }
    env->ReleaseStringUTFChars(value, string);
}

extern "C"
JNIEXPORT void JNICALL
Java_win_techflowing_android_jni_JniLearningActivity_accessMethod(JNIEnv *env, jobject thiz, jobject java_class) {
    jclass jclass1 = env->GetObjectClass(java_class);
    jmethodID jmethodId = env->GetMethodID(jclass1, "genRandomInt", "(I)I");
    // 调用方法
    jint jint1 = env->CallIntMethod(java_class, jmethodId, 100);
    LOGE("从Java成员方法 genRandomInt 获取到的值: %d", jint1);
}

extern "C"
JNIEXPORT void JNICALL
Java_win_techflowing_android_jni_JniLearningActivity_accessStaticMethod(JNIEnv *env, jobject thiz, jclass clz) {
    jmethodID jmethodId = env->GetStaticMethodID(clz, "getUUID", "()Ljava/lang/String;");
    // 调用方法
    jstring value = (jstring) env->CallStaticObjectMethod(clz, jmethodId);
    LOGE("从Java静态方法 getUUID 获取到的内容为《 %s 》，字符串长度：%d", env->GetStringUTFChars(value, NULL), env->GetStringLength(value));
}

extern "C"
JNIEXPORT void JNICALL
Java_win_techflowing_android_jni_JniLearningActivity_accessSuperMethod(JNIEnv *env, jobject thiz, jobject java_class) {
    jclass jclass1 = env->GetObjectClass(java_class);
    // 获取父类Class
    jclass superClass = env->FindClass("win/techflowing/android/jni/JavaSuperClass");
    jmethodID jmethodId = env->GetMethodID(superClass, "javaMethod", "()V");
    env->CallNonvirtualVoidMethod(java_class, superClass, jmethodId);
}