package com.city.city

import org.jetbrains.exposed.sql.Table



object Users : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val firstName = text("firstName")
    val lastName = text("lastName")
  //  val birthDay = datetime("birthDay")

}