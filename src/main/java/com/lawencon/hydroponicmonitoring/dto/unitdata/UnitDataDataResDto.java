package com.lawencon.hydroponicmonitoring.dto.unitdata;

public class UnitDataDataResDto {
    private String id;
    private String unitName;
    private String siteLocation;
    private Double ph;
    private Double electricalConductivity;
    private Double totalDisolvedSolids;
    private Double waterTemp;
    private String createdAt;
    
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
    public String getSiteLocation() {
        return siteLocation;
    }
    public void setSiteLocation(String siteLocation) {
        this.siteLocation = siteLocation;
    }
    public Double getPh() {
        return ph;
    }
    public void setPh(Double ph) {
        this.ph = ph;
    }
    public Double getElectricalConductivity() {
        return electricalConductivity;
    }
    public void setElectricalConductivity(Double electricalConductivity) {
        this.electricalConductivity = electricalConductivity;
    }
    public Double getTotalDisolvedSolids() {
        return totalDisolvedSolids;
    }
    public void setTotalDisolvedSolids(Double totalDisolvedSolids) {
        this.totalDisolvedSolids = totalDisolvedSolids;
    }
    public Double getWaterTemp() {
        return waterTemp;
    }
    public void setWaterTemp(Double waterTemp) {
        this.waterTemp = waterTemp;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    
}