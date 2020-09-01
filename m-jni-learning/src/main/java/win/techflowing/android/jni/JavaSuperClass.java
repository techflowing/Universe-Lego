package win.techflowing.android.jni;

import android.util.Log;

/**
 * 类描述
 *
 * @author techflowing
 * @since 2020/9/13 10:54 PM
 */
public class JavaSuperClass {

    private static final String TAG = "JavaSuperClass";

    public void javaMethod() {
        Log.e(TAG, "访问javaMethod（JavaSuperClass）");
    }
}
