package hse.kpo.authorizationservice.service

import hse.kpo.authorizationservice.configuration.RegexConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ValidationService{

    @Autowired
    lateinit var regexConfig: RegexConfig

    fun isValidEmail(email: String): Boolean {
        return email.matches(regexConfig.emailRegex.toRegex())
    }

    fun isValidPassword(password: String): Boolean {
        return password.matches(regexConfig.passwordRegex.toRegex())
    }
}