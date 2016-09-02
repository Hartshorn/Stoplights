package com.ge.actors.drivers;


import com.ge.actors.vehicles.Truck;
import com.ge.proto.Driver;
import com.ge.proto.Mentality.*;

public class TruckDriver extends Driver {
    
    public TruckDriver(Truck vehicle, Mood mood, Bravery bravery, Honor honor) {
        super(vehicle, mood, bravery, honor);
    }
}
