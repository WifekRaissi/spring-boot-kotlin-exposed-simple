package com.city.city

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

import org.jetbrains.exposed.spring.SpringTransactionManager


@SpringBootApplication
@EnableTransactionManagement
class CityApplication {

    @Bean
    open fun transactionManager(dataSource: DataSource) = SpringTransactionManager(dataSource)

}

fun main(args: Array<String>) {
    runApplication<CityApplication>(*args)
}
