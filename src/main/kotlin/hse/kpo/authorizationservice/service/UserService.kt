package hse.kpo.authorizationservice.service

import hse.kpo.authorizationservice.model.UserProfile
import hse.kpo.authorizationservice.repository.UserProfileRepository
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.sql.Timestamp
import java.time.Instant
import kotlin.io.encoding.ExperimentalEncodingApi

@Service
@ExperimentalEncodingApi
class UserService(
    private val passwordEncoder: PasswordEncoder,
    private val userProfileRepository: UserProfileRepository,
    private val validationService: ValidationService
) {

    @Transactional
    fun registerUser(userProfile: UserProfile) : HttpEntity<String> {
        if (userProfileRepository.findByEmail(userProfile.username) != null) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("This email is already taken")
        }

        if (!validationService.isValidEmail(userProfile.getEmail())) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("This email address is invalid")
        }

        if (!validationService.isValidPassword(userProfile.password)) {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("This password is invalid")
        }

        userProfileRepository.save(
            UserProfile(
                nickname = userProfile.username,
                email = userProfile.getEmail(),
                password = passwordEncoder.encode(userProfile.password),
                created = Timestamp.from(Instant.now())
            )
        )

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body("User registered successfully")
    }
}