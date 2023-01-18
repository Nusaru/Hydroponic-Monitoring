package com.lawencon.hydroponicmonitoring.dto.site;

public class SiteDataResDto {
    private String id;
    private String siteLocation;
    private Boolean siteStatus;
    private String createdAt;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
}
