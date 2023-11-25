package example.micronaut.domain.repository

import example.micronaut.domain.model.Usuario
import io.micronaut.data.annotation.Id
import io.micronaut.data.exceptions.DataAccessException
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.r2dbc.annotation.R2dbcRepository
import io.micronaut.data.repository.reactive.ReactorPageableRepository
import jakarta.transaction.Transactional
import reactor.core.publisher.Mono

@R2dbcRepository(dialect = Dialect.POSTGRES)
abstract class UsuarioRepository: ReactorPageableRepository<Usuario, Long> {
    fun saveUsuario(usuario: Usuario): Mono<Usuario?> {
        return save(Usuario(id = null, username = usuario.username, password = usuario.password))
    }

    @Transactional
    open fun saveWithException(usuario: Usuario): Mono<Usuario> {
        return saveUsuario(usuario)
            .handle { _, sink ->
                sink.error(DataAccessException("test exception"))
            }
    }

    fun updateUsuario(@Id id: Long, usuario: Usuario): Mono<Usuario> {
        return update(Usuario(id = null, username = usuario.username, password = usuario.password))
    }
}