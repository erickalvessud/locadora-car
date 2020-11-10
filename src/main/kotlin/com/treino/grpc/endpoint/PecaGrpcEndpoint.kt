package com.treino.grpc.endpoint

import com.treino.*
import com.treino.service.PecaService
import javax.inject.Singleton

@Singleton
class PecaGrpcEndpoint(private val pecaService: PecaService) : PecaServiceGrpcKt.PecaServiceCoroutineImplBase() {

    override suspend fun pecaSave(request: PecaSaveRequest): PecaResponse {

        return pecaService.save(request)
    }

    override suspend fun pecaUpdate(request: PecaUpdateRequest): PecaResponse {

        return pecaService.save(request)
    }
}