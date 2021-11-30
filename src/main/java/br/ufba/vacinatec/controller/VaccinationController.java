package br.ufba.vacinatec.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufba.vacinatec.dto.request.VaccinationDTO;
import br.ufba.vacinatec.service.VaccinationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/vaccination")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VaccinationController {
    
    private VaccinationService vService;

    @PostMapping
    public ResponseEntity<String> createVaccination(@RequestBody VaccinationDTO vaccinationDTO) {
        String id = vService.createVaccination(vaccinationDTO);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<List<VaccinationDTO>> fetchByPerson(@PathVariable String personId) {
        List<VaccinationDTO> list = vService.listByPerson(personId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VaccinationDTO>> listAll() {
        List<VaccinationDTO> vList = vService.listAll();
        return new ResponseEntity<>(vList, HttpStatus.OK);
    }
}
