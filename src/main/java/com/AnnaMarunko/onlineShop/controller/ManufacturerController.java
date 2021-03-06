package com.AnnaMarunko.onlineShop.controller;

import com.AnnaMarunko.onlineShop.entity.Manufacturer;
import com.AnnaMarunko.onlineShop.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService){
        this.manufacturerService = manufacturerService;
    }
    @PostMapping("/api/manufacturer")
    public ResponseEntity<?> create(@RequestBody Manufacturer manufacturer){
        manufacturerService.create(manufacturer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/manufacturer")
    public ResponseEntity<List<Manufacturer>> findALL(){
        final List<Manufacturer> manufacturerList = manufacturerService.findAll();
        return manufacturerList != null && !manufacturerList.isEmpty()
                ? new ResponseEntity<>(manufacturerList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/manufacturer/{id}")
    public ResponseEntity<Optional<Manufacturer>> find(@PathVariable(name = "id")Long id){
        final Optional<Manufacturer> manufacturer = manufacturerService.find(id);
        return manufacturer!=null
                ? new ResponseEntity<>(manufacturer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/manufacturer/{id}")
    public ResponseEntity<?> updateManufacturer(@PathVariable(name = "id")Long id, @RequestBody Manufacturer manufacturerUpdate){
        return manufacturerService.find(id).map(manufacturer -> {
            manufacturer.setName(manufacturerUpdate.getName());
            manufacturerService.update(manufacturer);
            return new ResponseEntity<>(manufacturer, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }


}
