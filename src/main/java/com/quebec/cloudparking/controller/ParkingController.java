package com.quebec.cloudparking.controller;

import com.quebec.cloudparking.controller.dto.ParkingCreateDTO;
import com.quebec.cloudparking.controller.dto.ParkingDTO;
import com.quebec.cloudparking.controller.mapper.ParkingMapper;
import com.quebec.cloudparking.model.Parking;
import com.quebec.cloudparking.service.ParkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public
class ParkingController {

    private final
    ParkingService parkingService;

    private final
    ParkingMapper parkingMapper;

    public ParkingController (ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }


    @GetMapping
    @ApiOperation("Find all cars in the parking")
    public
    ResponseEntity<List<ParkingDTO>> findAll() {
       List<Parking> parkingList = parkingService.findAll();
       List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
       return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find only one car in the parking")
    public
    ResponseEntity<ParkingDTO> findByIdl(@PathVariable String id) {
        Parking parking = parkingService.findById(id);

        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deleting one resource car from the parking")
    public
    ResponseEntity delete(@PathVariable String id) {
        parkingService.delete(id);
        return ResponseEntity.noContent().build;
    }

    @PostMapping
    @ApiOperation("Register one single car at a time in the parking")
    public
    ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto) {
        var parkingCreate = parkingMapper.toParkingCreate(dto);
        var parking = parkingService.create(parkingCreate);
        var result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{id}")
    @ApiOperation("Register one single car at a time in the parking")
    public
    ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO dto) {
        Parking parkingUpdate = parkingMapper.toParkingCreate(dto);
        Parking parking = parkingService.update(id, parkingUpdate);
        return ResponseEntity.ok(parkingMapper.toParkingDTO(parking));
    }
}
