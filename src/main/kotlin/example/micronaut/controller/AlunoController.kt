package example.micronaut.controller;

import PageResponse
import example.micronaut.client.FaculdadeLowLevelClient;
import example.micronaut.client.dto.Aluno
import example.micronaut.client.dto.ContentResponse
import io.micronaut.core.async.annotation.SingleResult
import io.micronaut.data.model.Page
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get
import io.reactivex.rxjava3.core.Flowable
import org.reactivestreams.Publisher

@Controller("/faculdade")
public class AlunoController (private val faculdadeLowLevelCleint :FaculdadeLowLevelClient) {
    @Get("/releases-lowlevel")
    @SingleResult
    fun releasesWithLowLevelClient(): Publisher<ContentResponse>? {
        return faculdadeLowLevelCleint.fetchAlunos()
    }
}
