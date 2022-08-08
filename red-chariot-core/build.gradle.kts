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
    implementation(libs.spring.cloud.stream)
    implementation(libs.jjwt.api)
    implementation(libs.jjwt.impl)
    implementation(libs.jjwt.jackson)
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.security)

    kapt("org.hibernate:hibernate-jpamodelgen")

    testImplementation(libs.spring.boot.starter.test)
}
