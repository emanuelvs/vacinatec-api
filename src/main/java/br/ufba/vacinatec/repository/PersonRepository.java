package br.ufba.vacinatec.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.vacinatec.entity.Person;

public interface PersonRepository extends JpaRepository<Person, String> {

    Optional<Person> findByEmail(String email);
}
