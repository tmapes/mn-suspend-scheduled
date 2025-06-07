package com.example

import io.micronaut.context.annotation.Bean
import io.micronaut.scheduling.annotation.Scheduled
import kotlinx.coroutines.delay
import org.slf4j.LoggerFactory

@Bean
class CoroutineScheduledTask {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Scheduled(fixedDelay = "10s", initialDelay = "5s")
    suspend fun execute() {
        delay(250)
        logger.info("I'm executing inside a coroutine - ${Thread.currentThread().name}")
    }

}