package br.ufba.vacinatec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufba.vacinatec.dto.request.VaccineDTO;
import br.ufba.vacinatec.entity.Vaccine;
import br.ufba.vacinatec.mapper.VaccineMapper;
import br.ufba.vacinatec.repository.VaccineRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VaccineService {
    
    private VaccineRepository vaccineRepo;

    public String createVaccine(VaccineDTO vaccineDTO) {
        Vaccine vaccineToSave = VaccineMapper.INSTANCE.toModel(vaccineDTO);
        Vaccine savedVaccine =  vaccineRepo.save(vaccineToSave);
        return  VaccineMapper.INSTANCE.toDTO(savedVaccine).getId();
    }

    public List<VaccineDTO> listAll() {
        List<Vaccine> allVaccines = vaccineRepo.findAll();

        return allVaccines.stream()
                .map(VaccineMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }


}
