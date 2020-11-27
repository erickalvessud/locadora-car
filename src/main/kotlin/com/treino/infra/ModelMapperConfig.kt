package com.treino.infra

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import org.modelmapper.Conditions
import org.modelmapper.ModelMapper

@Factory
open class ModelMapperConfig {

    @Bean
    open fun modelMapper(): ModelMapper {

        val modelMapperImpl = ModelMapper()
        modelMapperImpl.configuration.propertyCondition = Conditions.isNotNull()

        return modelMapperImpl
    }

}