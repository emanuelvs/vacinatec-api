package br.ufba.vacinatec.dto.response;

import br.ufba.vacinatec.entity.Vaccine;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class VaccinationResponseDTO {
        private String id;
        private Vaccine vaccine;
        private String sideEffects;
        private String personId;
        private String date;
        private String location;
}
