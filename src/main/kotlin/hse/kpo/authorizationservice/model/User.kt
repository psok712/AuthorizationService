package hse.kpo.authorizationservice.model

import org.springframework.data.relational.core.mapping.Column

data class User (
    val nickname: String,
    val email: String,
    val password: String
)