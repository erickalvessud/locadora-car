package com.treino.service

import com.treino.ClienteRequest
import com.treino.ClienteResponse
import com.treino.persistence.dto.ClienteDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
open class ClienteService {

    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    fun save(request: ClienteRequest): ClienteResponse {
        logger.info("Salvando clienteRequest")
        return save(request)
    }

    fun update(request: ClienteRequest): ClienteResponse {
        TODO("Not yet implemented")
    }

    fun save(dto: ClienteDto): ClienteDto {
        logger.info("Salvando clientDto")
        return save(dto)
    }

    fun update(id: Long, dto: ClienteDto): ClienteDto {
        TODO("Not yet implemented")
    }

    fun findById(id: Long): ClienteDto {
        TODO("Not yet implemented")
    }
}