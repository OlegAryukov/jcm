package ru.jcm.jcm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JcmApplication

fun main(args: Array<String>) {
    runApplication<JcmApplication>(*args)
}
