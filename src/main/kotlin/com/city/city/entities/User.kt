package com.city.city.entities

import org.joda.time.DateTime

class User(
       val id:Int,
        val firstName  : String="",
        val lastName : String="",
       val birthDay: DateTime? = DateTime.parse("2000/02/23")


)