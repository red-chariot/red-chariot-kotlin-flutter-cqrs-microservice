package red.chariot.controller.v1

import java.util.UUID
import red.chariot.command.api.v1.CommandResponseDto
import red.chariot.command.api.v1.user.dto.CreateUserDto

internal class CreateUserApiImpl {

    fun createUser(): (CreateUserDto) -> CommandResponseDto {
        return { command ->
            CommandResponseDto(id = UUID.randomUUID()) // TODO implement
        }
    }
}
