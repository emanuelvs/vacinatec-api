package br.ufba.vacinatec.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class AuthDTO {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;
}
