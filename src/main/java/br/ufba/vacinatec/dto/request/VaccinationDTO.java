package br.ufba.vacinatec.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationDTO {

    private String id;

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 100)
    private String vaccineId;

    private String sideEffects;

    @NotEmpty
    @NotNull
    private String date;

    
    private String location;
}
