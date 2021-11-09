package br.ufba.vacinatec.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufba.vacinatec.dto.request.VaccinationDTO;
import br.ufba.vacinatec.entity.Vaccination;
import br.ufba.vacinatec.mapper.VaccinationMapper;
import br.ufba.vacinatec.repository.VaccinationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VaccinationService {
    
    private VaccinationRepository vaccinationRepo;


    public String createVaccination(VaccinationDTO vaccinationDTO) {
        Vaccination vaccinationToSave = VaccinationMapper.INSTANCE.toModel(vaccinationDTO);
        Vaccination vaccinationSaved = vaccinationRepo.save(vaccinationToSave);
        return VaccinationMapper.INSTANCE.toDTO(vaccinationSaved).getId();
    }

    public List<VaccinationDTO> listAll() {
        List<Vaccination> allVaccinations = vaccinationRepo.findAll();
        return allVaccinations.stream()
                .map(VaccinationMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public List<VaccinationDTO> listByPerson(String personId) {
        List<Vaccination> vaccinations = vaccinationRepo.findByPersonId(UUID.fromString(personId));
        return vaccinations.stream()
                .map(VaccinationMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

}
