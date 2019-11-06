package com.nbd.controllers;

import com.nbd.models.Accident;
import com.nbd.repositories.AccidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class AccidentController {

    @Autowired
    AccidentRepository accidentRepository;

    @GetMapping(value = "/accidents", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Accident> getAllAccidents(){
        return accidentRepository.findAll();
    }

    @PostMapping(value = "/accident" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addAccidents(@RequestBody Accident accident) {
        accident.setAccidentIndex(UUID.randomUUID().toString());
        Accident addedAccident = accidentRepository.save(accident);
        return addedAccident != null ? "success" : "error";
    }

    @GetMapping("/accident/{id}")
    public Accident getAccident(@PathVariable String id){
        Optional<Accident> accident = accidentRepository.findById(id);
        return accident.orElse(null);
    }

    @DeleteMapping(value = "/accident/{id}")
    public String deleteAccident(@PathVariable String id){
        boolean existFlag = accidentRepository.existsById(id);
        if(existFlag){
            accidentRepository.deleteById(id);
        }
        return existFlag ? "success" : "accident does not exist";
    }

    @PutMapping(value = "/accident/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateAccident(@PathVariable String id, @RequestBody Accident accident){
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
            updatedAccident.setWeatherConditions(accident.getWeatherConditions());
            updatedAccident.setRoadType(accident.getRoadType());
            updatedAccident.setUrbanOrRuralArea(accident.getUrbanOrRuralArea());
            updatedAccident.setDidPoliceOfficerAttendSceneOfAccident(accident.isDidPoliceOfficerAttendSceneOfAccident());
            accidentRepository.save(updatedAccident);
            return "success";
        }
        return "accident does not exist";
    }
}