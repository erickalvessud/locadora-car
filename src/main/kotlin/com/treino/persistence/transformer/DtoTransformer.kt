package com.treino.persistence.transformer

interface DtoTransformer<E, D> {

    fun toDto(entity: E): D

    fun toDomain(dto: D): E
}