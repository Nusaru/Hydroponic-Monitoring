package com.lawencon.hydroponicmonitoring.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.hydroponicmonitoring.models.HydroponicUnit;
import com.lawencon.hydroponicmonitoring.models.Site;
import com.lawencon.hydroponicmonitoring.models.UnitData;

@Repository
public class UnitDataDao extends BaseDao{
    
    public UnitData insert(UnitData data){
        em.persist(data);
        return data;
    }

    public UnitData update(UnitData data){
        return em.merge(data);
    }

    public UnitData getById(String id){
        final UnitData unitData = em.find(UnitData.class, id);
        em.detach(unitData);
        return unitData;
    }

    public List<UnitData> getAll(){
        final String sql = "SELECT ud.id as data_id, ud.created_at, ud.electrical_conductivity, "
        +"ud.ph, ud.total_disolved_solids, ud.water_temp, hu.id as unit_id, hu.unit_name, "
        +"s.id as site_id, s.site_location "
        +"FROM t_unit_data ud "
        +"INNER JOIN t_hydroponic_unit hu ON hu.id = ud.unit_id "
        +"INNER JOIN t_site s ON s.id = hu.site_id";

        final List<?> results = em.createNativeQuery(sql).getResultList();
        final List<UnitData> unitDatas = new ArrayList<>();

        if(results!=null && results.size()>0){
            results.forEach(result ->{
                final Object[] objects = (Object[]) result;
                final UnitData unitData = new UnitData();
                unitData.setId(objects[0].toString());
                unitData.setCreatedAt(Timestamp.valueOf(objects[1].toString()).toLocalDateTime());
                unitData.setElectricalConductivity(Double.valueOf(objects[2].toString()));
                unitData.setPh(Double.valueOf(objects[3].toString()));
                unitData.setTotalDisolvedSolid(Double.valueOf(objects[4].toString()));
                unitData.setWaterTemp(Double.valueOf(objects[5].toString()));

                final HydroponicUnit unit = new HydroponicUnit();
                unit.setId(objects[6].toString());
                unit.setUnitName(objects[7].toString());
                
                final Site site = new Site();
                site.setId(objects[8].toString());
                site.setSiteLocation(objects[9].toString());
                unit.setSite(site);

                unitData.setHydroponicUnit(unit);

                unitDatas.add(unitData);
            });
        }
        return unitDatas;
    }

    public List<UnitData> getAllByUnit(String unitId){
        final String sql = "SELECT ud.id as data_id, ud.created_at, ud.electrical_conductivity, "
        +"ud.ph, ud.total_disolved_solids, ud.water_temp, hu.id as unit_id, hu.unit_name, "
        +"s.id as site_id, s.site_location "
        +"FROM t_unit_data ud "
        +"INNER JOIN t_hydroponic_unit hu ON ud.unit_id = hu.id "
        +"INNER JOIN t_site s ON hu.site_id = s.id "
        +"WHERE unit_id = :unitId";

        List<?> results = em.createNativeQuery(sql).setParameter("unitId", unitId).getResultList();
        final List<UnitData> unitDatas = new ArrayList<>();

        if(results!=null && results.size()>0){
            results.forEach(result ->{
                final Object[] objects = (Object[]) result;
                final UnitData unitData = new UnitData();
                unitData.setId(objects[0].toString());
                unitData.setCreatedAt(Timestamp.valueOf(objects[1].toString()).toLocalDateTime());
                unitData.setElectricalConductivity(Double.valueOf(objects[2].toString()));
                unitData.setPh(Double.valueOf(objects[3].toString()));
                unitData.setTotalDisolvedSolid(Double.valueOf(objects[4].toString()));
                unitData.setWaterTemp(Double.valueOf(objects[5].toString()));

                final HydroponicUnit unit = new HydroponicUnit();
                unit.setId(objects[6].toString());
                unit.setUnitName(objects[7].toString());
                
                final Site site = new Site();
                site.setId(objects[8].toString());
                site.setSiteLocation(objects[9].toString());
                unit.setSite(site);

                unitData.setHydroponicUnit(unit);

                unitDatas.add(unitData);
            });
        }
        return unitDatas;
    }
}
