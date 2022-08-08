@Suppress("DSL_SCOPE_VIOLATION") // IntelliJ IDEA Bug https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.jpa)
    alias(libs.plugins.kotlin.noarg)
}

dependencies {
    implementation(libs.spring.boot.starter.core)
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.boot.starter.security)
    implementation(libs.spring.cloud.stream)

    kapt("org.hibernate:hibernate-jpamodelgen")

    implementation(project(":red-chariot-core"))
    implementation(project(":red-chariot-command:command-api"))
}

