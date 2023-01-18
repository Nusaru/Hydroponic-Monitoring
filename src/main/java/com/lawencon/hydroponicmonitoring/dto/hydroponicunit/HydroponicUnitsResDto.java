package com.lawencon.hydroponicmonitoring.dto.hydroponicunit;

import java.util.List;

public class HydroponicUnitsResDto {
    private List<HydroponicUnitDataResDto> data;

    public List<HydroponicUnitDataResDto> getData() {
        return data;
    }

    public void setData(List<HydroponicUnitDataResDto> data) {
        this.data = data;
    }
    
}
