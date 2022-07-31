package red.chariot.command.controller.v1

import java.util.UUID
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import red.chariot.command.api.v1.CommandResponseDto
import red.chariot.command.api.v1.user.dto.CreateUserDto

@Service
internal class CreateUserApiImpl {

    @Bean
    fun createUser(): (CreateUserDto) -> CommandResponseDto {
        return { command ->
            CommandResponseDto(id = UUID.randomUUID()) // TODO implement
        }
    }
}
