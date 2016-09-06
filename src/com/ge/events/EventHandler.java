package com.ge.events;

import static com.ge.proto.Details.Speed.*;
import com.ge.proto.Driver;
import com.ge.proto.Light.Color;
import com.ge.proto.Road;
import com.ge.road.Location;
import java.util.HashMap;
import java.util.Map;

public class EventHandler {

    private Road road;
    private Double time;

    public EventHandler(Road road) {
        this.road = road;
        this.time = 0.0;
    }
    
    public Road getRoad() {
        return this.road;
    }
    
    public void tick(int n) {
        do {
            tick();
            n--;
        } while(n > 0);
    }
    
    public void tick() {
        
        makeDecision(this.road.getDrivers(), this.road);
        
        this.road.getDrivers().forEach((location, driver) -> {
            location.incrementValue(driver.getVehicle().getSpeed());
        });
        
        this.road.getLights().forEach((location, light) -> {
            if(this.time % 30 == 0) {
                light.setTimer(0.0);
                light.change();
            }
        });
        
        time++;
    }

    private void makeDecision(Map<Location, Driver> drivers, Road road) {
        
        drivers.forEach((location, driver) -> {
            
            if(road.getLights().get(location) != null) {
                
                Color lightColor = road.getLights().get(location).getColor();
                
                switch (lightColor) {
                    case Red:
                        driver.getVehicle().setSpeed(Stopped);
                        break;
                    case Yellow:
                        driver.getVehicle().setSpeed(
                                driver.getVehicle().getSpeed().slowDown());
                        break;
                    case Green:
                        driver.getVehicle().setSpeed(
                                driver.getVehicle().getSpeed().speedUp());
                        break;
                }
            } else if(road.getDrivers().get(location) != null) {
                
                Driver otherDriver = road.getDrivers().get(location);
                Map<Relation,Integer> relations = getDriverRelations(driver, otherDriver);
                
                if(relations.get(Relation.Bravery) > 0) {
                    
                    driver.getVehicle().getSpeed().speedUp();
                    otherDriver.getVehicle().getSpeed().slowDown();
                    
                } else if((relations.get(Relation.Honor) > 0) && 
                        (relations.get(Relation.Priority) < 0)) {
                    
                    driver.getVehicle().getSpeed().slowDown();
                    otherDriver.getVehicle().getSpeed().speedUp();
                    
                } else {
                    
                    driver.getVehicle().getSpeed().slowDown();
                    otherDriver.getVehicle().getSpeed().slowDown();
                }
            }
        });
    }

    private Map<Relation, Integer> getDriverRelations(Driver d1, Driver d2) {

        Map<Relation,Integer> relations = new HashMap<>();
        
        relations.put(Relation.Bravery, 
                d1.getBravery()
                  .compareTo(d2.getBravery()));
        
        relations.put(Relation.Honor, 
                d1.getHonor()
                  .compareTo(d2.getHonor()));
        
        relations.put(Relation.Priority, 
                d1.getVehicle()
                  .getPriority()
                  .compareTo(d2.getVehicle().getPriority()));
        
        relations.put(Relation.Mood, 
                d1.getMood()
                  .compareTo(d2.getMood()));
        
        relations.put(Relation.Size, 
                d1.getVehicle()
                  .getSize()
                  .compareTo(d2.getVehicle().getSize()));
        
        return relations;
    }
    
     private enum Relation { Bravery, Honor, Priority, Mood, Size }
}
