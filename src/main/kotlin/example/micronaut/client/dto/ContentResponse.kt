package example.micronaut.client.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

@Introspected
@Serdeable
data class ContentResponse(
    @JsonProperty("content") val content: List<Aluno>
)