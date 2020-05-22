package win.techflowing.android.runtime

import android.app.Application
import android.content.Context
import android.content.res.Configuration

/**
 * Module Application 基类
 *
 * @author techflowing@gmail.com
 * @version 1.0.0
 * @since 2020/5/11 12:34 AM
 */
open class AbsModuleApplication : IModuleApplication {

    companion object {
        /** DEBUG 标识 */
        val DEBUG by lazy { AppRuntime.isDebug() }

        /**
         * 获取ApplicationContext
         */
        fun getAppContext(): Context {
            return AppRuntime.getAppContext()
        }

        /**
         * 获取Application
         */
        fun getApplication(): Application {
            return AppRuntime.application
        }
    }

    override fun attachBaseContext(base: Context) {

    }

    override fun onCreate() {

    }

    override fun onConfigurationChanged(newConfig: Configuration) {

    }

    override fun onLowMemory() {

    }

    override fun onTerminate() {
    }

    override fun onTrimMemory(level: Int) {
    }
}