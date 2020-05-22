package win.techflowing.android.splash

import android.content.Context
import win.techflowing.android.runtime.AbsModuleApplication
import win.techflowing.android.runtime.annotation.ModuleApplication

/**
 * Splash 欢迎页 ModuleApplication
 *
 * @author techflowing@gmail.com
 * @version 1.0.0
 * @since 2020/5/17 10:23 PM
 */
@ModuleApplication()
class SplashApplication : AbsModuleApplication() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
    }
}