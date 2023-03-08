package com.example.crudkotlinexample.modules.user.service

import com.example.crudkotlinexample.modules.user.dto.UserRequest
import com.example.crudkotlinexample.modules.user.model.User
import com.example.crudkotlinexample.modules.user.repository.UserRepository
import jakarta.transaction.Transactional
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var repository: UserRepository

    fun getAll(): List<User> {
        return repository.findAll();
    }

    fun createUser(request: UserRequest): User {
        val user = User;
        return repository.save(User.of(request));
    }

    @Transactional
    fun updateUser (id: Long, request: UserRequest) : User {
        var user = findUserById(id)

        user.apply {
            this.id = id
            this.name = request.name
            this.email = request.email
            this.telephone = request.telephone
            this.city = request.city

        }
        return user
    }

    fun delete (id: Long): User {
        val user = findUserById(id)
        repository.delete(user)
        return user
    }

    fun getById(id: Long): User {
        return findUserById(id)
    }

    private fun findUserById(id: Long) : User {
        return repository.findById(id).orElseThrow()
    }
}