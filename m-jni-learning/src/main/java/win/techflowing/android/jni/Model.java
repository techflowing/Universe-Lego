package win.techflowing.android.jni;

/**
 * Model 数据类
 *
 * @author techflowing
 * @since 2020/7/27 12:48 AM
 */
public class Model {

    private int num;

    public Model() {
        num = 100;
    }

    public Model setNum(int num) {
        this.num = num;
        return this;
    }
}
