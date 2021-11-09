package br.ufba.vacinatec.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufba.vacinatec.entity.Person;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}
