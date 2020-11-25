package com.treino.messaging

import com.treino.messaging.model.AluguelMessge
import com.treino.messaging.producer.AluguelProducer
import io.micronaut.scheduling.annotation.Scheduled
import java.util.concurrent.ThreadLocalRandom
import javax.inject.Singleton

@Singleton
class EventScheduler(val aluguelProducer: AluguelProducer) {

    val carros = arrayListOf("fit", "civic", "uno", "hb20")

    @Scheduled(fixedDelay = "10s")
    fun gerar(){
        val random = ThreadLocalRandom.current()

        var aluguelMessage = AluguelMessge("cd_${random.nextInt(0, 100)}", carros.get(random.nextInt(0,carros.size - 1)))

        println("Gerando uma mensagem $aluguelMessage")
        this.aluguelProducer.send(aluguelMessage.simbolo, aluguelMessage)
    }
}