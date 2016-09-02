package com.ge.actors.vehicles;

import com.ge.proto.Vehicle;
import static com.ge.proto.Details.*;

public class Car extends Vehicle {
    
    public Car(Color color, Size size, Speed speed, Type type) {
        super(color, size, speed, type);
    }
}
