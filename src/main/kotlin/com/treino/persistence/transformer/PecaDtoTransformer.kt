package com.treino.persistence.transformer

import com.treino.persistence.dto.PecaDto
import com.treino.persistence.entities.PecaEntity
import javax.inject.Singleton

@Singleton
class PecaDtoTransformer : DtoTransformer<PecaEntity, PecaDto> {

    override fun toDto(entity: PecaEntity): PecaDto {

        return PecaDto(entity.id, entity.descricao, entity.valor, entity.createdAt, entity.updatedAt)
    }

    override fun toDomain(dto: PecaDto): PecaEntity {

        val pecaEntity = PecaEntity()

        pecaEntity.id = dto.id
        pecaEntity.descricao = dto.descricao
        pecaEntity.valor = dto.valor

        return pecaEntity
    }
}