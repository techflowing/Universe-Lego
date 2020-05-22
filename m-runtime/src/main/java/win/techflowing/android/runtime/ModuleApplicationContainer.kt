package win.techflowing.android.runtime

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import java.lang.reflect.InvocationTargetException

/**
 * Runtime Module容器
 *
 * @author techflowing@gmail.com
 * @version 1.0.0
 * @since 2020/5/11 12:43 AM
 */
class ModuleApplicationContainer private constructor() : IModuleApplication {

    companion object {
        /**
         * 单例实现
         */
        val INSTANCE: ModuleApplicationContainer by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            ModuleApplicationContainer()
        }

        @JvmStatic
        fun get(): ModuleApplicationContainer {
            return INSTANCE
        }
    }

    /** ModuleApplication 集合提供者*/
    private var moduleListProvider: IModuleListProvider? = null

    /**
     * @see Application.attachBaseContext
     */
    override fun attachBaseContext(base: Context) {
        getModuleListProvider()?.getModuleList()?.forEach {
            it.attachBaseContext(base)
        }
    }

    /**
     * @see Application.onCreate
     */
    override fun onCreate() {
        getModuleListProvider()?.getModuleList()?.forEach {
            it.onCreate()
        }
    }

    /**
     * @see Application.onConfigurationChanged
     */
    override fun onConfigurationChanged(newConfig: Configuration) {
        getModuleListProvider()?.getModuleList()?.forEach {
            it.onConfigurationChanged(newConfig)
        }
    }

    /**
     * @see Application.onLowMemory
     */
    override fun onLowMemory() {
        getModuleListProvider()?.getModuleList()?.forEach {
            it.onLowMemory()
        }
    }

    /**
     * @see Application.onTerminate
     */
    override fun onTerminate() {
        getModuleListProvider()?.getModuleList()?.forEach {
            it.onTerminate()
        }
    }

    /**
     * @see Application.onTrimMemory
     */
    override fun onTrimMemory(level: Int) {
        getModuleListProvider()?.getModuleList()?.forEach {
            it.onTrimMemory(level)
        }
    }

    /**
     * 反射获取Gradle Plugin生成的类
     */
    private fun getModuleListProvider(): IModuleListProvider? {
        if (moduleListProvider != null) {
            return moduleListProvider
        }
        try {
            val injectClass = Class.forName(IModuleListProvider.CLASS_NAME)
            moduleListProvider = injectClass.newInstance() as IModuleListProvider?
            return moduleListProvider
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
        return null
    }
}
