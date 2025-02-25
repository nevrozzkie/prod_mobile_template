import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.dependencies

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