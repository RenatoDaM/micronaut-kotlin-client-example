package example.micronaut.domain.model

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column

@MappedEntity
@Serdeable
data class Usuario(
    @jakarta.persistence.Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    @Column(name = "id", unique = true)
    var id: Long? = null,
    @Column(name = "username", nullable = false)
    val username: String,
    @Column(name = "password", nullable = false)
    val password: String
) {
    // Construtor primário
    constructor(username: String, password: String) : this(null, username, password)

    // Construtor sem argumentos
    constructor() : this(null, "", "")
}


