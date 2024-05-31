package hse.kpo.authorizationservice
import hse.kpo.authorizationservice.configuration.RegexConfig
import hse.kpo.authorizationservice.service.ValidationService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class RegexValidatorTest {

    @Autowired
    private lateinit var validationService: ValidationService

    @Autowired
    private lateinit var regexConfig: RegexConfig

    @Test
    fun validEmailTest() {
        val email = "alex@yandex.ru"
        val valid = validationService.isValidEmail(email)
        assert(true)
    }

    @Test
    fun invalidEmailTest() {
        val email = "devcolibri"
        val valid = !validationService.isValidEmail(email)
        assert(true)
    }
}