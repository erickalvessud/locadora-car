package com.treino.persistence.entities

import javax.persistence.*

@Entity
@Table(name="user")
class UsuarioEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,

        @Column(length = 100, nullable = false)
        var nome: String,

        @Column(nullable = false)
        var idade: Long,

        @Column(length = 50, nullable = false)
        var genero: String,

){
        constructor() : this(null,"",1,"")
}