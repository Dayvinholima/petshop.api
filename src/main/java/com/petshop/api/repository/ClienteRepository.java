package com.petshop.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petshop.api.model.Cliente;
import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    Optional<Cliente> findByEmail(String email);
    Optional<List<Cliente>> findByNome(String nome);
    
}
