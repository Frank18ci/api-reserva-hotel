package com.api.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.model.Cliente;
import com.api.persistence.entities.ClienteEntity;
@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{

}
