package com.lawencon.hydroponicmonitoring.dto.hydroponicunit;

public class HydroponicUnitUpdateReqDto {
    private String id;
    private String unitName;
    private Boolean unitStatus;
    
    public Boolean getUnitStatus() {
        return unitStatus;
    }
    public void setUnitStatus(Boolean unitStatus) {
        this.unitStatus = unitStatus;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUnitName() {
        return unitName;
    }
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
