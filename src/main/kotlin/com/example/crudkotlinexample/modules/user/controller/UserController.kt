package com.example.crudkotlinexample.modules.user.controller

import com.example.crudkotlinexample.modules.user.dto.UserRequest
import com.example.crudkotlinexample.modules.user.model.User
import com.example.crudkotlinexample.modules.user.service.UserService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/users")
class UserController {

    @Autowired
    lateinit var service: UserService

    @GetMapping
    fun getAll (): List<User> {
        return service.getAll()
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: Long): User {
        return service.getById(id)
    }

    @PostMapping
    fun createUser(@Valid @RequestBody request: UserRequest): User {
        return service.createUser(request)
    }

    @PutMapping("{id}")
    fun updateUser (@PathVariable id: Long,
                    @Valid @RequestBody request: UserRequest) : User {
        return service.updateUser(id, request)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) : User {
        return service.delete(id)
    }
}