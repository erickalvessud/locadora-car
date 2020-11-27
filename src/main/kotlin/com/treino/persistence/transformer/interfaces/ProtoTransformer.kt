package com.treino.persistence.transformer.interfaces

interface ProtoTransformer<DOMAIN, REQUEST, RESPONSE> {

    fun toDomain(request: REQUEST): DOMAIN

    fun toResponse(domain: DOMAIN): RESPONSE

    fun toRequest(domain: DOMAIN): REQUEST
}