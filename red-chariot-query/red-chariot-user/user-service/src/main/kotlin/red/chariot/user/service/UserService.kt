package red.chariot.user.service

import java.util.UUID
import red.chariot.user.service.model.User

interface UserService {

    fun getUser(userId: UUID): User

    fun getUserList(search: String?): List<User>

}