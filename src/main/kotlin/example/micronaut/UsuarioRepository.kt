package example.micronaut.domain.testing.testingtwo

import example.micronaut.domain.model.Usuario
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.Repository
import io.micronaut.data.exceptions.DataAccessException
import io.micronaut.data.repository.reactive.ReactorPageableRepository
import jakarta.transaction.Transactional
import jakarta.validation.constraints.NotBlank
import reactor.core.publisher.Mono

@Repository
abstract class UsuarioRepository: ReactorPageableRepository<Usuario, Long> {
    fun saveUsuario(usuario: Usuario): Mono<Usuario?> {
        return save(Usuario(id = null, username = usuario.username, password = usuario.password))
    }

    @Transactional
    open fun saveWithException(usuario: Usuario): Mono<Usuario> {
        return save(usuario)
            .handle { _, sink ->
                sink.error(DataAccessException("test exception"))
            }
    }

    fun updateUsuario(@Id id: Long, usuario: Usuario): Mono<Usuario> {
        return update(Usuario(id = null, username = usuario.username, password = usuario.password))
    }
}