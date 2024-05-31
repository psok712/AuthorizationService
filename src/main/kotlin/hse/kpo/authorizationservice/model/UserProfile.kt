package hse.kpo.authorizationservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.sql.Timestamp

@Table("users")
class UserProfile(
    @Id
    @Column("id")
    val id: Int? = null,
    @Column("nickname")
    private val nickname: String,
    @Column("email")
    private val email: String,
    @Column("password")
    private val password: String,
    @Column("created")
    val created: Timestamp? = null
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority>  = mutableListOf()

    override fun getPassword(): String = password

    override fun getUsername(): String = nickname

    fun getEmail(): String = email

    override fun isAccountNonExpired(): Boolean {
        // Можно добавить логику для проверки срока действия аккаунта
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        // Можно добавить логику для проверки блокировки аккаунта
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        // Можно добавить логику для проверки срока действия учетных данных
        return true
    }

    override fun isEnabled(): Boolean {
        // Можно добавить логику для проверки активации аккаунта
        return true
    }
}