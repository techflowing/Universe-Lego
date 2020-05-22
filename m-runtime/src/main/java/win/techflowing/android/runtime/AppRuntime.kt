package win.techflowing.android.runtime

import android.app.Application
import android.content.Context

/**
 * App 运行环境
 *
 * @author techflowing@gmail.com
 * @version 1.0.0
 * @since 2020/5/11 12:14 AM
 */
internal object AppRuntime {

    lateinit var application: Application
    var debug: Boolean = false

    fun getAppContext(): Context {
        return application
    }

    fun isDebug(): Boolean {
        return debug
    }
}