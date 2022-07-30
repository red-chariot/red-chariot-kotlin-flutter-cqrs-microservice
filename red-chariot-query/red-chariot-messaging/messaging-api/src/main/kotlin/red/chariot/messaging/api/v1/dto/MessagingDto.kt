package red.chariot.messaging.api.v1.dto

import java.time.OffsetDateTime
import java.util.UUID

data class MessageDto(
    val messageId: UUID,
    val senderUserId: UUID,
    val recipientUserId: UUID,
    var text: String,
    val messageDate: OffsetDateTime
)

data class ConversationDto(
    val conversationId: UUID,
    val ownerUserId: UUID,
    val opponentUserId: UUID,
    val opponentName: String,
    var opponentProfileImageId: UUID?,
    val lastMessage: MessageDto?
)

data class MessageQueryCriteriaDto(
    val ownerUserId: UUID,
    val opponentUserId: UUID
)

data class MessageSearchResultDto(
    val messages: List<MessageDto>
)

data class ConversationQueryCriteriaDto(
    val ownerUserId: UUID,
    val search: String?
)

data class ConversationSearchResultDto(
    val conversations: List<ConversationDto>
)
