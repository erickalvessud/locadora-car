package com.treino.grpc.endpoint

import com.treino.*
import com.treino.service.UserService
import javax.inject.Singleton

@Singleton
class UserEndpoint(private val userService : UserService) : UserServiceGrpcKt.UserServiceCoroutineImplBase() {

    override suspend fun salvaUser(request: SalvaUserRequest): UserReply {
        return userService.salvaUser(request)
    }
}