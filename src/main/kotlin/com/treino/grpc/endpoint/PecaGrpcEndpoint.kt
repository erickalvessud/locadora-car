package com.treino.grpc.endpoint

import com.treino.CarroServiceGrpcKt
import com.treino.PecaResponse
import com.treino.PecaSaveRequest
import com.treino.PecaUpdateRequest
import com.treino.service.PecaService
import javax.inject.Singleton

@Singleton
class PecaGrpcEndpoint(private val pecaService: PecaService) : CarroServiceGrpcKt.CarroServiceCoroutineImplBase() {

    override suspend fun pecaSave(request: PecaSaveRequest): PecaResponse {

        return pecaService.save(request)
    }

    override suspend fun pecaUpdate(request: PecaUpdateRequest): PecaResponse {

        return pecaService.save(request)
    }
}