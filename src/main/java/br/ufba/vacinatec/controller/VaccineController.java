package br.ufba.vacinatec.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufba.vacinatec.dto.request.VaccineDTO;
import br.ufba.vacinatec.service.VaccineService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/vaccine")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VaccineController {
    
    private VaccineService vService;

    @PostMapping
    public ResponseEntity<String> createVaccine(@RequestBody @Valid VaccineDTO vaccineDTO) {

        String id = vService.createVaccine(vaccineDTO);

        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VaccineDTO>> listAll() {
        List<VaccineDTO> vList = vService.listAll();

        return new ResponseEntity<>(vList,HttpStatus.OK);
    }
}
