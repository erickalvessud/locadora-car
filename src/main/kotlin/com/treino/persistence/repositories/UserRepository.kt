package com.treino.persistence.repositories

import com.treino.persistence.entities.CarroEntity
import com.treino.persistence.entities.UsuarioEntity
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.PageableRepository

@Repository
interface UserRepository : PageableRepository<UsuarioEntity, Long> {
}