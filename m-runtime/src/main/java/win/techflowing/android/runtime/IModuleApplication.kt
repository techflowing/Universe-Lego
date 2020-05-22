package win.techflowing.android.runtime

import android.content.Context
import android.content.res.Configuration

/**
 * Application 方法抽象
 *
 * @author techflowing@gmail.com
 * @version 1.0.0
 * @since 2020/5/18 1:20 AM
 */
interface IModuleApplication {

    fun attachBaseContext(base: Context)

    fun onCreate()

    fun onConfigurationChanged(newConfig: Configuration)

    fun onLowMemory()

    fun onTerminate()

    fun onTrimMemory(level: Int)
}