package win.techflowing.android.runtime

import android.app.Application

/**
 * 运行环境初始化类
 *
 * @author techflowing@gmail.com
 * @version 1.0.0
 * @since 2020/5/11 12:28 AM
 */
object AppRuntimeInit {

    /**
     * {@link Application#attachBaseContext(Context)}
     */
    fun onApplicationAttachBaseContext(application: Application, debug: Boolean) {
        AppRuntime.application = application
        AppRuntime.debug = debug
    }
}