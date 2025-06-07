package com.example

import io.micronaut.context.annotation.Bean
import io.micronaut.scheduling.annotation.Scheduled
import org.slf4j.LoggerFactory

@Bean
class NormalScheduledTask {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Scheduled(fixedDelay = "10s", initialDelay = "5s")
    fun execute() {
        logger.info("I'm executing as a normal function - ${Thread.currentThread().name}")
    }

}