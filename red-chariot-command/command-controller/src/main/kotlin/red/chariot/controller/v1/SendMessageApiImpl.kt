package red.chariot.controller.v1

import red.chariot.command.api.v1.CommandResponseDto
import red.chariot.command.api.v1.messaging.dto.SendMessageDto

internal class SendMessageApiImpl {

    fun sendMessage(): (SendMessageDto) -> CommandResponseDto {
        return { command ->
            CommandResponseDto() // TODO implement
        }
    }
}
