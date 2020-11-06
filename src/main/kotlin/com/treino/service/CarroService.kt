package com.treino.service

import com.treino.CarroReply
import com.treino.ConsultaTodosRequest
import com.treino.ConsultaTodosResponse
import com.treino.persistence.repositories.CarroRepository
import io.micronaut.data.model.Pageable
import javax.inject.Singleton

@Singleton
class CarroService (private val carroRepository: CarroRepository){

    public fun findAll(request: ConsultaTodosRequest): ConsultaTodosResponse.Builder? {
        val carros = this.carroRepository.findAll(Pageable.from(request.page, request.size))
        val responseBuilder = ConsultaTodosResponse.newBuilder()
        carros.forEach { c ->
            responseBuilder
                    .addCarros(
                            CarroReply.newBuilder()
                            .setId(c.id!!)
                            .setModelo(c.modelo)
                            .build()
                    )
        }

        return responseBuilder
    }
}