package com.example.public_transport.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.public_transport.dto.TransportUpdateDto;
import com.example.public_transport.model.Transport;
import com.example.public_transport.service.TransportService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/publicTransport")
@RequiredArgsConstructor
public class TransportController {
    
    private final TransportService transportService;

    //http://localhost:8080/publicTransport?type={BUSTYPE}&offset={OFFSET}&limit={LIMIT}
    @GetMapping()
    public Page<Transport> getAllTransportsByType(

        @RequestParam("type")String type, 
        @RequestParam(name="page", defaultValue="0")Integer offset, 
        @RequestParam(name="limit", defaultValue = "10")Integer limit
    ) {

        return transportService.getTransportByType(type, limit, offset);
    }

    //http://localhost:8080/publicTransport/create
    @PostMapping("/create")
    public void createTransport(@RequestBody Transport transport){
        System.out.println(transport.getBusCompany());
        transportService.createTransport(transport);
    }

    //http://localhost:8080/publicTransport/update/{ID}
    @PutMapping("/update/{id}")
    public void updateTransportById(@PathVariable Integer id, @RequestBody TransportUpdateDto request){

        transportService.updateTransportByBusNumber(id, request);
    }

    //http://localhost:8080/publicTransport/delete/{ID}
    @DeleteMapping("/delete/{id}")
    public void deleteTransportById(@PathVariable Integer id){
        transportService.deleteTransport(id);
    }

}
