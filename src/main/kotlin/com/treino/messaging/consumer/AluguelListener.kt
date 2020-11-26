package com.treino.messaging.consumer

import com.treino.messaging.model.AluguelMessge
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class AluguelListener {
    @Topic("aluguel_carros")
    fun ouvir(@KafkaKey symbol: String, aluguelMessge: AluguelMessge) {
        println("Mensagem ouvida $aluguelMessge")
    }
}