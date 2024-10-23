package com.example.public_transport.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "public_transport_data")
@Data
@NoArgsConstructor
public class Transport {

    @Column(name = "route_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "bus_number")
    private Integer busNumber;

    @Column(name = "driver_name", length = 50)
    private String driverName;

    @Column(name = "departure_time", length = 50)
    private String departureTime;

    @Column(name = "arrival_time", length = 50)
    private String arrivalTime;

    @Column(name = "ticket_price", precision = 5, scale = 2)
    private BigDecimal ticketPrice;

    @Column(name = "passenger_count")
    private Integer passengerCount;

    @Column(name = "bus_capacity")
    private Integer busCapacity;

    @Column(name = "start_location", length = 50)
    private String startLocation;

    @Column(name = "end_location", length = 50)
    private String endLocation;

    @Column(name = "bus_company", length = 50)
    private String busCompany;

    @Column(name = "bus_type", length = 13)
    private String busType;

    @Column(name = "delay_minutes")
    private Integer delayMinutes;

    @Column(name = "wifi_available")
    private Boolean wifiAvaliable;

    @Column(name = "bus_color", length = 50)
    private String busColor;

    public Transport(Integer busNumber, String driverName, String departureTime, String arrivalTime, BigDecimal ticketPrice,
            Integer passengerCount, Integer busCapacity, String startLocation, String endLocation, String busCompany,
            String busType, Integer delayMinutes, Boolean wifiAvaliable, String busColor) {
        this.busNumber = busNumber;
        this.driverName = driverName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.ticketPrice = ticketPrice;
        this.passengerCount = passengerCount;
        this.busCapacity = busCapacity;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.busCompany = busCompany;
        this.busType = busType;
        this.delayMinutes = delayMinutes;
        this.wifiAvaliable = wifiAvaliable;
        this.busColor = busColor;
    }

    

}

// bus_number INT,
// 	driver_name VARCHAR(50),
// 	departure_time VARCHAR(50),
// 	arrival_time VARCHAR(50),
// 	ticket_price DECIMAL(5,2),
// 	passenger_count INT,
// 	bus_capacity INT,
// 	start_location VARCHAR(50),
// 	end_location VARCHAR(50),
// 	bus_company VARCHAR(50),
// 	bus_type VARCHAR(13),
// 	delay_minutes INT,
// 	wifi_available VARCHAR(50),
// 	bus_color VARCHAR(50)