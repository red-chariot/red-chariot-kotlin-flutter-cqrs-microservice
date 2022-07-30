package red.chariot.messaging.service.model

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity(name = "conversation")
@Table(name = "conversation")
class Conversation(

    @Id
    var conversationId: UUID,

    val ownerUserId: UUID,

    val opponentUserId: UUID,

    val opponentName: String,

    var opponentProfileImageId: UUID?,

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(
        name = "last_message_id", insertable = false, updatable = false
    )
    val lastMessage: Message?
)