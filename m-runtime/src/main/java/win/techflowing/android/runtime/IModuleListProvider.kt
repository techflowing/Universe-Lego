package win.techflowing.android.runtime

/**
 * ModuleApplication 列表提供
 * <p>
 * 此类不要随意修改，和Gradle 插件 Gather 有关
 *
 * @author techflowing@gmail.com
 * @version 1.0.0
 * @since 2020/5/11 1:04 AM
 */
interface IModuleListProvider {

    companion object {
        /** Gradle 插件会生成此类，并实现 getModuleList 方法 */
        const val CLASS_NAME = "win.techflowing.android.runtime.ModuleListProviderImpl"
    }

    /**
     * 获取 ModuleApplication 列表，此方法的真是实现由Gradle插件注入
     */
    fun getModuleList(): List<IModuleApplication>
}