package com.ge.proto;

import static com.ge.proto.Details.*;

public abstract class Vehicle {
    
    private final Color color;
    private Speed speed;
    private final Size size;
    private final Type type;
    
    private final Priority priority = Priority.randomPriority();
    
    public Vehicle(Color color, Size size, Speed speed, Type type) {
        this.color = color;
        this.speed = speed;
        this.size = size;
        this.type = type;
    }
    
    public Color getColor() {
        return this.color;
    }

    public Speed getSpeed() {
        return this.speed;
    }
    
    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public Size getSize() {
        return this.size;
    }

    public Priority getPriority() {
        return this.priority;
    }
    
    public String toString() {
        return this.size + ", " + this.color + ", " + this.speed + " " +
                this.type + " that has " + this.priority + " priority";
    }
}
