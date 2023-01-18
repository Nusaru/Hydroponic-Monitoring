package com.lawencon.hydroponicmonitoring.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.hydroponicmonitoring.models.HydroponicUnit;
import com.lawencon.hydroponicmonitoring.models.Site;

@Repository
public class HydroponicUnitDao extends BaseDao{
    
    public HydroponicUnit insert(HydroponicUnit data){
        em.persist(data);
        return data;
    }

    public HydroponicUnit update(HydroponicUnit data){
        return em.merge(data);
    }

    public List<HydroponicUnit> getAll(){
        final String sql = "SELECT hu.id, hu.created_at, hu.unit_name, hu.unit_status, s.id as site_id, s.site_location "
        + "FROM t_hydroponic_unit hu "
        + "INNER JOIN t_site s ON hu.site_id = s.id";
        
        List<?> results = em.createNativeQuery(sql).getResultList();
        List<HydroponicUnit> units = new ArrayList<>();

        if(results!=null&& results.size()>0){
            results.forEach(result->{
                final Object[] objects  = (Object[]) result;
                final HydroponicUnit unit = new HydroponicUnit();
                unit.setId(objects[0].toString());
                unit.setCreatedAt(Timestamp.valueOf(objects[1].toString()).toLocalDateTime());
                unit.setUnitName(objects[2].toString());
                unit.setUnitStatus(Boolean.valueOf(objects[3].toString()));

                final Site site = new Site();
                site.setId(objects[4].toString());
                site.setSiteLocation(objects[5].toString());

                unit.setSite(site);

                units.add(unit);
            });
        }
        return units;
    }

    public HydroponicUnit getById(String id){
        final HydroponicUnit hydroponicUnit = em.find(HydroponicUnit.class, id);
        em.detach(hydroponicUnit);
        return hydroponicUnit;
    }

    public List<HydroponicUnit> getAllBySite(String siteId){
        final String sql = "SELECT hu.id as unit_id, hu.created_at, hu.unit_name, hu.unit_status, s.id as site_id, s.site_location "
        + "FROM t_hydroponic_unit hu "
        + "INNER JOIN t_site s ON hu.site_id = s.id "
        + "WHERE site_id = :siteId";
        
        List<?> results = em.createNativeQuery(sql).setParameter("siteId", siteId).getResultList();
        List<HydroponicUnit> units = new ArrayList<>();

        if(results!=null&& results.size()>0){
            results.forEach(result->{
                final Object[] objects  = (Object[]) result;
                final HydroponicUnit unit = new HydroponicUnit();
                unit.setId(objects[0].toString());
                unit.setCreatedAt(Timestamp.valueOf(objects[1].toString()).toLocalDateTime());
                unit.setUnitName(objects[2].toString());
                unit.setUnitStatus(Boolean.valueOf(objects[3].toString()));

                final Site site = new Site();
                site.setId(objects[4].toString());
                site.setSiteLocation(objects[5].toString());

                unit.setSite(site);

                units.add(unit);
            });
        }
        return units;
    }
}
