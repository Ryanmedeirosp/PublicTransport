package com.example.public_transport.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransportUpdateDto {

    private String driverName;
    private BigDecimal ticketPrice;
    private Integer passengerCount;

    public TransportUpdateDto(String driverName, BigDecimal ticketPrice, Integer passengerCount) {
        this.driverName = driverName;
        this.ticketPrice = ticketPrice;
        this.passengerCount = passengerCount;
    }

    
}
