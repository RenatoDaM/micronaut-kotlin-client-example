package example.micronaut

import io.micronaut.runtime.Micronaut.run
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License


@OpenAPIDefinition(
	info = Info(
		title = "Hello World",
		version = "0.0",
		description = "My API",
		license = License(name = "Apache 2.0", url = "https://foo.bar"),
		contact = Contact(url = "https://gigantic-server.com", name = "Fred", email = "Fred@gigagantic-server.com")
	)
)
object Application {
	@JvmStatic
	fun main(args: Array<String>) {

		run(*args)
	}
}


