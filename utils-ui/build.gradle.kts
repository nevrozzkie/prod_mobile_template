plugins {
    id("ui-common-setup")
}



dependencies {
    api(project(":utils"))

    implementation(libs.androidx.accompanist.systemuicontroller)
}
