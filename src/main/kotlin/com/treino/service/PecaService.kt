package com.treino.service

import com.treino.PecaResponse
import com.treino.PecaSaveRequest
import com.treino.PecaUpdateRequest
import com.treino.persistence.entities.PecaEntity
import com.treino.persistence.repositories.PecaRepository
import javax.inject.Singleton

@Singleton
class PecaService(private val pecaRepository: PecaRepository) {

    fun save(request: PecaSaveRequest): PecaResponse {

        var pecaEntity = PecaEntity(request.descricao, request.valor)
        pecaEntity = pecaRepository.saveAndFlush(pecaEntity)

        return PecaResponse.newBuilder()
                .setId(pecaEntity.id!!)
                .setDescricao(pecaEntity.descricao)
                .setValor(pecaEntity.valor)
                .setCreatedAt(pecaEntity.createdAt.toString())
                .setUpdatedAt(pecaEntity.updatedAt.toString())
                .build();
    }

    fun save(request: PecaUpdateRequest): PecaResponse {

        // TODO - Implementar

        return PecaResponse.newBuilder().build();
    }
}