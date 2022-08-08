@Suppress("DSL_SCOPE_VIOLATION") // TODO remove when https://youtrack.jetbrains.com/issue/KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.kotlin.spring)
}

dependencies {
    implementation(libs.spring.cloud.stream)
    implementation(libs.spring.boot.starter.core)
    implementation(libs.spring.boot.starter.data.jpa)

    implementation(project(":red-chariot-core"))
}