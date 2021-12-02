package br.ufba.vacinatec.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import br.ufba.vacinatec.config.JwtTokenUtil;
import br.ufba.vacinatec.dto.response.VaccinationResponseDTO;
import br.ufba.vacinatec.entity.Vaccination;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import br.ufba.vacinatec.dto.request.VaccinationDTO;
import br.ufba.vacinatec.service.VaccinationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/vaccination")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VaccinationController {
    
    private VaccinationService vService;

    @PostMapping
    public ResponseEntity<String> createVaccination(@RequestBody VaccinationDTO vaccinationDTO, @RequestHeader("Authorization") String authorization) {
        String id = vService.createVaccination(vaccinationDTO);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VaccinationResponseDTO>> fetchByPerson(@RequestHeader("Authorization") String authorization) throws Exception {
        List<VaccinationResponseDTO> vaccinationDTOList  = vService.listByLoggedUser(authorization);
        return ResponseEntity.ok(vaccinationDTOList);
    }

    /*
    @GetMapping
    public ResponseEntity<List<Vaccination>> listAll() {
        List<Vaccination> vList = vService.listAll();
        return new ResponseEntity<>(vList, HttpStatus.OK);
    } */
}
