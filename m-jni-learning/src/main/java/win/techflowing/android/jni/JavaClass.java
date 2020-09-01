package win.techflowing.android.jni;

import android.util.Log;

import java.util.Random;
import java.util.UUID;

/**
 * Java 类
 *
 * @author techflowing
 * @since 2020/8/12 12:57 AM
 */
public class JavaClass extends JavaSuperClass {

    private static final String TAG = "JavaClass";

    private String name = "JavaName->成员属性";

    private static String staticName = "StaticJavaName -> 静态属性";

    /**
     * 产生一个随机数
     */
    public int genRandomInt(int max) {
        return new Random().nextInt(max);
    }

    /**
     * 产生一个UUID字符串
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void javaMethod() {
        Log.e(TAG, "访问javaMethod");
    }
}
