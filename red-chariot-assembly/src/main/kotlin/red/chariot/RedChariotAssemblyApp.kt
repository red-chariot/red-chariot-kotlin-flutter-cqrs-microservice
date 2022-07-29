package red.chariot

import io.happykiddo.assembly.sanitizePropertyValue
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RedChariotAssemblyApp

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<RedChariotAssemblyApp>(*args)
}
