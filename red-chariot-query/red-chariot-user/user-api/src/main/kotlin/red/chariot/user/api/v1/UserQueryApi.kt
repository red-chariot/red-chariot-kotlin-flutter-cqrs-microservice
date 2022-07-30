package red.chariot.user.api.v1

import java.util.UUID
import red.chariot.user.api.v1.dto.UserDto
import red.chariot.user.api.v1.dto.UserQueryCriteriaDto
import red.chariot.user.api.v1.dto.UserSearchResultDto

interface UserQueryApi {

    fun getUser(): (UUID) -> UserDto

    fun getUserList(): (UserQueryCriteriaDto) -> UserSearchResultDto
}
