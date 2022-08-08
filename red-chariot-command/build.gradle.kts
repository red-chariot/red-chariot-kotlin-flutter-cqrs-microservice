@Suppress("DSL_SCOPE_VIOLATION") // TODO remove when https://youtrack.jetbrains.com/issue/KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.kotlin.spring)
}

dependencies {

    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.boot.starter.security)
    implementation(libs.jackson.module.kotlin)
    implementation(libs.validation.api)
    implementation(libs.hibernate.validator)

    implementation(project(":red-chariot-core"))
    implementation(project(":red-chariot-command:command-api"))
    implementation(project(":red-chariot-command:command-service"))
}
