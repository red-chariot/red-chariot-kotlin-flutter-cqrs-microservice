package red.chariot.command.api.v1.messaging

import red.chariot.command.api.v1.CommandResponseDto
import red.chariot.command.api.v1.messaging.dto.SendMessageDto

interface SendMessageApi {

    fun sendMessage(): (SendMessageDto) -> CommandResponseDto
}
