package red.chariot.user.service.model

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity(name = "user")
@Table(name = "user")
class User(

    @Id
    var id: UUID,

    var name: String,

    var profileImageId: UUID? = null
)