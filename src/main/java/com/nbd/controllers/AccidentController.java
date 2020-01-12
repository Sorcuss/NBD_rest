package com.nbd.controllers;

import com.nbd.models.Accident;
import com.nbd.repositories.AccidentRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class AccidentController {

    @Autowired
    AccidentRepository accidentRepository;

    @GetMapping(value = "/accidents", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all accidents")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK")
    })
    public List<Accident> getAllAccidents(){
        return accidentRepository.findAll();
    }

    @ApiOperation(value = "Create accident")
    @PostMapping(value = "/accident" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad request")
    })
    public ResponseEntity<Void> addAccidents(@RequestBody Accident accident) {
        accidentRepository.save(accident);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }



    @ApiOperation(value = "Get accident")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @GetMapping(value = "/accident/{id}")
    @ResponseBody
    public ResponseEntity<Accident> getAccident(@PathVariable String id){
        Optional<Accident> accident = accidentRepository.findById(id);
        return accident.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @ApiOperation(value = "Delete accident")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "no content"),
            @ApiResponse(code = 404, message = "no found")
    })
    @DeleteMapping(value = "/accident/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public ResponseEntity<Void> deleteAccident(@PathVariable String id){
        boolean existFlag = accidentRepository.existsById(id);
        if(existFlag){
            accidentRepository.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }


    @ApiOperation(value = "Update accident")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "created"),
            @ApiResponse(code = 404, message = "not found")
            })
    @PutMapping(value = "/accident/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<Void> updateAccident(@PathVariable String id, @RequestBody Accident accident){
        Optional<Accident> accidentToUpdate = accidentRepository.findById(id);
        if(accidentToUpdate.isPresent()) {
            Accident updatedAccident = accidentToUpdate.get();
            updatedAccident.setLongitude(accident.getLongitude());
            updatedAccident.setLatitude(accident.getLatitude());
            updatedAccident.setPoliceForce(accident.getPoliceForce());
            updatedAccident.setAccidentSeverity(accident.getAccidentSeverity());
            updatedAccident.setNumberOfVehicles(accident.getNumberOfVehicles());
            updatedAccident.setNumberOfCasualties(accident.getNumberOfCasualties());
            updatedAccident.setDate(accident.getDate());
            updatedAccident.setLongitude(accident.getLongitude());
            updatedAccident.setRoadType(accident.getRoadType());
            updatedAccident.setSpeedLimit(accident.getSpeedLimit());
            updatedAccident.setLightConditions(accident.getLightConditions());
            updatedAccident.setRoadSurfaceConditions(accident.getRoadSurfaceConditions());
            updatedAccident.setLocalAuthority(accident.getLocalAuthority());
            updatedAccident.setWeatherConditions(accident.getWeatherConditions());
            updatedAccident.setRoadType(accident.getRoadType());
            updatedAccident.setUrbanOrRuralArea(accident.getUrbanOrRuralArea());
            updatedAccident.setDidPoliceOfficerAttendSceneOfAccident(accident.isDidPoliceOfficerAttendSceneOfAccident());
            accidentRepository.save(updatedAccident);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}