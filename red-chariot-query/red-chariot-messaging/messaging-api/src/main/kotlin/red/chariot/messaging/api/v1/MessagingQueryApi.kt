package red.chariot.messaging.api.v1

import red.chariot.messaging.api.v1.dto.ConversationQueryCriteriaDto
import red.chariot.messaging.api.v1.dto.ConversationSearchResultDto
import red.chariot.messaging.api.v1.dto.MessageQueryCriteriaDto
import red.chariot.messaging.api.v1.dto.MessageSearchResultDto

interface MessagingQueryApi {

    fun getMessageList(): (MessageQueryCriteriaDto) -> MessageSearchResultDto

    fun getConversationList(): (ConversationQueryCriteriaDto) -> ConversationSearchResultDto
}
