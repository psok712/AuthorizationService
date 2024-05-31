package hse.kpo.authorizationservice.service

import hse.kpo.authorizationservice.repository.UserProfileRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserProfileService(
    private val userProfileRepository: UserProfileRepository
) : UserDetailsService {

    override fun loadUserByUsername(email: String?): UserDetails =
        userProfileRepository.findByEmail(email)
            ?: throw UsernameNotFoundException("Email: $email - not found")
}