allprojects {

    apply(plugin = "kotlin-spring")
    apply(plugin = "kotlin-jpa")

    dependencies {
        implementation("com.fasterxml.jackson.core:jackson-databind")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("com.google.cloud:spring-cloud-gcp-pubsub-stream-binder")
        implementation("com.google.guava:guava")
        implementation("javax.validation:validation-api")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.springframework.cloud:spring-cloud-stream")
        implementation("org.springframework.boot:spring-boot-starter")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-security")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.cloud:spring-cloud-function-kotlin")
        implementation("org.springframework.cloud:spring-cloud-starter-function-web")
        implementation(project(":red-chariot-core"))
    }
}

dependencies {
    implementation(project(":red-chariot-command:command-api"))
    implementation(project(":red-chariot-command:command-service"))
    implementation(project(":red-chariot-command:command-eventbus"))
}