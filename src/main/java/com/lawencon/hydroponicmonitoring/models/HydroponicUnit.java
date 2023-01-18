package com.lawencon.hydroponicmonitoring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_hydroponic_unit")
public class HydroponicUnit extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "site_id",nullable = false)
    private Site site;

    @Column(name = "unit_name", nullable = false)
    private String unitName;

    @Column(name = "unit_status", nullable = false)
    private Boolean unitStatus;

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Boolean getUnitStatus() {
        return unitStatus;
    }

    public void setUnitStatus(Boolean unitStatus) {
        this.unitStatus = unitStatus;
    }
    
    
}
