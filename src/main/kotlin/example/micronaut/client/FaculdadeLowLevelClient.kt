package example.micronaut.client

import PageResponse
import example.micronaut.client.dto.Aluno
import example.micronaut.client.dto.ContentResponse
import io.micronaut.core.type.Argument
import io.micronaut.data.model.Page
import io.micronaut.http.HttpHeaders.ACCEPT
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.uri.UriBuilder
import io.micronaut.json.tree.JsonNode
import jakarta.inject.Singleton
import org.reactivestreams.Publisher
import java.net.URI

@Singleton
class FaculdadeLowLevelClient(@param: Client(id = "faculdade") private val httpClient: HttpClient){
    private val uri: URI = UriBuilder.of("/faculdade/aluno").build()

    fun fetchAlunos(): Publisher<ContentResponse>? {
        val req: HttpRequest<*> = HttpRequest.GET<Any>(uri)
            .header(ACCEPT, "application/json")


        return httpClient.retrieve(req, Argument.of(ContentResponse::class.java))    }
}