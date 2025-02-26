import gradle.kotlin.dsl.accessors._99f92b90c5cfc137e1b0dbde38101d99.implementation
import gradle.kotlin.dsl.accessors._99f92b90c5cfc137e1b0dbde38101d99.ksp
import gradle.kotlin.dsl.accessors._99f92b90c5cfc137e1b0dbde38101d99.room
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the

val libs = the<LibrariesForLibs>()
plugins {
    /*
        Градл умный: мы можем в одном модуле юзать
        data-ktor и data-room, несмотря на то, что
        они оба юзают `logic-internal-setup`
     */
    id("logic-internal-setup")
    id("androidx.room")
}


dependencies {
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
    implementation(libs.room.ktx)
}
room {
    schemaDirectory("$projectDir/schemas")
}