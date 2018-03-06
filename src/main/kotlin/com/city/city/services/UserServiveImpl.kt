package com.city.city.services

import com.city.city.entities.User
import com.city.city.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service



@Service
class UserServiceImpl: UserService {


    @Autowired
    lateinit var repository: UserRepository

    override fun create(user: User): User {
        repository.create(user)
        return user
    }

    override fun findAll() = repository.findAll()
    override fun deleteAll() = repository.deleteAll()
    override fun delete(firstName:String) =repository.delete(firstName)
    override fun updateUser(id:Int,firstName:String)=repository.updateUser(id,firstName)
    override fun findById(id:Int)=repository.findByid(id)


}


