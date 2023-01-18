package com.lawencon.hydroponicmonitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.hydroponicmonitoring.dto.InsertResDto;
import com.lawencon.hydroponicmonitoring.dto.UpdateResDto;
import com.lawencon.hydroponicmonitoring.dto.hydroponicunit.HydroponicUnitInsertReqDto;
import com.lawencon.hydroponicmonitoring.dto.hydroponicunit.HydroponicUnitResDto;
import com.lawencon.hydroponicmonitoring.dto.hydroponicunit.HydroponicUnitUpdateReqDto;
import com.lawencon.hydroponicmonitoring.dto.hydroponicunit.HydroponicUnitsResDto;
import com.lawencon.hydroponicmonitoring.service.HydroponicUnitService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("units")
public class HydroponicUnitController {
    @Autowired
    private HydroponicUnitService hydroponicUnitService;

    @PostMapping()
    public ResponseEntity<InsertResDto> insert(@RequestBody HydroponicUnitInsertReqDto data) {
        final InsertResDto dto = hydroponicUnitService.insert(data);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<UpdateResDto> update(@RequestBody HydroponicUnitUpdateReqDto data) {
        final UpdateResDto dto = hydroponicUnitService.update(data);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<HydroponicUnitsResDto> getAll() {
        final HydroponicUnitsResDto dto = hydroponicUnitService.getAll();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<HydroponicUnitResDto> getById(@PathVariable("id") String id) {
        final HydroponicUnitResDto dto = hydroponicUnitService.getById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    
    @GetMapping("site/{id}")
    public ResponseEntity<HydroponicUnitsResDto> getAllBySite(@PathVariable("id") String id) {
        final HydroponicUnitsResDto dto = hydroponicUnitService.getAllBySite(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<HydroponicUnitsResDto> searchUnit(@RequestParam(value = "unit") String unit) {
        final HydroponicUnitsResDto dto = hydroponicUnitService.searchUnit(unit);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
