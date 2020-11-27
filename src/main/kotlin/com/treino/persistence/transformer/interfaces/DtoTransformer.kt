package com.treino.persistence.transformer.interfaces

import java.util.*

interface DtoTransformer<ENTITY, DTO> {

    fun toDto(entity: Optional<ENTITY>): DTO

    fun toDto(entity: ENTITY): DTO

    fun toDomain(dto: DTO): ENTITY
}