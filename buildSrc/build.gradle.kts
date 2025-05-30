plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(libs.plugin.convention.kotlin.android)
    implementation(libs.plugin.convention.android)
    implementation(libs.plugin.convention.compose.compiler)
    implementation(libs.plugin.convention.serialization)
    implementation(libs.plugin.convention.room)
    implementation(libs.plugin.convention.ksp)

    // for versionCatalog in setups
    // https://stackoverflow.com/a/70878181
    // An error in the editor, although the dependencies are correctly resolved.
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
