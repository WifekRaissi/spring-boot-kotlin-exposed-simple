package com.city.city.repositories

import com.city.city.entities.User
import org.jetbrains.exposed.sql.ResultRow


interface UserRepository{


    fun createTable()
    fun create(user: User): User
    fun findAll(): List<User>
    fun deleteAll(): Int
    fun delete(firstName: String): Int
    fun updateUser(id: Int, firstName: String)
    fun findByid(id: Int): ResultRow?
}