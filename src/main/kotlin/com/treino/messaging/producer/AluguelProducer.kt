package com.treino.messaging.producer

import com.treino.messaging.model.AluguelMessge
import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.KafkaKey
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaClient
interface AluguelProducer {
    
    @Topic("aluguel_carros")
    fun send(@KafkaKey symbol: String, aluguel: AluguelMessge)
}