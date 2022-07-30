package red.chariot.messaging.service

import java.util.UUID
import red.chariot.messaging.service.model.Conversation
import red.chariot.messaging.service.model.Message

interface MessagingService {

    fun getMessageList(
        ownerUserId: UUID, opponentUserId: UUID
    ): List<Message>

    fun getConversationList(
        ownerUserId: UUID, search: String?
    ): List<Conversation>

}