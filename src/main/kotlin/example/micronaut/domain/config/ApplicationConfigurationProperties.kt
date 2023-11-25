package example.micronaut.domain.config

import example.micronaut.domain.testing.testingtwo.ApplicationConfiguration
import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties("application")
class ApplicationConfigurationProperties: ApplicationConfiguration {
    private val DEFAULT_MAX = 10
    override var max = DEFAULT_MAX
}