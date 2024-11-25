package nu.westlin.springtipsspringmodulith

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter


class ApplicationTests {

    private val modules = ApplicationModules.of(Application::class.java)

    @Test
    fun `verify modules`() {
        modules.verify()
    }

    @Test
    fun `write documentation snippets`() {
        Documenter(modules)
            .writeDocumentation()
    }

    @Test
    fun `print modules`() {
        modules.forEach(::println)
    }
}
