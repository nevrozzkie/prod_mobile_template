import gradle.kotlin.dsl.accessors._05a4e5c2a06ee7aa20c791cd0fb1cc1f.android
import gradle.kotlin.dsl.accessors._05a4e5c2a06ee7aa20c791cd0fb1cc1f.implementation
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin
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

kotlin {
    jvmToolchain(Config.Java.intVersion)
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = Config.Java.stringVersion
    }
}