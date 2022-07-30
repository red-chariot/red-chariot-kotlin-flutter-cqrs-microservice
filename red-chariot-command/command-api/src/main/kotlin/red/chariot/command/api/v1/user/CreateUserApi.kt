package red.chariot.command.api.v1.user

import red.chariot.command.api.v1.CommandResponseDto
import red.chariot.command.api.v1.user.dto.CreateUserDto

interface CreateUserApi {

    fun createUser(): (CreateUserDto) -> CommandResponseDto
}
