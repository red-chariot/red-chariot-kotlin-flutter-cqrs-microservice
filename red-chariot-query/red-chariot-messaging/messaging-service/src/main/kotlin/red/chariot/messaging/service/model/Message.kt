package red.chariot.messaging.service.model

import java.time.OffsetDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity(name = "message")
@Table(name = "message")
class Message(

    @Id
    var messageId: UUID,

    val senderUserId: UUID,

    val recipientUserId: UUID,

    var text: String,

    val messageDate: OffsetDateTime

)