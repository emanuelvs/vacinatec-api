package br.ufba.vacinatec.mapper;

import br.ufba.vacinatec.dto.request.VaccinationDTO;
import br.ufba.vacinatec.dto.response.VaccinationResponseDTO;
import br.ufba.vacinatec.entity.Vaccination;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface VaccinationMapper {

    VaccinationMapper INSTANCE = Mappers.getMapper(VaccinationMapper.class);

    @Mapping(target = "date", source = "date", dateFormat = "dd-MM-yyyy")
    Vaccination toModel(VaccinationDTO vaccinationDTO);

    @Mapping(target = "personId", source = "person.id")
    VaccinationResponseDTO toDTO(Vaccination vaccination);
}
