package com.api.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.model.Cliente;
import com.api.model.Habitacion;
import com.api.model.Hotel;
import com.api.persistence.entities.HotelEntity;
@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer>{

}
