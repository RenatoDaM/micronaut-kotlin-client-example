package example.micronaut
import example.micronaut.client.FaculdadeLowLevelClient
import example.micronaut.client.dto.Aluno
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.serde.annotation.SerdeImport
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject

@MicronautTest
@SerdeImport(Aluno::class)
class MicronautguideTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
        var teste: FaculdadeLowLevelClient
    }

}
