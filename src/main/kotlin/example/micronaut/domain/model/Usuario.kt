package example.micronaut.domain.model

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GenerationType
import jakarta.persistence.Table

@Entity
@Serdeable
@Table
data class Usuario (
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    var id: Long? = null,
    @Column(name = "username", nullable = false)
    val username: String,
    @Column(name = "password", nullable = false)
    val password: String
) {
    // Construtor primário que aceita todos os parâmetros
    constructor(username: String, password: String) : this(null, username, password)
}


