package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
internal class TestController {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    fun test() {
        val bla = mapOf("oi" to 1, "ola" to 2)
        logger.info()
    }
}
