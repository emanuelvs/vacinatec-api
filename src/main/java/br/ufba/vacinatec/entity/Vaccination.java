package br.ufba.vacinatec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Builder()
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccination {
    
    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private UUID vaccineId;

    @Column
    private String sideEffects;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String location;

    public Vaccination(UUID vaccineId, LocalDate date, String location){
        this.vaccineId = vaccineId;
        this.date = date;
        this.location = location;
        this.id = UUID.randomUUID();
    }
}
