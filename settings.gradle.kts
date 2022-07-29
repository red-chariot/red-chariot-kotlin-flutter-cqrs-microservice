pluginManagement {
    val gradlePluginVersion = object {

    }
    plugins {

    }
}

plugins {


}

rootProject.name = "red-chariot"
include("red-chariot-command")
include("red-chariot-command:command-api")
include("red-chariot-command:command-service")
include("red-chariot-command:command-controller")
include("red-chariot-command:command-eventbus")
include("red-chariot-query")
include("red-chariot-query:red-chariot-messaging")
include("red-chariot-query:red-chariot-messaging:messaging-api")
include("red-chariot-query:red-chariot-messaging:messaging-service")
include("red-chariot-query:red-chariot-messaging:messaging-controller")
include("red-chariot-query:red-chariot-messaging:messaging-eventbus")
include("red-chariot-query:red-chariot-user")
include("red-chariot-query:red-chariot-user:user-api")
include("red-chariot-query:red-chariot-user:user-service")
include("red-chariot-query:red-chariot-user:user-controller")
include("red-chariot-query:red-chariot-user:user-eventbus")
include("red-chariot-ui")
include("red-chariot-it")