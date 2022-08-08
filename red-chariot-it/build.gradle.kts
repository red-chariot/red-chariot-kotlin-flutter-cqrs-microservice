import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

@Suppress("DSL_SCOPE_VIOLATION") // TODO remove when https://youtrack.jetbrains.com/issue/KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.kotlin.spring)
}

dependencies {
    implementation(libs.assertk.jvm)
    implementation(libs.greenmail)
    implementation(libs.httpclient)
    implementation(libs.httpmime)
    implementation(libs.jjwt.api)
    implementation(libs.jjwt.impl)
    implementation(libs.jjwt.jackson)
    implementation(libs.junit.platform.launcher)
    implementation(libs.kotlin.compiler.embeddable)
    implementation(libs.kotlin.test)
    implementation(libs.kubernetes.client.java)
    implementation(libs.mockito.core)
    implementation(libs.selenium.chrome.driver)
    implementation(libs.selenium.firefox.driver)
    implementation(libs.selenium.java)
    implementation(libs.spring.boot.starter.data.rest)
    implementation(libs.spring.boot.starter.mail)
    implementation(libs.spring.boot.starter.security)
    implementation(libs.spring.boot.starter.test)
    implementation(libs.spring.integration.mail)
    implementation(libs.jackson.databind)
    implementation(libs.jackson.module.kotlin)

    implementation(project(":red-chariot-core"))
}

sourceSets {
    create("integration") {
        withConvention(KotlinSourceSet::class) {
            kotlin.srcDir("src/integration/kotlin")
            resources.srcDir("src/integration/resources")
            compileClasspath += sourceSets["main"].output + sourceSets["test"].compileClasspath
            runtimeClasspath += output + compileClasspath + sourceSets["test"].runtimeClasspath
        }
    }
}

configurations.named("integrationImplementation") {
    extendsFrom(configurations["implementation"])
}

configurations.named("integrationRuntimeOnly") {
    extendsFrom(configurations["runtimeOnly"])
}

tasks {
    val profiles = if (!project.hasProperty("profiles")) "local" else project.property("profiles").toString()

    val integration by registering(Test::class) {
        description = "Runs the integration tests"
        group = "verification"


        systemProperty("spring.profiles.active", profiles)
        systemProperty("junit.jupiter.execution.parallel.enabled", "true")
        systemProperty("junit.jupiter.execution.parallel.mode.default", "concurrent")
        systemProperty("junit.jupiter.execution.parallel.mode.classes.default", "concurrent")
        systemProperty("junit.jupiter.execution.parallel.config.fixed.parallelism", if (profiles == "local") 50 else 10)

        testClassesDirs = sourceSets["integration"].output.classesDirs
        classpath = sourceSets["integration"].runtimeClasspath
        mustRunAfter("test")
        useJUnitPlatform {
            includeEngines("junit-jupiter")
            excludeEngines("junit-vintage")
        }
        reports {
            junitXml.required.set(true)
            html.required.set(true)
        }
        testLogging {
            // set options for log level LIFECYCLE
            events(TestLogEvent.PASSED, TestLogEvent.FAILED, TestLogEvent.SKIPPED)

            exceptionFormat = TestExceptionFormat.FULL
            showExceptions = true
            showCauses = true
            showStackTraces = true
            showStandardStreams = true
            info.events = debug.events
            info.exceptionFormat = debug.exceptionFormat

            afterSuite(KotlinClosure2<TestDescriptor, TestResult, Any>({ desc, result ->
                // if (!desc.parent) { // will match the outermost suite
                val output =
                    "Results: ${result.resultType} (${result.testCount} tests, ${result.successfulTestCount} passed, ${result.failedTestCount} failed, ${result.skippedTestCount} skipped)"
                println(output)
                // }
            }))
        }
    }
}


