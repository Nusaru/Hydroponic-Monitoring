package com.lawencon.hydroponicmonitoring.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
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

    public List<Site> getAll(){
        final String sql = "SELECT id, created_at, site_location, site_status FROM t_site";
        List<?> results = em.createNativeQuery(sql).getResultList();
        List<Site> sites = new ArrayList<>();
        if(results!=null&& results.size()>0){
            results.forEach(result->{
                final Object[] objects  = (Object[]) result;
                final Site site = new Site();
                site.setId(objects[0].toString());
                site.setCreatedAt(Timestamp.valueOf(objects[1].toString()).toLocalDateTime());
                site.setSiteLocation(objects[2].toString());
                site.setSiteStatus(Boolean.valueOf(objects[3].toString()));

                sites.add(site);
            });
        }
        return sites;
    }

    public Site getById(String id){
        final Site site = em.find(Site.class, id);
        em.detach(site);
        return site;
    }
}
