import gradle.kotlin.dsl.accessors._05a4e5c2a06ee7aa20c791cd0fb1cc1f.api
import gradle.kotlin.dsl.accessors._05a4e5c2a06ee7aa20c791cd0fb1cc1f.implementation
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