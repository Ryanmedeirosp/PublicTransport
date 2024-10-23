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

   public void createTransport(
    Integer busNumber, String driverName, String departureTime, String arrivalTime, BigDecimal ticketPrice,
    Integer passengerCount, Integer busCapacity, String startLocation, String endLocation, String busCompany,
    String busType, Integer delayMinutes, Boolean wifiAvaliable, String busColor
    ){

    Transport transport = new Transport();
    transport.setBusNumber(busNumber);
    transport.setDriverName(driverName);
    transport.setDepartureTime(departureTime);
    transport.setArrivalTime(arrivalTime);
    transport.setTicketPrice(ticketPrice);
    transport.setPassengerCount(passengerCount);
    transport.setBusCapacity(busCapacity);
    transport.setStartLocation(startLocation);
    transport.setEndLocation(endLocation);
    transport.setBusCompany(busCompany);
    transport.setBusType(busType);
    transport.setDelayMinutes(delayMinutes);
    transport.setWifiAvaliable(wifiAvaliable);
    transport.setBusColor(busColor);
    transportRepository.save(transport);

   }

   public void deleteTransport(Integer id){
    transportRepository.deleteById(id);
   }

   public void updateTransportByBusNumber(Integer busNumber, TransportUpdateDto request){
    Transport transport = transportRepository.findByBusNumber(busNumber).orElseThrow(()  -> new RuntimeException("Transport not found"));

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
   

}
