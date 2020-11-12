package com.treino.rest

import com.treino.persistence.dto.PecaDto
import com.treino.service.PecaService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import javax.inject.Inject

@Controller("/pecas")
class PecaController {

    @Inject
    lateinit var pecaService: PecaService

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/")
    fun list(): MutableHttpResponse<List<PecaDto>>? {

        return HttpResponse.ok(pecaService.findAll())
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Post("/")
    fun create(@Body dto: PecaDto): HttpResponse<PecaDto> {

        return HttpResponse.ok(pecaService.save(dto))
    }
}