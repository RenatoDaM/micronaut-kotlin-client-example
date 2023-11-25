package example.micronaut.client.controller;

import example.micronaut.client.FaculdadeLowLevelClient;
import example.micronaut.client.dto.ContentResponse
import io.micronaut.core.async.annotation.SingleResult
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get
import org.reactivestreams.Publisher

@Controller("/faculdade")
class AlunoController (private val faculdadeLowLevelCleint :FaculdadeLowLevelClient) {
    @Get("/alunos")
    @SingleResult
    fun releasesWithLowLevelClient(): Publisher<ContentResponse>? {
        return faculdadeLowLevelCleint.fetchAlunos()
    }
}
