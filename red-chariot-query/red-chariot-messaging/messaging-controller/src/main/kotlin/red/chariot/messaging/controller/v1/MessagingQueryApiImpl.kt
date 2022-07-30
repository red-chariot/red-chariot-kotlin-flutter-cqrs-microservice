package red.chariot.messaging.controller.v1

import org.springframework.stereotype.Service
import red.chariot.messaging.api.v1.dto.ConversationDto
import red.chariot.messaging.api.v1.dto.ConversationQueryCriteriaDto
import red.chariot.messaging.api.v1.dto.ConversationSearchResultDto
import red.chariot.messaging.api.v1.dto.MessageDto
import red.chariot.messaging.api.v1.dto.MessageQueryCriteriaDto
import red.chariot.messaging.api.v1.dto.MessageSearchResultDto
import red.chariot.messaging.service.MessagingService
import red.chariot.messaging.service.model.Conversation
import red.chariot.messaging.service.model.Message

@Service
class MessagingQueryApiImpl(val messagingService: MessagingService) {

    fun getMessageList(): (MessageQueryCriteriaDto) -> MessageSearchResultDto {
        return { criteria ->
            messagingService.getMessageList(
                ownerUserId = criteria.ownerUserId,
                opponentUserId = criteria.opponentUserId
            ).messageSearchResultDto()
        }
    }

    fun getConversationList(): (ConversationQueryCriteriaDto) -> ConversationSearchResultDto {
        return { criteria ->
            messagingService.getConversationList(
                ownerUserId = criteria.ownerUserId,
                search = criteria.search
            ).conversationSearchResultDto()
        }
    }

    fun Message.messageDto(): MessageDto = MessageDto(
        messageId = messageId,
        senderUserId = senderUserId,
        recipientUserId = recipientUserId,
        text = text,
        messageDate = messageDate
    )

    fun List<Message>.messageSearchResultDto(): MessageSearchResultDto = MessageSearchResultDto(
        map { message -> message.messageDto() }
    )

    fun Conversation.conversationDto(): ConversationDto = ConversationDto(
        conversationId = conversationId,
        ownerUserId = ownerUserId,
        opponentUserId = opponentUserId,
        opponentName = opponentName,
        opponentProfileImageId = opponentProfileImageId,
        lastMessage = lastMessage?.messageDto()
    )

    fun List<Conversation>.conversationSearchResultDto(): ConversationSearchResultDto = ConversationSearchResultDto(
        map { conversation -> conversation.conversationDto() }
    )
}

