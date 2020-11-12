package com.treino.persistence.transformer

import com.treino.PecaRequest
import com.treino.PecaResponse
import com.treino.persistence.entities.PecaEntity
import javax.inject.Singleton

@Singleton
class PecaProtoTransformer : ProtoTransformer<PecaEntity, PecaRequest, PecaResponse> {

    override fun toDomain(request: PecaRequest): PecaEntity {

        return PecaEntity(request.descricao, request.valor)
    }

    override fun toResponse(domain: PecaEntity): PecaResponse {

        return PecaResponse.newBuilder()
                .setId(domain.id!!)
                .setDescricao(domain.descricao)
                .setValor(domain.valor)
                .setCreatedAt(domain.createdAt.toString())
                .setUpdatedAt(domain.updatedAt.toString())
                .build()
    }

    override fun toRequest(domain: PecaEntity): PecaRequest {

        return PecaRequest.newBuilder()
                .setId(domain.id!!)
                .setDescricao(domain.descricao)
                .setValor(domain.valor)
                .build()
    }
}