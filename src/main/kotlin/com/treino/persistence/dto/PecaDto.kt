package com.treino.persistence.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
class PecaDto(

        @JsonProperty("id")
        var id: Long?,
        @JsonProperty("descricao")
        var descricao: String?,
        @JsonProperty("valor")
        var valor: Double,
        @JsonProperty("createdAt")
        var createdAt: LocalDateTime?,
        @JsonProperty("updatedAt")
        var updatedAt: LocalDateTime?
) {
    constructor(descricao: String?, valor: Double) : this(null, null, 0.0, null, null)
}