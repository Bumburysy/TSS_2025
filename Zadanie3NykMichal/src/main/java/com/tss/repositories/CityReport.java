package com.tss.repositories;

public class CityReport{
    private String citySize="";
    private long cityCount=0;
    
    public CityReport(String citySize, long cityCount){
        this.citySize=citySize;
        this.cityCount=cityCount;
    }
    
    public String getCitySize(){
        return citySize;
    }
    
    public void setCitySize(String citySize){
        this.citySize = citySize;
    }
    
    public long getCityCount(){
        return cityCount;
    }
    
    public void setCityCount(long cityCount){
        this.cityCount = cityCount;
    }
}