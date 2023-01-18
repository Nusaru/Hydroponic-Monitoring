package com.lawencon.hydroponicmonitoring.dto.unitdata;

public class UnitDataInsertReqDto {
    private String unitId;
    private Double ph;
    private Double electricalConductivity;
    private Double totalDisolvedSolids;
    private Double waterTemp;
    
    public String getUnitId() {
        return unitId;
    }
    public void setUnitId(String unitId) {
        this.unitId = unitId;
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

    
}
