package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping

@SpringBootApplication class DemoApplication

@RestController
@RequestMapping("/")
class APIController {
    @GetMapping
    fun hello(): String {
        return "Hello, World!"
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
