import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the


// setup, необходимый для работы модулей. Используется в других setup

val libs = the<LibrariesForLibs>()
plugins {
    kotlin("android")
    id("com.android.library")
    id("com.google.devtools.ksp")
}

android {
    /*
    Дефолтное значение namespace
    Может ругаться IDE на ресурсы -> в модуле прописывать отдельно
    ПРО РЕСУРСЫ МБ РЕШАЕТ ПРОБЛЕМУ СНИЗУ SourceSets!!
    */
    namespace = Config.Android.namespace + ".convention"
    compileSdk = Config.Android.compileSdk
    defaultConfig {
        minSdk = Config.Android.minSdk
    }


    sourceSets {
        named("main") {
            res.srcDirs("src/main/res")
        }
    }
}

dependencies {
    implementation(libs.kotlinx.datetime)
}