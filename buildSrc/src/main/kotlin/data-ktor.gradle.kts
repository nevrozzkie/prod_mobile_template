
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.the

val libs = the<LibrariesForLibs>()
plugins {
    /*
        Градл умный: мы можем в одном модуле юзать
        data-ktor и data-room, несмотря на то, что
        они оба юзают `logic-internal-setup`
     */
    id("logic-internal-setup")
    kotlin("plugin.serialization")
}


dependencies {
    implementation(libs.ktor.client.core)
    implementation(libs.kotlinx.serialization.json)
}