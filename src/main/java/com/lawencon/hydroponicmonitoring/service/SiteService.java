package com.lawencon.hydroponicmonitoring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.hydroponicmonitoring.dao.SiteDao;
import com.lawencon.hydroponicmonitoring.dto.InsertResDto;
import com.lawencon.hydroponicmonitoring.dto.UpdateResDto;
import com.lawencon.hydroponicmonitoring.dto.site.SiteDataResDto;
import com.lawencon.hydroponicmonitoring.dto.site.SiteInsertReqDto;
import com.lawencon.hydroponicmonitoring.dto.site.SiteResDto;
import com.lawencon.hydroponicmonitoring.dto.site.SiteUpdateReqDto;
import com.lawencon.hydroponicmonitoring.dto.site.SitesResDto;
import com.lawencon.hydroponicmonitoring.models.Site;

@Service
public class SiteService {
    @Autowired
    private SiteDao siteDao;

    @Transactional(rollbackOn = Exception.class)
    public InsertResDto insert(SiteInsertReqDto data){
        Site site = new Site();
        site.setSiteLocation(data.getSiteLocation());
        site.setSiteStatus(data.getSiteStatus());

        site = siteDao.insert(site);

        final InsertResDto dto = new InsertResDto();
        dto.setData(site);
        dto.setMessage("Site Added");
        return dto;
    }
    @Transactional(rollbackOn = Exception.class)
    public UpdateResDto update(SiteUpdateReqDto data){
        Site site = siteDao.getById(data.getId());
        site.setSiteLocation(data.getSiteLocation());
        site.setSiteStatus(data.getSiteStatus());

        site = siteDao.update(site);

        final UpdateResDto dto = new UpdateResDto();
        dto.setData(site);
        dto.setMessage("Site Updated");
        return dto;
    }

    public SitesResDto getAll(){
        final List<Site> sites = siteDao.getAll();
        final List<SiteDataResDto> dataResDtos = new ArrayList<>();
        sites.forEach(site->{
            final SiteDataResDto dataResDto = new SiteDataResDto();
            dataResDto.setId(site.getId());
            dataResDto.setCreatedAt(site.getCreatedAt().toString());
            dataResDto.setSiteLocation(site.getSiteLocation());
            dataResDto.setSiteStatus(site.getSiteStatus());
            
            dataResDtos.add(dataResDto);
        });

        final SitesResDto dto = new SitesResDto();
        dto.setData(dataResDtos);
        return dto;
    }
    
    public SitesResDto searchSite(String query){
        final List<Site> sites = siteDao.getAll();
        final List<SiteDataResDto> dataResDtos = new ArrayList<>();

        sites.stream()
        .filter(site->site.getSiteLocation().toLowerCase().contains(query.toLowerCase()))
        .forEach(site->{
            final SiteDataResDto dataResDto = new SiteDataResDto();
            dataResDto.setId(site.getId());
            dataResDto.setCreatedAt(site.getCreatedAt().toString());
            dataResDto.setSiteLocation(site.getSiteLocation());
            dataResDto.setSiteStatus(site.getSiteStatus());
            
            dataResDtos.add(dataResDto);
        });

        final SitesResDto dto = new SitesResDto();
        dto.setData(dataResDtos);
        return dto;
    }

    public SiteResDto getById(String id){
        final Site site = siteDao.getById(id);
        final SiteDataResDto dataResDto = new SiteDataResDto();
        
        dataResDto.setCreatedAt(site.getCreatedAt().toString());
        dataResDto.setId(site.getId());
        dataResDto.setSiteLocation(site.getSiteLocation());
        dataResDto.setSiteStatus(site.getSiteStatus());

        final SiteResDto dto = new SiteResDto();
        dto.setData(dataResDto);
        return dto;
    }
}
