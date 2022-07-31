allprojects {

    apply(plugin = "kotlin-spring")
    apply(plugin = "kotlin-jpa")

    dependencies {
        implementation("com.fasterxml.jackson.core:jackson-databind")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("com.google.cloud:spring-cloud-gcp-pubsub-stream-binder")
        implementation("com.google.cloud:spring-cloud-gcp-starter")
        implementation("com.google.cloud:spring-cloud-gcp-starter-pubsub")
        implementation("com.h2database:h2")
        implementation("javax.validation:validation-api")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.springframework.boot:spring-boot-starter")
        implementation("org.springframework.boot:spring-boot-starter-actuator")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-security")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.cloud:spring-cloud-function-kotlin")
        implementation("org.springframework.cloud:spring-cloud-starter-function-web")
        implementation("org.springframework.cloud:spring-cloud-stream")
        implementation("org.springframework.cloud:spring-cloud-stream")
        implementation(project(":red-chariot-command:command-api"))
        implementation(project(":red-chariot-core"))
        testImplementation("org.hamcrest:java-hamcrest")
        testImplementation("org.jetbrains.kotlin:kotlin-test")
        testImplementation("org.springframework.boot:spring-boot-starter-aop")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
}

subprojects {
    dependencies {
        implementation(project(":red-chariot-query"))
    }
}