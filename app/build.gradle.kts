
plugins {
    id(libs.plugins.android.application.get().pluginId)
    id(libs.plugins.kotlin.android.get().pluginId)
    id(libs.plugins.kotlin.compose.get().pluginId)
    id(libs.plugins.serialization.get().pluginId)
}

android {
    namespace = Config.Android.namespace
    compileSdk = Config.Android.compileSdk

    defaultConfig {
        applicationId = Config.Android.namespace
        minSdk = Config.Android.minSdk
        targetSdk = Config.Android.targetSdk
        versionCode = Config.Android.versionCode
        versionName = Config.Android.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Config.Java.version
        targetCompatibility = Config.Java.version
    }
    kotlinOptions {
        jvmTarget = Config.Java.stringVersion
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(project(Module.Features.Auth.presentation))
    implementation(project(Module.Features.Auth.ui))


    implementation(project(Module.core))
    implementation(project(Module.utilsUI))


    implementation(libs.decompose.compose)


    implementation(libs.mvikotlin.core)
    implementation(libs.mvikotlin.main)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.icons)
    implementation(libs.androidx.compose.icons.extended)
    implementation(libs.androidx.compose.ui.tooling)
}