package com.example.public_transport.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.public_transport.model.Transport;
import com.example.public_transport.service.TransportService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/publicTransport")
@RequiredArgsConstructor
public class TransportController {
    
    private final TransportService transportService;

    //http://localhost:8080/publicTransport?type=Mini Bus&offset=1&limit=2
    @GetMapping()
    public Page<Transport> getAllTransportsByType(

        @RequestParam("type")String type, 
        @RequestParam(name="page", defaultValue="0")Integer offset, 
        @RequestParam(name="limit", defaultValue = "10")Integer limit
    ) {

        return transportService.getTransportByType(type, limit, offset);
    }
}
