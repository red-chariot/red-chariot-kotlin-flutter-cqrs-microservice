package red.chariot.command.controller.v1

import java.util.UUID
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import red.chariot.command.api.v1.CommandResponseDto
import red.chariot.command.api.v1.messaging.dto.SendMessageDto

@Service
internal class SendMessageApiImpl {

    @Bean
    fun sendMessage(): (SendMessageDto) -> CommandResponseDto {
        return { command ->
            CommandResponseDto(id = UUID.randomUUID()) // TODO implement
        }
    }
}
