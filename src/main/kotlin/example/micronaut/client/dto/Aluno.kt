package example.micronaut.client.dto

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

@Serdeable
@Introspected
data class Aluno(
    val id: Long, val ra: String, val nome: String, val email: String,
    val telefone1: String, val telefone2: String? = null)
