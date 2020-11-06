package com.treino.persistence.repositories

import com.treino.persistence.entities.CarroEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.PageableRepository

@Repository
interface CarroRepository : PageableRepository<CarroEntity, Long> {
}