package com.treino.persistence.transformer

interface DtoTransformer<ENTITY, DTO> {

    fun toDto(entity: ENTITY): DTO

    fun toDomain(dto: DTO): ENTITY
}