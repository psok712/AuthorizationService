package hse.kpo.authorizationservice.controller

import hse.kpo.authorizationservice.model.User
import hse.kpo.authorizationservice.model.UserProfile
import hse.kpo.authorizationservice.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.io.encoding.ExperimentalEncodingApi

@RestController
@RequestMapping
@ExperimentalEncodingApi
class AuthenticationController(
    private val userService: UserService
) {

    @PostMapping("register")
    fun register(@RequestBody userProfile: UserProfile) = userService.registerUser(userProfile)
}