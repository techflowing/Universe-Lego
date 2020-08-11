package win.techflowing.android.jni;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import androidx.appcompat.app.AppCompatActivity;

/**
 * JNI Test 页面
 */
public class JniLearningActivity extends AppCompatActivity {

    private static final String TAG = "JniLearningActivity";

    static {
        System.loadLibrary("native-lib");
    }

    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_learning);
        container = findViewById(R.id.ly_jni_learning_container);

        addButton("SayHello", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayHello();
            }
        });

        addButton("测试Native 返回字符串", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, stringFromJNI());
            }
        });

        addButton("测试基本类型转换", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testBasicType(100, (byte) 8, (short) 10, 10000000000L, 30.1f, 60.2d, 'A', true);
            }
        });

        addButton("测试引用类型转换", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testReferenceType(Model.class,
                        new IllegalStateException("来自Java层的异常"),
                        "来自Java层的String",
                        new Model().setNum(200),
                        new Model[]{new Model()},
                        new boolean[]{true, false},
                        new byte[]{(byte) 8, (byte) 20},
                        new char[]{'A', 'B'},
                        new short[]{(short) 10, (short) 11},
                        new int[]{1, 2, 3},
                        new long[]{10000000000L, 200000000000L},
                        new float[]{0.1f, 0.3f},
                        new double[]{20.3d, 30.4d}
                );
            }
        });
    }

    private native void sayHello();

    /**
     * 调用native 方法，返回字符串
     */
    private native String stringFromJNI();

    /**
     * 测试基本类型
     */
    private native void testBasicType(int jInt, byte jByte, short jShort, long jLong, float jFloat, double jDouble, char jChar, boolean jBoolean);

    /**
     * 测试引用类型
     */
    private native void testReferenceType(Class<Model> clz, Throwable throwable, String string, Model object, Model[] javaObjects,
                                          boolean[] booleans, byte[] bytes, char[] chars, short[] shorts, int[] ints, long[] longs,
                                          float[] floats, double[] doubles);

    /**
     * 添加测试按钮
     */
    private void addButton(String text, View.OnClickListener listener) {
        Button button = new Button(this);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        button.setText(text);
        button.setOnClickListener(listener);
        if (container != null) {
            container.addView(button);
        }
    }
}
