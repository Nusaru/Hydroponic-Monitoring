package com.lawencon.hydroponicmonitoring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.hydroponicmonitoring.dao.HydroponicUnitDao;
import com.lawencon.hydroponicmonitoring.dao.SiteDao;
import com.lawencon.hydroponicmonitoring.dto.InsertResDto;
import com.lawencon.hydroponicmonitoring.dto.UpdateResDto;
import com.lawencon.hydroponicmonitoring.dto.hydroponicunit.HydroponicUnitDataResDto;
import com.lawencon.hydroponicmonitoring.dto.hydroponicunit.HydroponicUnitInsertReqDto;
import com.lawencon.hydroponicmonitoring.dto.hydroponicunit.HydroponicUnitResDto;
import com.lawencon.hydroponicmonitoring.dto.hydroponicunit.HydroponicUnitUpdateReqDto;
import com.lawencon.hydroponicmonitoring.dto.hydroponicunit.HydroponicUnitsResDto;
import com.lawencon.hydroponicmonitoring.models.HydroponicUnit;
import com.lawencon.hydroponicmonitoring.models.Site;

@Service
public class HydroponicUnitService {
    @Autowired
    private HydroponicUnitDao hydroponicUnitDao;
    @Autowired
    private SiteDao siteDao;

    @Transactional(rollbackOn = Exception.class)
    public InsertResDto insert(HydroponicUnitInsertReqDto data) {
        HydroponicUnit unit = new HydroponicUnit();
        final Site site = siteDao.getById(data.getSiteId());
        unit.setSite(site);

        unit.setUnitName(data.getUnitName());
        unit.setUnitStatus(data.getUnitStatus());

        unit = hydroponicUnitDao.insert(unit);

        final InsertResDto dto = new InsertResDto();
        dto.setData(unit);
        dto.setMessage("Unit Created");
        return dto;
    }

    @Transactional(rollbackOn = Exception.class)
    public UpdateResDto update(HydroponicUnitUpdateReqDto data) {
        HydroponicUnit unit = hydroponicUnitDao.getById(data.getId());
        unit.setUnitName(data.getUnitName());
        unit.setUnitStatus(data.getUnitStatus());

        unit = hydroponicUnitDao.update(unit);

        final UpdateResDto dto = new UpdateResDto();
        dto.setData(unit);
        dto.setMessage("Unit Updated");
        return dto;
    }

    public HydroponicUnitsResDto getAll() {
        final List<HydroponicUnit> units = hydroponicUnitDao.getAll();
        final List<HydroponicUnitDataResDto> dataResDtos = new ArrayList<>();
        units.forEach(unit -> {
            final HydroponicUnitDataResDto dataResDto = new HydroponicUnitDataResDto();
            dataResDto.setCreatedAt(unit.getCreatedAt().toString());
            dataResDto.setId(unit.getId());
            dataResDto.setSiteLocation(unit.getSite().getSiteLocation());
            dataResDto.setUnitName(unit.getUnitName());
            dataResDto.setUnitStatus(unit.getUnitStatus());

            dataResDtos.add(dataResDto);
        });

        final HydroponicUnitsResDto dto = new HydroponicUnitsResDto();
        dto.setData(dataResDtos);
        return dto;
    }

    public HydroponicUnitsResDto searchUnit(String query) {
        final List<HydroponicUnit> units = hydroponicUnitDao.getAll();
        final List<HydroponicUnitDataResDto> dataResDtos = new ArrayList<>();
        units.stream()
        .filter(unit->unit.getUnitName().toLowerCase().contains(query.toLowerCase())).
        forEach(unit -> {
            final HydroponicUnitDataResDto dataResDto = new HydroponicUnitDataResDto();
            dataResDto.setCreatedAt(unit.getCreatedAt().toString());
            dataResDto.setId(unit.getId());
            dataResDto.setSiteLocation(unit.getSite().getSiteLocation());
            dataResDto.setUnitName(unit.getUnitName());
            dataResDto.setUnitStatus(unit.getUnitStatus());

            dataResDtos.add(dataResDto);
        });

        final HydroponicUnitsResDto dto = new HydroponicUnitsResDto();
        dto.setData(dataResDtos);
        return dto;
    }

    public HydroponicUnitResDto getById(String id) {
        final HydroponicUnit unit = hydroponicUnitDao.getById(id);
        final HydroponicUnitDataResDto dataResDto = new HydroponicUnitDataResDto();
        dataResDto.setCreatedAt(unit.getCreatedAt().toString());
        dataResDto.setId(unit.getId());
        dataResDto.setSiteLocation(unit.getSite().getSiteLocation());
        dataResDto.setUnitName(unit.getUnitName());
        dataResDto.setUnitStatus(unit.getUnitStatus());

        final HydroponicUnitResDto dto = new HydroponicUnitResDto();
        dto.setData(dataResDto);
        return dto;
    }

    public HydroponicUnitsResDto getAllBySite(String siteId) {
        final List<HydroponicUnit> units = hydroponicUnitDao.getAllBySite(siteId);
        final List<HydroponicUnitDataResDto> dataResDtos = new ArrayList<>();
        units.forEach(unit -> {
            final HydroponicUnitDataResDto dataResDto = new HydroponicUnitDataResDto();
            dataResDto.setCreatedAt(unit.getCreatedAt().toString());
            dataResDto.setId(unit.getId());
            dataResDto.setSiteLocation(unit.getSite().getSiteLocation());
            dataResDto.setUnitName(unit.getUnitName());
            dataResDto.setUnitStatus(unit.getUnitStatus());

            dataResDtos.add(dataResDto);
        });

        final HydroponicUnitsResDto dto = new HydroponicUnitsResDto();
        dto.setData(dataResDtos);
        return dto;
    }
}
