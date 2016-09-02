package com.ge.proto;

import com.ge.road.Location;
import java.util.Collection;
import java.util.Map;


public abstract class Road {
    
    public enum Type { Street, Highway };
    
    private Type type;
    private Double length;
    
    public Road(Type type, Double length) {
        this.length = length;
        this.type = type;
    }
    
    public abstract Map<Location, Driver> getDrivers();
    public abstract Map<Location, Light> getLights();
    public abstract Collection getHazards();
    public abstract void describe();
    
    public Type getType() {
        return this.type;
    }
    
    public Double getLength() {
        return this.length;
    }
}
