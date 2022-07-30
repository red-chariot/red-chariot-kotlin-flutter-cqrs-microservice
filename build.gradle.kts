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

    group = "red.chariot"

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
            val APACHE_COMMONS = "1.9"
            val ASSERTK_JVM = "0.25"
            val CAPSA = "0.2.80"
            val CAPSA_GITHUB_ACTIONS = "0.7.1"
            val GOOGLE_CLOUD = "3.1.0"
            val GREEN_MAIL = "1.6.5"
            val GUAVA = "31.1-jre"
            val H2 = "1.4.199"
            val JAVAX_VALIDATION = "2.0.1.Final"
            val JAVA_HAMCREST = "2.0.0.0"
            val JAXB_IMPL = "3.0.2"
            val JPAMODELGEN = "5.4.10.Final"
            val LOGBACK = "1.2.9"
            val LOGBACK_CONTRIB = "0.1.5"
            val LOGBACK_EXTENSIONS = "0.1.5"
            val OPENAPI = "1.6.6"
            val REACTOR_BOM = "2020.0.17"
            val SELENIUM = "3.141.59" // do not change it
            val SPRING_BOOT = "2.7.0"
            val SPRING_CLOUD = "2021.0.1"
            val SPRING_MAIL = "5.5.12"
        }
        imports {
            mavenBom("io.projectreactor:reactor-bom:${version.REACTOR_BOM}")
            mavenBom("org.springframework.boot:spring-boot-starter-parent:${version.SPRING_BOOT}")
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${version.SPRING_CLOUD}")
            mavenBom("com.google.cloud:spring-cloud-gcp-dependencies:${version.GOOGLE_CLOUD}")
        }
        dependencies {
            dependency("ch.qos.logback.contrib:logback-jackson:${version.LOGBACK_CONTRIB}")
            dependency("ch.qos.logback.contrib:logback-json-classic:${version.LOGBACK_CONTRIB}")
            dependency("ch.qos.logback:logback-classic:${version.LOGBACK}")
            dependency("ch.qos.logback:logback-core:${version.LOGBACK}")
            dependency("com.google.guava:guava:${version.GUAVA}")
            dependency("com.h2database:h2:${version.H2}")
            dependency("com.icegreen:greenmail:${version.GREEN_MAIL}")
            dependency("com.sun.xml.bind:jaxb-impl:${version.JAXB_IMPL}")
            dependency("com.willowtreeapps.assertk:assertk-jvm:${version.ASSERTK_JVM}")
            dependency("javax.validation:validation-api:${version.JAVAX_VALIDATION}")
            dependency("org.apache.commons:commons-text:${version.APACHE_COMMONS}")
            dependency("org.hamcrest:java-hamcrest:${version.JAVA_HAMCREST}")
            dependency("org.hibernate:hibernate-jpamodelgen:${version.JPAMODELGEN}")
            dependency("org.logback-extensions:logback-ext-loggly:${version.LOGBACK_EXTENSIONS}")
            dependency("org.seleniumhq.selenium:selenium-chrome-driver:${version.SELENIUM}")
            dependency("org.seleniumhq.selenium:selenium-firefox-driver:${version.SELENIUM}")
            dependency("org.seleniumhq.selenium:selenium-java:${version.SELENIUM}")
            dependency("org.springdoc:springdoc-openapi-ui:${version.OPENAPI}")
            dependency("org.springframework.boot:spring-boot-starter-logging:${version.SPRING_BOOT}")
            dependency("org.springframework.integration:spring-integration-mail:${version.SPRING_MAIL}")
        }
    }
}