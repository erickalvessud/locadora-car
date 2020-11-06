package com.treino.persistence.entities

import javax.persistence.*

@Entity
@Table(name = "acessorio")
class AcessorioEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,

        @Column(length = 255, nullable = false)
        var descricao: String
) {
}