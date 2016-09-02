package com.ge.actors.drivers;

import com.ge.actors.vehicles.Car;
import com.ge.proto.Driver;
import com.ge.proto.Mentality.*;


public class CarDriver extends Driver {
    
    public CarDriver(Car vehicle, Mood mood, Bravery bravery, Honor honor) {
        super(vehicle, mood, bravery, honor);
    }
}
