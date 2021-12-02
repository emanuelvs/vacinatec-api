package br.ufba.vacinatec.service;

import br.ufba.vacinatec.config.JwtTokenUtil;
import br.ufba.vacinatec.enums.PersonUserRole;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@AllArgsConstructor
public class PersonService implements UserDetailsService {

    private final PersonRepository personRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = PersonMapper.INSTANCE.toModel(personDTO);

        personToSave.setId(UUID.randomUUID().toString());
        personToSave.setPersonUserRole(PersonUserRole.USER);

        String passwordEncoded = bCryptPasswordEncoder.encode(personDTO.getPassword());
        personToSave.setPassword(passwordEncoded);

        Person savedPerson = personRepository.save(personToSave);
        PersonDTO person = PersonMapper.INSTANCE.toDTO(savedPerson);
        return createMessageResponse(person.getId(), "");
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
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(String id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = PersonMapper.INSTANCE.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);
        PersonDTO person = PersonMapper.INSTANCE.toDTO(updatedPerson);
        return createMessageResponse(person.getId(), "Updated person with ID ");
    }

    private Person verifyIfExists(String id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(String id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return personRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public Person loadUserByEmail(String email) throws PersonNotFoundException {
        return personRepository.findByEmail(email)
                .orElseThrow(() -> new PersonNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public Person loadUserByToken(String token) throws Exception{
        String username = null;
        String jwtToken = null;
        Person personInfo = null;

        if(token != null && token.startsWith("Bearer ")){
            jwtToken = token.substring(7);
            try {
                username = jwtTokenUtil.getUserFromToken(jwtToken);
            } catch (IllegalArgumentException e) {
                throw new Exception("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                throw new Exception("JWT Token has expired");
            }
        }
        if(username != null){
            personInfo = loadUserByEmail(username);
        }


        return personInfo;
    }
}
