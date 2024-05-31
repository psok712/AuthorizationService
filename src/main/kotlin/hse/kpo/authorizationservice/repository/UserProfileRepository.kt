package hse.kpo.authorizationservice.repository

import hse.kpo.authorizationservice.model.UserProfile
import org.springframework.data.repository.CrudRepository

interface UserProfileRepository : CrudRepository<UserProfile, Int> {
    fun findByEmail(email: String?): UserProfile?
}