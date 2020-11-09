package com.treino.persistence.repositories

import com.treino.persistence.entities.PecaEntity
import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface PecaRepository : JpaRepository<PecaEntity, Long> {

    @Executable
    fun findByDescricaoContains(descricao: String): Set<PecaEntity>
}