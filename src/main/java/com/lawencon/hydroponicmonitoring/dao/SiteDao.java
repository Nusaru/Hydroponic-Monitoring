package com.lawencon.hydroponicmonitoring.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.hydroponicmonitoring.models.Site;

@Repository
public class SiteDao extends BaseDao{

    public Site insert(Site data){
        em.persist(data);
        return data;
    }

    public Site update(Site data){
        return em.merge(data);
    }

    @SuppressWarnings("unchecked")
    public List<Site> getAll(){
        final String sql = "SELECT * FROM t_site";
        return em.createNativeQuery(sql, Site.class).getResultList();
    }

    public Site getById(String id){
        final Site site = em.find(Site.class, id);
        em.detach(site);
        return site;
    }
}
