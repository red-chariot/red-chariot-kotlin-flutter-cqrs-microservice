@Suppress("DSL_SCOPE_VIOLATION") // IntelliJ IDEA Bug https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.kotlin.spring)
}

dependencies {
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.boot.starter.security)
    implementation(libs.jackson.module.kotlin)
    implementation(libs.validation.api)
    implementation(libs.hibernate.validator)

    implementation(project(":red-chariot-command:command-api"))
    implementation(project(":red-chariot-core"))
    implementation(project(":red-chariot-query"))
    implementation(project(":red-chariot-query:red-chariot-messaging:messaging-service"))
}