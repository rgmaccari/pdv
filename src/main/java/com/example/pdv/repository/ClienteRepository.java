package com.example.pdv.repository;

import com.example.pdv.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    //IgnoreCase faz com que não leve em consideração letras maiusculas ou minusculas.
    public List<Cliente> findAllByNomeContainingIgnoreCaseOrderByNome(String nome);
}
