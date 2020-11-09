package com.treino

import io.micronaut.runtime.Micronaut.build

fun main(args: Array<String>) {
    build()
            .args(*args)
            .packages("com.treino")
            .defaultEnvironments("dev")
            .start()
}

