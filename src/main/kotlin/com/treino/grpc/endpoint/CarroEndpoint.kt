package com.treino.grpc.endpoint

import com.treino.*
import com.treino.service.CarroService
import javax.inject.Singleton

@Singleton
class CarroEndpoint(private val carroService: CarroService) : CarroServiceGrpcKt.CarroServiceCoroutineImplBase() {

    @Override
    override suspend fun consultaTodos(request: ConsultaTodosRequest): ConsultaTodosResponse {

        return carroService.consultaTotos(request)!!
    }

    override suspend fun salvaCarro(request: SalvaCarroRequest): CarroReply {
        return carroService.salvaCarro(request)
    }
}