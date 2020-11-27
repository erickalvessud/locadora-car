package com.treino.rest

import com.treino.persistence.dto.PecaDto
import com.treino.service.PecaService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.tracing.annotation.ContinueSpan
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@Controller("/pecas")
open class PecaController(val pecaService: PecaService) {

    /**
     * Non-Blocking
     * */
    @Get("/no-blocking")
    @Produces(MediaType.APPLICATION_JSON)
    @ContinueSpan
    open fun list(): Flowable<List<PecaDto>>? {

        return Flowable.just(pecaService.findAll())
    }

    /**
     * Blocking
     * */
    @Get("/blocking")
    @Produces(MediaType.APPLICATION_JSON)
    fun listBlocking(): HttpResponse<List<PecaDto>>? {

        return HttpResponse.ok(pecaService.findAll())
    }

    /**
     * Non-Blocking
     * */
    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun get(@PathVariable("id") id: Long): Single<PecaDto>? {

        return Single.just(pecaService.findById(id)).delay(10, TimeUnit.SECONDS, Schedulers.io())
    }

    /**
     * Non-Blocking
     * */
    @Post("/")
    @Produces(MediaType.APPLICATION_JSON)
    fun create(@Body dto: PecaDto): Single<PecaDto> {

        return Single.just(pecaService.save(dto))
    }

    /**
     * Non-Blocking
     * */
    @Put("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun update(@Body dto: PecaDto, @PathVariable("id") id: Long): Single<PecaDto> {

        return Single.just(pecaService.update(id, dto))
    }
}