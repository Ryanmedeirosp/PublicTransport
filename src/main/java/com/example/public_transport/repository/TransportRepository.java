package com.example.public_transport.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.public_transport.model.Transport;

@Repository
public interface TransportRepository extends JpaRepository<Transport,Integer>{
    
    @Query("SELECT p FROM Transport p WHERE p.busType=:type")
    Page<Transport> getTransportByType(@Param("type") String type, Pageable pageable);
    
    Optional<Transport>  findByBusNumber(Integer busNumber);

}
