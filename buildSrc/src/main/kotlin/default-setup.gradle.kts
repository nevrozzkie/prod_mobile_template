import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.the
import org.gradle.kotlin.dsl.withType


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
    */
    namespace = "com.prod2025.mobiletemplate"
    compileSdk = Config.COMPILE_SDK
    defaultConfig {
        minSdk = 26
    }
}

dependencies {
    implementation(libs.kotlinx.datetime)
}

kotlin {
    jvmToolchain(17)
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }
}
