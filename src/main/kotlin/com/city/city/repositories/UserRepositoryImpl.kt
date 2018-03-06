package com.city.city.repositories

import com.city.city.Users
import com.city.city.entities.User
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.statements.UpdateBuilder
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional


@Repository
@Transactional
class UserRepositoryImpl: UserRepository {


    override fun createTable() = SchemaUtils.create(Users)


    private fun toRow(user: User): Users.(UpdateBuilder<*>) -> Unit = {
     // it[id]=user.id
        it[firstName] = user.firstName
        it[lastName] = user.lastName
        it[birthDay]=user.birthDay


    }

    private fun fromRow(r: ResultRow) =
            User(r[Users.id],r[Users.firstName], r[Users.lastName], r[Users.birthDay])

    override fun create(user: User): User {
        Users.insert(toRow(user))
        return user
    }


    override fun findAll() = Users.selectAll().map { fromRow(it) }
    override fun deleteAll() = Users.deleteAll()
    override fun delete(firstName: String) = Users.deleteWhere { Users.firstName like firstName }

    override fun updateUser(id: Int, name: String) {
        Users.update({ Users.id eq id }) { it[firstName] = name }

    }

    override fun findByid(id: Int) =
            Users.select { Users.id.eq(id) }.firstOrNull()


}

