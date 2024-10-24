package com.example.public_transport.service;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.public_transport.dto.TransportUpdateDto;
import com.example.public_transport.model.Transport;
import com.example.public_transport.repository.TransportRepository;

@Service
public class TransportService {
    
    private final TransportRepository transportRepository;

    public TransportService(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

   public Page<Transport> getTransportByType(String type, Integer limit, Integer  offset){
    Pageable  pageable = PageRequest.of(offset, limit);
    return transportRepository.getTransportByType(type, pageable);
   }

   public void createTransport(Transport request){

    if(verification(request)){

        transportRepository.save(request);
    }

   }

   public void deleteTransport(Integer id){
    transportRepository.deleteById(id);
   }

   public void updateTransportByBusNumber(Integer id, TransportUpdateDto request){
    Transport transport = transportRepository.findById(id).orElseThrow(()  -> new RuntimeException("Transport not found"));

    if( request.getDriverName() == null ||  request.getDriverName().isBlank()){
        throw new  RuntimeException("Driver name is required");

    }

    if( request.getPassengerCount() == null ||  request.getPassengerCount() < 0|| request.getPassengerCount() > transport.getBusCapacity()){
        throw new  RuntimeException("can't  update passenger count");
    }

    if( request.getTicketPrice() == null || request.getTicketPrice().compareTo(BigDecimal.ZERO)==0){
        throw new   RuntimeException("Ticket price is required");

    }
    
    transport.setDriverName(request.getDriverName());
    transport.setPassengerCount(request.getPassengerCount());
    transport.setTicketPrice(request.getTicketPrice());
    transportRepository.save(transport);
   }

   public boolean verification(Transport request){
    
        if(request.getBusNumber() == null) throw new IllegalArgumentException("a");
        if(request.getDriverName() == null) throw new IllegalArgumentException("b");
        if(request.getDepartureTime() == null) throw new IllegalArgumentException("c");
        if(request.getArrivalTime() == null) throw new IllegalArgumentException("d");
        if(request.getTicketPrice() == null || request.getTicketPrice().compareTo(BigDecimal.ZERO) == 0) throw new IllegalArgumentException("e");
        if(request.getPassengerCount() == null || request.getPassengerCount() < 0) throw new IllegalArgumentException("f");
        if(request.getBusCapacity() == null || request.getBusCapacity() < 0) throw new IllegalArgumentException("g");
        if(request.getStartLocation() == null) throw new IllegalArgumentException("h");
        if(request.getEndLocation() == null) throw new IllegalArgumentException("i");
        if(request.getBusCompany() == null) throw new IllegalArgumentException("j");
        if(request.getBusType() == null) throw new IllegalArgumentException("k");
        if(request.getDelayMinutes() == null || request.getDelayMinutes() < 0) throw new IllegalArgumentException("l");
        if(request.getWifiAvaliable() == null) throw new IllegalArgumentException("m");
        if(request.getBusColor() == null) throw new IllegalArgumentException("n");

        return true;
   }
}
