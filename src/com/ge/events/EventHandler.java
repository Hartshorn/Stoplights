package com.ge.events;

import static com.ge.proto.Details.Speed.*;
import com.ge.proto.Driver;
import com.ge.proto.Light.Color;
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
        
        this.road.getDrivers().forEach((l, d) -> {
            l.incrementValue(d.getVehicle().getSpeed());
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
        
        drivers.forEach((light, driver) -> {
            
            if(road.getLights().get(light) != null) {
                
                Color lightColor = road.getLights().get(light).getColor();
                
                switch (lightColor) {
                    case Red:
                        driver.getVehicle().setSpeed(Stopped);
                        break;
                    case Yellow:
                        driver.getVehicle().setSpeed(
                                driver.getVehicle().getSpeed().slowDown());
                        break;
                    case Green:
                        break;
                }     
            }
        });
    }
}
