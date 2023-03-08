package com.example.crudkotlinexample.modules.user.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class UserRequest (
        @NotBlank
        val name: String,
        @Email
        @NotBlank
        val email: String,
        val telephone: String,
        val city: String
)