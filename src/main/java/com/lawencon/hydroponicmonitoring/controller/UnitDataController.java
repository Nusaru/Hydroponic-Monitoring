package com.lawencon.hydroponicmonitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.hydroponicmonitoring.dto.InsertResDto;
import com.lawencon.hydroponicmonitoring.dto.unitdata.UnitDataInsertReqDto;
import com.lawencon.hydroponicmonitoring.dto.unitdata.UnitDatasResDto;
import com.lawencon.hydroponicmonitoring.service.UnitDataService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("unit-datas")
public class UnitDataController {
    @Autowired
    private UnitDataService unitDataService;

    @PostMapping()
    public ResponseEntity<InsertResDto> insert(@RequestBody UnitDataInsertReqDto data) {
        final InsertResDto  dto = unitDataService.insert(data);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<UnitDatasResDto> getAll() {
        final UnitDatasResDto dto = unitDataService.getAll();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("unit/{id}")
    public ResponseEntity<UnitDatasResDto> getAllByUnit(@PathVariable("id") String id) {
        final UnitDatasResDto dto = unitDataService.getAllByUnit(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
