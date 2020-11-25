package com.treino.grpc.endpoint.domain

import com.treino.SalvaCarroRequest
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank

@Introspected
class CarroRequest(
        @field:NotBlank var modelo: String,
        val cor: String,
        val marca: String,
        val placa: String,
        val valorDiaria: Double){
}

fun SalvaCarroRequest.toCarroRequest(): CarroRequest {
    return CarroRequest(
            this.modelo,
            this.cor,
            this.marca,
            this.placa,
            this.valorDiaria
    )
}