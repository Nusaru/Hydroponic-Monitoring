package com.lawencon.hydroponicmonitoring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_site")
public class Site extends BaseEntity {
    @Column(name = "site_location", nullable = false)
    private String siteLocation;

    @Column(name = "site_status", nullable = false)
    private Boolean siteStatus;

    public String getSiteLocation() {
        return siteLocation;
    }

    public void setSiteLocation(String siteLocation) {
        this.siteLocation = siteLocation;
    }

    public Boolean getSiteStatus() {
        return siteStatus;
    }

    public void setSiteStatus(Boolean siteStatus) {
        this.siteStatus = siteStatus;
    }

}
