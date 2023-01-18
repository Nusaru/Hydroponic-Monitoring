package com.lawencon.hydroponicmonitoring.dto.site;

public class SiteInsertReqDto {
    private String siteLocation;
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
