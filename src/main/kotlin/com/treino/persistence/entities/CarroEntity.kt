package com.treino.persistence.entities

import javax.persistence.*

@Entity
@Table(name = "carro")
class CarroEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,

        @Column(length = 255, nullable = false)
        var modelo: String,

        @Column(length = 255, nullable = false)
        var cor: String,

        @Column(length = 255, nullable = false)
        var marca: String,

        @Column(length = 255, nullable = false)
        var placa: String,

        var valorDiaria: Double,

        @ManyToMany
        @JoinTable(
                name = "carro_acessorio",
                joinColumns = arrayOf(JoinColumn(name = "carro_id", referencedColumnName = "id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "acessorio_id", referencedColumnName = "id"))
        )
        var acessorios: List<AcessorioEntity> = mutableListOf<AcessorioEntity>()
) {
    constructor(): this(null, "", "", "", "", 99999.0)
}