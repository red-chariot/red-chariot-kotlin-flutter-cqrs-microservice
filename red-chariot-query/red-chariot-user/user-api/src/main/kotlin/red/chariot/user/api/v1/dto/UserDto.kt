package red.chariot.user.api.v1.dto

import java.util.UUID

data class UserDto(
    val userId: UUID,
    val name: String,
    val profileImageId: UUID?
)

data class UserQueryCriteriaDto(
    val search: String?
)

data class UserSearchResultDto(
    val staffers: List<UserDto>
)
