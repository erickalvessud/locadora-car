package com.treino.grpc.endpoint

import com.treino.PecaRequest
import com.treino.PecaResponse
import com.treino.PecaServiceGrpcKt
import com.treino.service.PecaService
import javax.inject.Singleton

@Singleton
class PecaGrpcEndpoint(private val pecaService: PecaService) : PecaServiceGrpcKt.PecaServiceCoroutineImplBase() {

    override suspend fun save(request: PecaRequest): PecaResponse {

        return pecaService.save(request)
    }

    override suspend fun update(request: PecaRequest): PecaResponse {

        return pecaService.save(request)
    }
}