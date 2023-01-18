package com.lawencon.hydroponicmonitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.hydroponicmonitoring.dto.InsertResDto;
import com.lawencon.hydroponicmonitoring.dto.UpdateResDto;
import com.lawencon.hydroponicmonitoring.dto.site.SiteInsertReqDto;
import com.lawencon.hydroponicmonitoring.dto.site.SiteResDto;
import com.lawencon.hydroponicmonitoring.dto.site.SiteUpdateReqDto;
import com.lawencon.hydroponicmonitoring.dto.site.SitesResDto;
import com.lawencon.hydroponicmonitoring.service.SiteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("sites")
public class SiteController {
    @Autowired
    private SiteService siteService;

    @PostMapping()
    public ResponseEntity<InsertResDto> insert(@RequestBody SiteInsertReqDto data) {
        final InsertResDto dto = siteService.insert(data);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<UpdateResDto> update(@RequestBody SiteUpdateReqDto data) {
        final UpdateResDto dto = siteService.update(data);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<SitesResDto> getAll() {
        final SitesResDto dto = siteService.getAll();
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<SitesResDto> getAll(@RequestParam(value = "site") String site) {
        final SitesResDto dto = siteService.searchSite(site);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<SiteResDto> getById(@PathVariable("id") String id){
        final SiteResDto dto = siteService.getById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
