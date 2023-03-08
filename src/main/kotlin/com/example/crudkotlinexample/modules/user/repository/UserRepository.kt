package com.example.crudkotlinexample.modules.user.repository

import com.example.crudkotlinexample.modules.user.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {
}