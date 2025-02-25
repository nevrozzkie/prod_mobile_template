import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.dependencies


// Нужен, т.к. модуль utils-compose не может имплементировать сам себя

val libs = the<LibrariesForLibs>()
plugins {
    id("default-setup")
    kotlin("plugin.compose")
}


dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.icons)
    implementation(libs.androidx.compose.icons.extended)
    implementation(libs.androidx.compose.ui.tooling)
    implementation(libs.decompose.compose)
    implementation(libs.decompose.core)

}
