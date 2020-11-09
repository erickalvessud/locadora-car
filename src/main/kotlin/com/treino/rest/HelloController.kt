package com.treino.rest

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/hello")
class HelloController {

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/anonymous")
    fun anonymous(): HttpResponse<String>? {

        return HttpResponse.ok("Anonymous Access");
    }
}