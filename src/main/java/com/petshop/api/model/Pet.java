package com.petshop.api.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.petshop.api.constants.Especie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_pets")

public class Pet { 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPet;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Especie especie;

    @Column(nullable = false, length = 50 )
    private String raca;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;

    @ManyToOne()
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    
}
