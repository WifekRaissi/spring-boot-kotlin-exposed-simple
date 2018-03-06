package com.city.city.services


import com.city.city.entities.User
import org.jetbrains.exposed.sql.ResultRow


interface UserService {


    fun create(user: User): User
    fun findAll(): List<User>

    fun deleteAll(): Int
    fun delete(firstName: String): Int
    fun updateUser(id: Int, firstName: String)
    fun findById(id: Int): ResultRow?
}