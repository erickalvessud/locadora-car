package com.treino.extensionfunc

import io.grpc.Status
import io.grpc.StatusException
import io.micronaut.validation.validator.Validator

/**
 * Funcao extendida para a interface io.micronaut.validation.validator.Validator
 */

fun <T> Validator.validateConstraintViolation(obj: T){
    val validate = this.validate(obj)

    if (!validate.isEmpty()){
        var message = StringBuilder()
        validate
            .forEach{ constraintViolation ->
                if ( !message.isEmpty() ){
                    message.append(", ")
                }
                message.append(constraintViolation.propertyPath.toString() + " " + constraintViolation.message)
            }
        throw StatusException(Status.INVALID_ARGUMENT.withDescription(message.toString()))
    }
}