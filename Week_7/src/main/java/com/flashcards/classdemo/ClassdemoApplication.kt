package com.flashcards.classdemo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
object ClassdemoApplication {

    fun main(args: Array<String>) {
        SpringApplication.run(ClassdemoApplication::class.java, args)
    }
}
