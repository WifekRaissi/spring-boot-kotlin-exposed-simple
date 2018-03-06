package com.city.city.controllers

import com.city.city.entities.User
import com.city.city.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping
class UserController {

    @Autowired
    lateinit var userService: UserService
    @PostMapping("/users")
            //@ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody user: User) {
        userService.create(user)


    }
    @GetMapping("/users")
    fun getAllUsers() =userService.findAll()

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable("id") id: Int) =userService.findById(id)

    @DeleteMapping("/users")
    fun deleteUsers() =
            userService.deleteAll()

    @DeleteMapping("/users/{firstName}")
    fun deleteUser(@PathVariable  firstName: String)=userService.delete(firstName)

    @PutMapping("users/{id}")
    fun updateUser(@PathVariable id: Int, @RequestBody firstName: String)=userService.updateUser(id,firstName)


}