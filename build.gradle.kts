import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("io.gitlab.arturbosch.detekt") apply false
    id("io.spring.dependency-management")
    id("org.springframework.boot") apply false
    kotlin("jvm") apply false
    kotlin("plugin.spring") apply false
    kotlin("plugin.noarg") apply false
    idea
    java
}

subprojects {
    if (name == "nccs-ui") {
        return@subprojects
    }

    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "io.gitlab.arturbosch.detekt")

    group = "com.telus.nccs"

    tasks.withType<Detekt> {
        failFast = false
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
        maven { setUrl("https://repo1.maven.org/maven2") }
        mavenCentral()
        google()
        maven { setUrl("https://mvnrepository.com/artifact") }
        maven { setUrl("https://dl.bintray.com/kotlin/kotlinx.html") }
    }

    dependencyManagement {
        val version = object {
            val REACTOR_BOM = "2020.0.17"
            val SPRING_BOOT = "2.7.0"
            val SPRING_CLOUD = "2021.0.1"
            val GOOGLE_CLOUD = "3.1.0"
            val LOGBACK_CONTRIB = "0.1.5"
            val ASSERTK_JVM = "0.25"
            val JAXB_IMPL = "3.0.2"
            val JAVA_HAMCREST = "2.0.0.0"
            val SELENIUM = "3.141.59" // do not change it
            val GUAVA = "31.1-jre"
            val OPENAPI = "1.6.6"
            val CAPSA = "0.2.80"
            val CAPSA_GITHUB_ACTIONS = "0.7.1"
            val SPRING_MAIL = "5.5.12"
            val GREEN_MAIL = "1.6.5"
        }
        imports {
            mavenBom("io.projectreactor:reactor-bom:${version.REACTOR_BOM}")
            mavenBom("org.springframework.boot:spring-boot-starter-parent:${version.SPRING_BOOT}")
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${version.SPRING_CLOUD}")
            mavenBom("com.google.cloud:spring-cloud-gcp-dependencies:${version.GOOGLE_CLOUD}")
        }
        dependencies {
            dependency("org.springframework.boot:spring-boot-starter-logging:${version.SPRING_BOOT}")
            dependency("com.willowtreeapps.assertk:assertk-jvm:${version.ASSERTK_JVM}")
            dependency("org.hamcrest:java-hamcrest:${version.JAVA_HAMCREST}")
            dependency("org.seleniumhq.selenium:selenium-java:${version.SELENIUM}")
            dependency("org.seleniumhq.selenium:selenium-chrome-driver:${version.SELENIUM}")
            dependency("org.seleniumhq.selenium:selenium-firefox-driver:${version.SELENIUM}")
            dependency("com.google.guava:guava:${version.GUAVA}")
            dependency("org.springdoc:springdoc-openapi-ui:${version.OPENAPI}")
            dependency("com.icegreen:greenmail:${version.GREEN_MAIL}")
            dependency("org.springframework.integration:spring-integration-mail:${version.SPRING_MAIL}")
            dependency("com.sun.xml.bind:jaxb-core:${version.JAXB_IMPL}")
            dependency("com.sun.xml.bind:jaxb-impl:${version.JAXB_IMPL}")
            dependency("telus.capsa:capsa-core:${version.CAPSA}")
            dependency("telus.capsa:capsa-it:${version.CAPSA}")
            dependency("telus.capsa:junit-test-runner:${version.CAPSA_GITHUB_ACTIONS}")
        }
    }
}