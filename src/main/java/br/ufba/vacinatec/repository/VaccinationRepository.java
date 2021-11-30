package br.ufba.vacinatec.repository;

import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufba.vacinatec.entity.Vaccination;
import br.ufba.vacinatec.entity.Person;

public interface VaccinationRepository extends JpaRepository<Vaccination, String>{
    List<Vaccination> findByPersonId(String personId);
}
