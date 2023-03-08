package com.example.crudkotlinexample.modules.user.model

import com.example.crudkotlinexample.modules.user.dto.UserRequest
import jakarta.persistence.*

@Entity
@Table(name = "users")
class User(
    var name: String,
    var email: String,
    var telephone: String,
    var city: String
) {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    companion object {
        fun of(dto: UserRequest): User {
            return User(dto.name, dto.email, dto.telephone, dto.city).apply {  }
        }
    }

}


