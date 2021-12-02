package br.ufba.vacinatec.controller;

import br.ufba.vacinatec.config.JwtTokenUtil;
import br.ufba.vacinatec.dto.request.AuthDTO;
import br.ufba.vacinatec.dto.response.JwtResponseDTO;
import br.ufba.vacinatec.entity.Person;
import br.ufba.vacinatec.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PersonService personService;

    @PostMapping("/api/v1/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthDTO authDTO) throws Exception {
        authenticate(authDTO.getEmail(), authDTO.getPassword());
        final UserDetails userDetails = personService
                .loadUserByUsername(authDTO.getEmail());

        final String jwtToken = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponseDTO(jwtToken));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID CREDENTIALS", e);
        }
    }
}
