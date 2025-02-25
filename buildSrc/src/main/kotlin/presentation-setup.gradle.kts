import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

val libs = the<LibrariesForLibs>()
plugins {
    id("logic-internal-setup")
}


dependencies {
    api(libs.decompose.core)
    implementation(libs.mvikotlin.core)
    implementation(libs.mvikotlin.coroutines)
}