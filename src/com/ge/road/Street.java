package com.ge.road;

import com.ge.proto.Driver;
import com.ge.proto.Light;
import com.ge.proto.Road;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class Street extends Road {
    
    private Map<Location, Driver> drivers = new HashMap();
    private Map<Location, Light> lights = new HashMap<>();

    public Street() {
        super(Type.Street, 100.00);
    }
    
    public Street(Map<Location, Driver> drivers, 
                  Map<Location, Light> lights) {
        super(Type.Street, (double) lights.size());
        this.drivers = drivers;
        this.lights = lights;
    }

    @Override
    public Map<Location, Driver> getDrivers() {
        return this.drivers;
    }

    @Override
    public Map<Location, Light> getLights() {
        return this.lights;
    }

    @Override
    public Collection getHazards() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void describe() {
        this.drivers.forEach((loc, d) -> showDriver(loc, d));
        this.lights.forEach((loc, l) -> showLights(loc, l));
                
    }

    private void showDriver(Location loc, Driver d) {
        System.out.println("At " + loc.getValue().intValue() + " is a " + d);
    }

    private void showLights(Location loc, Light l) {
        System.out.println("At " + loc.getValue().intValue() + " is a " + l.getColor() + " light");
    }
}
