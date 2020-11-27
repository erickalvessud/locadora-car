package com.treino.service

import com.treino.PecaRequest
import com.treino.PecaResponse
import com.treino.persistence.dto.PecaDto
import com.treino.persistence.entities.PecaEntity
import com.treino.persistence.repositories.PecaRepository
import com.treino.persistence.transformer.PecaDtoTransformer
import com.treino.persistence.transformer.PecaProtoTransformer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton
import javax.transaction.Transactional
import kotlin.streams.toList

@Singleton
open class PecaService(
        private var pecaDtoTransformer: PecaDtoTransformer,
        private var pecaProtoTransformer: PecaProtoTransformer,
        private var pecaRepository: PecaRepository
) {

    val logger: Logger = LoggerFactory.getLogger("splunk")

    @Transactional
    open fun save(request: PecaRequest): PecaResponse {
        val pecaEntity: PecaEntity = pecaRepository.saveAndFlush(pecaProtoTransformer.toDomain(request))

        return pecaProtoTransformer.toResponse(pecaEntity)
    }

    @Transactional
    open fun save(dto: PecaDto): PecaDto {
        val entity: PecaEntity = pecaRepository.saveAndFlush(pecaDtoTransformer.toDomain(dto))

        return pecaDtoTransformer.toDto(entity)
    }

    @Transactional
    open fun update(id: Long, dto: PecaDto): PecaDto {

        val entity = pecaRepository.findById(id).get()
        entity.descricao = dto.descricao
        entity.valor = dto.valor

        return pecaDtoTransformer.toDto(pecaRepository.saveAndFlush(entity))
    }

    fun findById(id: Long): PecaDto {

        return pecaDtoTransformer.toDto(pecaRepository.findById(id).orElseThrow())
    }

    fun findAll(): List<PecaDto>? {
        logger.info("FindAll PecaDTO")
        return pecaRepository.findAll()
                .stream()
                .map { peca -> pecaDtoTransformer.toDto(peca) }
                .toList()
    }

}