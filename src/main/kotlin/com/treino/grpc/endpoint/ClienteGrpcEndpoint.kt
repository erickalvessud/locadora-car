package com.treino.grpc.endpoint

import com.treino.ClienteRequest
import com.treino.ClienteResponse
import com.treino.ClienteServiceGrpcKt
import com.treino.service.ClienteService
import javax.inject.Singleton

@Singleton
class ClienteGrpcEndpoint(private val clienteService: ClienteService) : ClienteServiceGrpcKt.ClienteServiceCoroutineImplBase() {

    override suspend fun save(request: ClienteRequest): ClienteResponse {

        return clienteService.save(request)
    }

    override suspend fun update(request: ClienteRequest): ClienteResponse {

        return clienteService.update(request)
    }
}