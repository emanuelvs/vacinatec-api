package br.ufba.vacinatec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccination {
    
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    private Vaccine vaccine;

    @ManyToOne
    private Person person;

    @Column
    private String sideEffects;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String location;

    public Vaccination(Vaccine vaccine, Person person, LocalDate date, String location){
        this.vaccine = vaccine;
        this.person = person;
        this.date = date;
        this.location = location;
        this.id = UUID.randomUUID().toString();
    }
}
