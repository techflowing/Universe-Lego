package win.techflowing.android.runtime.annotation

/**
 * Module 级别的Application 注解
 *
 * @author techflowing@gmail.com
 * @version 1.0.0
 * @since 2020/5/17 6:06 PM
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
annotation class ModuleApplication(val priority: Int = 1000) {
}