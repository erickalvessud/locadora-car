package com.treino.persistence.entities

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "pecas")
class PecaEntity(
        @Column(name = "descricao", length = 100)
        var descricao: String?,

        @Column(name = "valor")
        var valor: Double
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @CreationTimestamp
    @Column(name = "created_at")
    lateinit var createdAt: LocalDateTime

    @UpdateTimestamp
    @Column(name = "updated_at")
    lateinit var updatedAt: LocalDateTime
}