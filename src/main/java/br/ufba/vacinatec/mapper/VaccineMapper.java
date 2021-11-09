package br.ufba.vacinatec.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.ufba.vacinatec.dto.request.VaccineDTO;
import br.ufba.vacinatec.entity.Vaccine;

@Mapper
public interface VaccineMapper {

    VaccineMapper INSTANCE = Mappers.getMapper(VaccineMapper.class);

    Vaccine toModel(VaccineDTO vaccine);

    VaccineDTO toDTO(Vaccine vaccineDTO);
}