package com.treino.service

import com.treino.CarroReply
import com.treino.ConsultaTodosRequest
import com.treino.ConsultaTodosResponse
import com.treino.grpc.endpoint.CarroRequest
import com.treino.persistence.entities.CarroEntity
import com.treino.persistence.repositories.CarroRepository
import io.micronaut.data.model.Pageable
import javax.inject.Singleton

@Singleton
class CarroService (private val carroRepository: CarroRepository){

    fun consultaTotos(request: ConsultaTodosRequest): ConsultaTodosResponse? {
        val carros = this.carroRepository.findAll(Pageable.from(request.page, request.size))
        val responseBuilder = ConsultaTodosResponse.newBuilder()
        carros.forEach { c ->
            responseBuilder
                    .addCarros(
                            CarroReply.newBuilder()
                            .setId(c.id!!)
                            .setModelo(c.modelo)
                            .setCor(c.cor)
                            .setMarca(c.marca)
                            .setPlaca(c.placa)
                            .setValorDiaria(c.valorDiaria)
                            .build()
                    )
        }

        responseBuilder.pageInfoBuilder
                .setTotalPaginas(carros.totalPages.toLong())
                .setPaginaAtual(carros.pageNumber.toLong())
                .setTamanhoTotal(carros.totalSize)
                .build()

        return responseBuilder.build()
    }

    fun salvaCarro(request: CarroRequest): CarroReply {
        val carroSalvo = this.carroRepository.save(CarroEntity(
                null,
                modelo = request.modelo,
                cor = request.cor,
                marca = request.marca,
                placa = request.placa,
                valorDiaria = request.valorDiaria
        ))

        return CarroReply.newBuilder()
                .setId(carroSalvo.id!!)
                .setModelo(carroSalvo.modelo)
                .setCor(carroSalvo.cor)
                .setMarca(carroSalvo.marca)
                .setPlaca(carroSalvo.placa)
                .setValorDiaria(carroSalvo.valorDiaria)
                .build();
    }
}