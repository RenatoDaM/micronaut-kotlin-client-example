package example.micronaut.domain.config

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("application")
class ApplicationConfigurationProperties: ApplicationConfiguration {
    private val DEFAULT_MAX = 10
    override var max = DEFAULT_MAX
}