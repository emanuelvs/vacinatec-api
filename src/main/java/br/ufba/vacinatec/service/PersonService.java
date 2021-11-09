package br.ufba.vacinatec.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufba.vacinatec.dto.request.PersonDTO;
import br.ufba.vacinatec.dto.response.MessageResponseDTO;
import br.ufba.vacinatec.entity.Person;
import br.ufba.vacinatec.exception.PersonNotFoundException;
import br.ufba.vacinatec.mapper.PersonMapper;
import br.ufba.vacinatec.repository.PersonRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;


    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = PersonMapper.INSTANCE.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        PersonDTO person = PersonMapper.INSTANCE.toDTO(savedPerson);
        return createMessageResponse(person.getId(), "Created person with ID ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(PersonMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(String id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        return PersonMapper.INSTANCE.toDTO(person);
    }

    public void delete(String id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(UUID.fromString(id));
    }

    public MessageResponseDTO updateById(String id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = PersonMapper.INSTANCE.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);
        PersonDTO person = PersonMapper.INSTANCE.toDTO(updatedPerson);
        return createMessageResponse(person.getId(), "Updated person with ID ");
    }

    private Person verifyIfExists(String id) throws PersonNotFoundException {
        UUID personId = UUID.fromString(id);
        return personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoundException(personId));
    }

    private MessageResponseDTO createMessageResponse(String id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
