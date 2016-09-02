package com.ge.util;

import com.ge.actors.drivers.CarDriver;
import com.ge.actors.drivers.TruckDriver;
import com.ge.actors.lights.Stoplight;
import com.ge.actors.vehicles.Car;
import com.ge.actors.vehicles.Truck;
import com.ge.proto.Details.*;
import com.ge.proto.Mentality.*;
import com.ge.proto.Driver;
import com.ge.proto.Light;
import com.ge.proto.Road;
import com.ge.road.Location;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class ActorUtil {
    
    private static Driver createCarDriver() {
        return new CarDriver(new Car(Color.randomColor(), 
                                     Size.randomSize(), 
                                     Speed.randomSpeed(),
                                     Type.Car), 
                             Mood.randomMood(), 
                             Bravery.randomBravery(), 
                             Honor.randomHonor());    
    }

    private static Driver createTruckDriver() {
        return new TruckDriver(new Truck(Color.randomColor(), 
                                         Size.randomSize(), 
                                         Speed.randomSpeed(),
                                         Type.Truck), 
                             Mood.randomMood(), 
                             Bravery.randomBravery(), 
                             Honor.randomHonor());
    }
    
    private static Driver createRandomDriver() {
        return new TruckDriver(new Truck(Color.randomColor(), 
                                         Size.randomSize(), 
                                         Speed.randomSpeed(),
                                         Type.randomVehicleType()), 
                             Mood.randomMood(), 
                             Bravery.randomBravery(), 
                             Honor.randomHonor());
    }
    
    private static Driver createDriver(Type type) {
        
        if(type == null) {
            return createRandomDriver();
        } else {
            switch (type) {
                case Car:
                    return createCarDriver();
                case Truck:
                    return createTruckDriver();
                default:
                    return createRandomDriver();
            }
        }
    }

    private static Collection<Driver> makeDriverList(int number, boolean isRandom) {
        Collection<Driver> drivers = new ArrayDeque<>();
        
        if (isRandom) {
            do {
                drivers.add(createRandomDriver());
                number--;
            } while (number > 0);
        } else {
            drivers.add(createDriver(Type.Car));
            drivers.add(createDriver(Type.Semi));
        }
            return drivers;
    }

    public static Map<Location, Light> makeLightList(Double streetLength, Road.Type type) {
        
        Map<Location, Light> lights = new HashMap<>();
        
        switch (type) {
            case Street:
                for (double i = 0; i < streetLength; i += 10.0) {
                    lights.put(new Location(i), new Stoplight());
                }
                return lights;
            case Highway:
                for (double i = 0; i < streetLength; i += 20.0) {
                    lights.put(new Location(i), new Stoplight());
                }
                return lights;
            default:
                return null;
        }
    }

    public static Map<Location, Driver> makeDriverList(int numberOfDrivers) {
        Map<Location, Driver> drivers = new HashMap<>();
        
        makeDriverList(numberOfDrivers, true).forEach(
                d -> drivers.put(new Location(0.0), d));
        
        return drivers;
    }
}
