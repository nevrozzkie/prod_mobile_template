
@file:Suppress(
//    "MayBeConstant",
    "SpellCheckingInspection",
    "MemberVisibilityCanBePrivate",
    "ConstPropertyName"
)
import org.gradle.api.JavaVersion

object Config {
    object Android {
        const val namespace = "com.prod2025.mobile_template"

        const val compileSdk = 35
        const val minSdk = 26
        const val targetSdk = 35
        const val versionCode = 1
        const val versionName = "1.0"
    }
    object Java {
        val version = JavaVersion.VERSION_17
        val stringVersion = version.majorVersion
        val intVersion = stringVersion.toInt()
    }
}