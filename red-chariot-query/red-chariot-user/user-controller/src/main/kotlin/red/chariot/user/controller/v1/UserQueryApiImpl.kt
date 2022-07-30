package red.chariot.user.controller.v1

import java.util.UUID
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import red.chariot.user.api.v1.UserQueryApi
import red.chariot.user.api.v1.dto.UserDto
import red.chariot.user.api.v1.dto.UserQueryCriteriaDto
import red.chariot.user.api.v1.dto.UserSearchResultDto
import red.chariot.user.service.UserService
import red.chariot.user.service.model.User

@Service
class UserQueryApiImpl(val userService: UserService) : UserQueryApi {

    @Bean
    override fun getUser(): (UUID) -> UserDto {
        return { userId ->
            userService.getUser(userId).userDto()
        }
    }

    @Bean
    override fun getUserList(): (UserQueryCriteriaDto) -> UserSearchResultDto {
        return { criteria ->
            userService.getUserList(search = criteria.search).userSearchResultDto()
        }
    }

    fun User.userDto(): UserDto = UserDto(
        userId = id,
        name = name,
        profileImageId = profileImageId
    )

    fun List<User>.userSearchResultDto(): UserSearchResultDto =
        UserSearchResultDto(map { user -> user.userDto() })
}
