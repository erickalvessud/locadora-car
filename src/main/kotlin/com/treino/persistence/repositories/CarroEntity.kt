package com.treino.persistence.repositories

import javax.persistence.*

@Entity
class CarroEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,

        @Column(length = 255, nullable = false)
        var modelo: String,

        @Column(length = 255, nullable = false)
        var marca: String
) {
    constructor(): this(null,  "", "")
}