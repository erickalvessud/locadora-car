package com.treino.grpc.endpoint

import com.treino.*
import com.treino.extensionfunc.validateConstraintViolation
import com.treino.grpc.endpoint.domain.toCarroRequest
import com.treino.service.CarroService
import io.micronaut.validation.validator.Validator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CarroEndpoint(private val carroService: CarroService) : CarroServiceGrpcKt.CarroServiceCoroutineImplBase() {

    @Inject
    lateinit var validator: Validator

    @Override
    override suspend fun consultaTodos( request: ConsultaTodosRequest): ConsultaTodosResponse {

        return carroService.consultaTotos(request)!!
    }

    override suspend fun salvaCarro(request: SalvaCarroRequest): CarroReply {
        val carroRequest = request.toCarroRequest()

        validator.validateConstraintViolation(carroRequest)

        return carroService.salvaCarro(carroRequest)
    }
}

