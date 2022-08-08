@Suppress("DSL_SCOPE_VIOLATION") // IntelliJ IDEA Bug https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.kotlin.spring)
}

dependencies {
    implementation(libs.jackson.databind)
    implementation(libs.jackson.module.kotlin)
    implementation(libs.jjwt.api)
    implementation(libs.jjwt.impl)
    implementation(libs.jjwt.jackson)
    implementation(libs.spring.boot.starter.core)
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.cloud.gcp.starter.core)
    implementation(libs.spring.cloud.stream)

    implementation(project(":red-chariot-core"))
    implementation(project(":red-chariot-command:command-api"))
}

