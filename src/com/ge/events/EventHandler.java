package com.ge.events;

import com.ge.proto.Details;
import static com.ge.proto.Details.Speed.*;
import com.ge.proto.Driver;
import com.ge.proto.Light.Color;
import com.ge.proto.Mentality;
import com.ge.proto.Road;
import com.ge.road.Location;
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
                
                Driver anotherDriver = 
                        road.getDrivers().get(location);
                Mentality.Bravery howBrave = 
                        anotherDriver.getBravery();
                Mentality.Honor howHonorable = 
                        anotherDriver.getHonor();
                Details.Priority whatPriority = 
                        anotherDriver.getVehicle().getPriority();
                
                if(driver.getBravery().compareTo(howBrave) > 0) {
                    driver.getVehicle().getSpeed().speedUp();
                    anotherDriver.getVehicle().getSpeed().slowDown();
                } else if((driver.getHonor().compareTo(howHonorable) > 0) &&
                        (driver.getVehicle().getPriority().compareTo(whatPriority) < 0)) {
                    driver.getVehicle().getSpeed().slowDown();
                    anotherDriver.getVehicle().getSpeed().speedUp();
                } else {
                    driver.getVehicle().getSpeed().slowDown();
                    anotherDriver.getVehicle().getSpeed().slowDown();
                }
            }
        });
    }
}
