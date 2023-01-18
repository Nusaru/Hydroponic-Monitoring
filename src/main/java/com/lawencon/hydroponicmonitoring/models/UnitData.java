package com.lawencon.hydroponicmonitoring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_unit_data")
public class UnitData extends BaseEntity{
    
    @ManyToOne
    @JoinColumn(name = "unit_id",nullable = false)
    private HydroponicUnit hydroponicUnit;

    @Column(name = "ph", nullable = false)
    private Double ph;

    @Column(name = "electrical_conductivity", nullable = false)
    private Double electricalConductivity;

    @Column(name = "total_disolved_solids", nullable = false)
    private Double totalDisolvedSolid;

    @Column(name = "water_temp", nullable = false)
    private Double waterTemp;

    public HydroponicUnit getHydroponicUnit() {
        return hydroponicUnit;
    }

    public void setHydroponicUnit(HydroponicUnit hydroponicUnit) {
        this.hydroponicUnit = hydroponicUnit;
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

    public Double getTotalDisolvedSolid() {
        return totalDisolvedSolid;
    }

    public void setTotalDisolvedSolid(Double totalDisolvedSolid) {
        this.totalDisolvedSolid = totalDisolvedSolid;
    }

    public Double getWaterTemp() {
        return waterTemp;
    }

    public void setWaterTemp(Double waterTemp) {
        this.waterTemp = waterTemp;
    }
    
}