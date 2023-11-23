package example.micronaut.client;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Requires;

@ConfigurationProperties(FaculdadeConfiguration.PREFIX)
@Requires(property = FaculdadeConfiguration.PREFIX)
class FaculdadeConfiguration {
    var organization: String? = null
    var repo: String? = null
    var username: String? = null
    var token: String? = null
    companion object {
        const val PREFIX = "faculdade"
    }
}
