import gradle.kotlin.dsl.accessors._05a4e5c2a06ee7aa20c791cd0fb1cc1f.api
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

// если понадобится serialization, то нужно раскомментить

val libs = the<LibrariesForLibs>()
plugins {
    id("default-setup")
//    kotlin("plugin.serialization")
}


dependencies {
//    implementation(libs.kotlinx.serialization.json)
    api(libs.kotlinx.coroutines)
}
