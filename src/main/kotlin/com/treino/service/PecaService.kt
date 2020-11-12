package com.treino.service

import com.treino.PecaRequest
import com.treino.PecaResponse
import com.treino.persistence.dto.PecaDto
import com.treino.persistence.entities.PecaEntity
import com.treino.persistence.repositories.PecaRepository
import com.treino.persistence.transformer.PecaDtoTransformer
import com.treino.persistence.transformer.PecaProtoTransformer
import javax.inject.Singleton
import javax.transaction.Transactional
import kotlin.streams.toList

@Singleton
open class PecaService(
        private var pecaDtoTransformer: PecaDtoTransformer,
        private var pecaProtoTransformer: PecaProtoTransformer,
        private var pecaRepository: PecaRepository
) {

    @Transactional
    open fun save(request: PecaRequest): PecaResponse {

        val pecaEntity: PecaEntity = pecaRepository.saveAndFlush(pecaProtoTransformer.toDomain(request))

        return pecaProtoTransformer.toResponse(pecaEntity)
    }

    @Transactional
    open fun save(dto: PecaDto): PecaDto {
        val entity: PecaEntity = pecaRepository.save(pecaDtoTransformer.toDomain(dto))

        return pecaDtoTransformer.toDto(entity)
    }

    fun findAll(): List<PecaDto>? {

        return pecaRepository.findAll()
                .stream()
                .map { peca -> pecaDtoTransformer.toDto(peca) }
                .toList()
    }

}