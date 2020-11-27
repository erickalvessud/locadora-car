package com.treino.persistence.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class ClienteDto(

        @JsonProperty("id")
        var id: Long?,
        @JsonProperty("nome")
        var nome: String
) {
    constructor(nome: String) : this(null, nome)
}