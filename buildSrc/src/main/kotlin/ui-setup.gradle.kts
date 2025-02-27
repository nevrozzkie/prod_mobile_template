import org.gradle.kotlin.dsl.dependencies

plugins {
    id("ui-common-setup")
}


dependencies {
    implementation(project(Module.utilsUI))
}