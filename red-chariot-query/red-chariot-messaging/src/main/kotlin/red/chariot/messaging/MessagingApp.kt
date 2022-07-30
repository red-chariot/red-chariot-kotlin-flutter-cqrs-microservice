package red.chariot.messaging

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CommandApp

fun main(args: Array<String>) {
    runApplication<CommandApp>(*args)
}