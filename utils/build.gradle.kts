plugins {
    id("default-setup")
}



dependencies {
    implementation(libs.decompose.core)

    implementation(libs.mvikotlin.core)
    implementation(libs.mvikotlin.coroutines)

    implementation(libs.kotlinx.coroutines)
}