package br.ufba.vacinatec.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.vacinatec.entity.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, String>{
    
}
