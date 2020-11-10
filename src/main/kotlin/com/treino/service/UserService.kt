package com.treino.service

import com.treino.*
import com.treino.persistence.entities.CarroEntity
import com.treino.persistence.entities.UsuarioEntity
import javax.inject.Singleton
import com.treino.persistence.repositories.UserRepository
import io.micronaut.data.model.Pageable

@Singleton
class UserService( private val userRepository : UserRepository) {

    fun consultaTodosUsers(request: ConsultaTodosUsersRequest): ConsultaTodosUsersResponse? {
        val users = this.userRepository.findAll(Pageable.from(request.page, request.size))
        val responseBuilder = ConsultaTodosUsersResponse.newBuilder()
        users.forEach { c ->
            responseBuilder
                    .addUsers(
                            UserReply.newBuilder()
                                    .setId(c.id!!)
                                    .setNome(c.nome!!)
                                    .setIdade(c.idade)
                                    .setGenero(c.genero)
                                    .build()
                    )
        }

        responseBuilder.pageInfoBuilder
                .setTotalPaginas(users.totalPages.toLong())
                .setPaginaAtual(users.pageNumber.toLong())
                .setTamanhoTotal(users.totalSize)
                .build()

        return responseBuilder.build()
    }

    fun salvaUser(request: SalvaUserRequest): UserReply {
        val userSalvo = this.userRepository.save(UsuarioEntity(
                null,
                nome = request.nome!!,
                idade = request.idade,
                genero = request.genero!!,
        ))

        return UserReply.newBuilder()
                .setId(userSalvo.id!!)
                .setNome(userSalvo.nome!!)
                .setIdade(userSalvo.idade)
                .setGenero(userSalvo.genero!!)
                .build();
    }
}