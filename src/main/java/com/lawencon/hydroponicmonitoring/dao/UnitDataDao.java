package com.lawencon.hydroponicmonitoring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

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
    
    @SuppressWarnings("unchecked")
    public List<UnitData> getAll(){
        final String sql = "SELECT * FROM t_unit_data";
        return em.createNativeQuery(sql,UnitData.class).getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<UnitData> getAllByUnit(String unitId){
        final String sql = "SELECT * FROM t_unit_data ud INNER JOIN t_hydroponic_unit u ON ud.unit_id = u.id WHERE ud.unit_id = :unitId";
        return em.createNativeQuery(sql, UnitData.class).setParameter("unitId", unitId).getResultList();
    }
}
