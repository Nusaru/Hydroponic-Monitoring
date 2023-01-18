package com.lawencon.hydroponicmonitoring.dto.hydroponicunit;

public class HydroponicUnitInsertReqDto {
    private String siteId;
    private String unitName;
    private Boolean unitStatus;
    
    public String getSiteId() {
        return siteId;
    }
    public void setSiteId(String siteId) {
        this.siteId = siteId;
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
