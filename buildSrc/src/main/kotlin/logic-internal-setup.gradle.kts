
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

// Setup для логики (data, presentation)
// Используется только для других setup

val libs = the<LibrariesForLibs>()
plugins {
    id("default-setup")
}


dependencies {

    // TODO
//    implementation(project(":core"))
//    implementation(project(":utils"))

}
