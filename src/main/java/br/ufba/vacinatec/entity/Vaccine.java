package br.ufba.vacinatec.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.UUID;

@Builder
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vaccine {
    
    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String laboratory;

    @Column
    private Long price;

    public Vaccine(String name, String laboratory, Long price) {
        this.name = name;
        this.laboratory = laboratory;
        this.price = price;
        this.id = UUID.randomUUID();
    }
}
