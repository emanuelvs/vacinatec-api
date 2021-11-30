package br.ufba.vacinatec.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtResponseDTO implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwtToken;
}
