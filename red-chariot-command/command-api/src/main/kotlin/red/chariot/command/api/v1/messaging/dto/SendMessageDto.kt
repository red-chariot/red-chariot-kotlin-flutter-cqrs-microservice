package red.chariot.command.api.v1.messaging.dto

import java.util.UUID

data class SendMessageDto(

    val targetUserId: UUID,

    val text: String
)
