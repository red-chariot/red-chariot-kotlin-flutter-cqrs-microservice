import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION") // IntelliJ IDEA Bug https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.kotlin.noarg) apply false
    alias(libs.plugins.kotlin.spring) apply false
    alias(libs.plugins.kotlin.jpa) apply false
    idea
    java
}

subprojects {
    if (name == "nccs-ui") {
        return@subprojects
    }

    apply(plugin = rootProject.libs.plugins.kotlin.jvm.get().pluginId)
    apply(plugin = rootProject.libs.plugins.spring.dependency.management.get().pluginId)
    apply(plugin = rootProject.libs.plugins.detekt.get().pluginId)

    group = "red.chariot"

    tasks.withType<Detekt> {
        allRules = false
        jvmTarget = "17"
        config.setFrom(rootProject.file("detekt.yml"))
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    repositories {
        mavenCentral()
        google()
        maven { setUrl("https://dl.bintray.com/kotlin/kotlinx.html") }
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-starter-parent:${rootProject.libs.versions.spring.boot.get()}")
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${rootProject.libs.versions.spring.cloud.get()}")
            mavenBom("com.google.cloud:spring-cloud-gcp-dependencies:${rootProject.libs.versions.google.cloud.get()}")
        }
    }
}