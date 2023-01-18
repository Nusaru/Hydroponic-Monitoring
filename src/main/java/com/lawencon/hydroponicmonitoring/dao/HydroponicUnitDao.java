package com.lawencon.hydroponicmonitoring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.hydroponicmonitoring.models.HydroponicUnit;

@Repository
public class HydroponicUnitDao extends BaseDao{
    
    public HydroponicUnit insert(HydroponicUnit data){
        em.persist(data);
        return data;
    }

    public HydroponicUnit update(HydroponicUnit data){
        return em.merge(data);
    }

    @SuppressWarnings("unchecked")
    public List<HydroponicUnit> getAll(){
        final String sql = "SELECT * FROM t_hydroponic_unit";
        return em.createNativeQuery(sql, HydroponicUnit.class).getResultList();
    }

    public HydroponicUnit getById(String id){
        final HydroponicUnit hydroponicUnit = em.find(HydroponicUnit.class, id);
        em.detach(hydroponicUnit);
        return hydroponicUnit;
    }

    @SuppressWarnings("unchecked")
    public List<HydroponicUnit> getAllBySite(String siteId){
        final String sql = "SELECT * FROM t_hydroponic_unit hu INNER JOIN t_site s ON hu.site_id = s.id WHERE hu.site_id = :siteId";
        final List<HydroponicUnit> results = em.createNativeQuery(sql, HydroponicUnit.class).setParameter("siteId",siteId).getResultList();
        return results;
    }
}
