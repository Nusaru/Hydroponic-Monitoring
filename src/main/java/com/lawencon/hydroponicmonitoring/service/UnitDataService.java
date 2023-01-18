package com.lawencon.hydroponicmonitoring.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.hydroponicmonitoring.dao.HydroponicUnitDao;
import com.lawencon.hydroponicmonitoring.dao.UnitDataDao;
import com.lawencon.hydroponicmonitoring.dto.InsertResDto;
import com.lawencon.hydroponicmonitoring.dto.unitdata.UnitDataDataResDto;
import com.lawencon.hydroponicmonitoring.dto.unitdata.UnitDataInsertReqDto;
import com.lawencon.hydroponicmonitoring.dto.unitdata.UnitDatasResDto;
import com.lawencon.hydroponicmonitoring.models.HydroponicUnit;
import com.lawencon.hydroponicmonitoring.models.UnitData;

@Service
public class UnitDataService {
    @Autowired
    private UnitDataDao unitDataDao;
    @Autowired
    private HydroponicUnitDao hydroponicUnitDao;

    private DecimalFormat df = new DecimalFormat("#.##");

    @Transactional(rollbackOn = Exception.class)
    public InsertResDto insert(UnitDataInsertReqDto data){
        UnitData unitData = new UnitData();
        unitData.setElectricalConductivity(data.getElectricalConductivity());

        final HydroponicUnit unit = hydroponicUnitDao.getById(data.getUnitId());
        unitData.setHydroponicUnit(unit);

        unitData.setPh(data.getPh());
        unitData.setTotalDisolvedSolid(data.getTotalDisolvedSolids());
        unitData.setWaterTemp(data.getWaterTemp());

        unitData = unitDataDao.insert(unitData);

        final InsertResDto dto = new InsertResDto();
        dto.setData(unitData);
        dto.setMessage("data added");
        return dto;
    }

    public UnitDatasResDto getAll(){
        final List<UnitData> unitDatas = unitDataDao.getAll();
        final List<UnitDataDataResDto> dataResDtos = new ArrayList<>();
        unitDatas.stream()
        .sorted(Comparator.comparing(UnitData::getCreatedAt).reversed())
        .map(unitData -> {
            Double formattedEc = Double.valueOf(df.format(unitData.getElectricalConductivity()));
            unitData.setElectricalConductivity(formattedEc);
            Double formattedPh = Double.valueOf(df.format(unitData.getPh()));
            unitData.setPh(formattedPh);
            Double formattedTds = Double.valueOf(df.format(unitData.getTotalDisolvedSolid()));
            unitData.setTotalDisolvedSolid(formattedTds);
            Double formattedTemp = Double.valueOf(df.format(unitData.getWaterTemp()));
            unitData.setWaterTemp(formattedTemp);
            return unitData;
        })
        .forEach(unitData->{
            final UnitDataDataResDto dataResDto = new UnitDataDataResDto();
            dataResDto.setElectricalConductivity(unitData.getElectricalConductivity());
            dataResDto.setPh(unitData.getPh());
            dataResDto.setSiteLocation(unitData.getHydroponicUnit().getSite().getSiteLocation());
            dataResDto.setTotalDisolvedSolids(unitData.getTotalDisolvedSolid());
            dataResDto.setUnitName(unitData.getHydroponicUnit().getUnitName());
            dataResDto.setWaterTemp(unitData.getWaterTemp());
            dataResDto.setId(unitData.getId());
            dataResDto.setCreatedAt(unitData.getCreatedAt().toString());

            dataResDtos.add(dataResDto);
        });

        final UnitDatasResDto dto = new UnitDatasResDto();
        dto.setData(dataResDtos);
        return dto;
    }

    public UnitDatasResDto getAllByUnit(String unitId){
        final List<UnitData> unitDatas = unitDataDao.getAllByUnit(unitId);
        final List<UnitDataDataResDto> dataResDtos = new ArrayList<>();
        unitDatas.stream()
        .sorted(Comparator.comparing(UnitData::getCreatedAt).reversed())
        .map(unitData -> {
            Double formattedEc = Double.valueOf(df.format(unitData.getElectricalConductivity()));
            unitData.setElectricalConductivity(formattedEc);
            Double formattedPh = Double.valueOf(df.format(unitData.getPh()));
            unitData.setPh(formattedPh);
            Double formattedTds = Double.valueOf(df.format(unitData.getTotalDisolvedSolid()));
            unitData.setTotalDisolvedSolid(formattedTds);
            Double formattedTemp = Double.valueOf(df.format(unitData.getWaterTemp()));
            unitData.setWaterTemp(formattedTemp);
            return unitData;
        })
        .forEach(unitData->{
            final UnitDataDataResDto dataResDto = new UnitDataDataResDto();
            dataResDto.setElectricalConductivity(unitData.getElectricalConductivity());
            dataResDto.setPh(unitData.getPh());
            dataResDto.setSiteLocation(unitData.getHydroponicUnit().getSite().getSiteLocation());
            dataResDto.setTotalDisolvedSolids(unitData.getTotalDisolvedSolid());
            dataResDto.setUnitName(unitData.getHydroponicUnit().getUnitName());
            dataResDto.setWaterTemp(unitData.getWaterTemp());
            dataResDto.setId(unitData.getId());
            dataResDto.setCreatedAt(unitData.getCreatedAt().toString());

            dataResDtos.add(dataResDto);
        });

        final UnitDatasResDto dto = new UnitDatasResDto();
        dto.setData(dataResDtos);
        return dto;
    }
}