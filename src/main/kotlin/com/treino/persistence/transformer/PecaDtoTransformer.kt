package com.treino.persistence.transformer

import com.treino.persistence.dto.PecaDto
import com.treino.persistence.entities.PecaEntity
import com.treino.persistence.transformer.interfaces.DtoTransformer
import org.modelmapper.ModelMapper
import java.util.*
import javax.inject.Singleton

@Singleton
class PecaDtoTransformer(private var modelMapper: ModelMapper) : DtoTransformer<PecaEntity, PecaDto> {

    override fun toDto(entity: Optional<PecaEntity>): PecaDto {

        return toDto(entity.get())
    }

    override fun toDto(entity: PecaEntity): PecaDto {

        return modelMapper.map(entity, PecaDto::class.java)
    }

    override fun toDomain(dto: PecaDto): PecaEntity {

        return modelMapper.map(dto, PecaEntity::class.java)
    }
}