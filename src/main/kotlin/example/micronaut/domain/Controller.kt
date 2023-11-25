package example.micronaut.domain

import example.micronaut.domain.model.Usuario
import example.micronaut.domain.repository.UsuarioRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono

@Controller("/teste")
@ApiResponses(
    ApiResponse(content = [Content(mediaType = "text/plain", schema = Schema(type = "string"))]),
    ApiResponse(responseCode = "400", description = "Invalid Name Supplied"),
    ApiResponse(responseCode = "404", description = "Person not found")
)
open class Controller(private val repository: UsuarioRepository) {
    @Post("/aluno")
    open fun save(@Body usuario: Usuario): Publisher<HttpResponse<Usuario>>? {
        return Mono.from(repository.saveUsuario(usuario))
            .map {
                HttpResponse.created(it!!)
            }
    }
}