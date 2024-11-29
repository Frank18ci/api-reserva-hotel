package com.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.model.Cliente;
import com.api.model.Habitacion;
import com.api.persistence.entities.HabitacionEntity;
@Repository
public interface HabitacionRepository extends JpaRepository<HabitacionEntity, Integer>{

}
