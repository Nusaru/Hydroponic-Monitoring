package com.lawencon.hydroponicmonitoring.dto.hydroponicunit;

public class HydroponicUnitDataResDto {
    private String id;
    private String createdAt;
    private String siteLocation;
    private String unitName;
    private Boolean unitStatus;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String getSiteLocation() {
        return siteLocation;
    }
    public void setSiteLocation(String siteLocation) {
        this.siteLocation = siteLocation;
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
