package red.chariot.core.log

import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.classic.spi.ThrowableProxyUtil
import ch.qos.logback.core.LayoutBase
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.MDC

class LogLayout : LayoutBase<ILoggingEvent>() {

    override fun doLayout(event: ILoggingEvent): String {
        val message =
            "${event.formattedMessage}\n${
                event.throwableProxy?.let {
                    "    ${
                        ThrowableProxyUtil.asString(
                            it
                        )
                    }\n"
                } ?: ""
            }"

        val logEntry = LogEntry(
            severity = event.level.toString(),
            message = message,
            labels = Labels(
                threadName = event.threadName,
                loggerName = event.loggerName,
                marker = event.marker?.name,
                correlationId = MDC.get("X-Correlation-ID"),
                executionTime = MDC.get("execution-time"),
                buildNum = System.getenv(
                    "INFO_APP_BUILD"
                )
            ),
            executionTime = MDC.get("execution-time")
        )
        return ObjectMapper().writeValueAsString(logEntry) + "\n"
    }
}

private data class LogEntry(
    val severity: String,
    val message: String,
    @get:JsonProperty(value = "logging.googleapis.com/labels")
    val labels: Labels,
    val executionTime: String?
)

private data class Labels(
    val threadName: String?,
    val loggerName: String?,
    val marker: String?,
    val correlationId: String?,
    val executionTime: String?,
    val buildNum: String
)