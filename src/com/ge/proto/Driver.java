package com.ge.proto;

import static com.ge.proto.Mentality.*;

public abstract class Driver {
    
    private final Vehicle vehicle;
    private final Mood mood;
    private final Bravery bravery;
    private final Honor honor;
    
    private Double startLoc;
    
    public Driver(Vehicle vehicle, Mood mood, Bravery bravery, Honor honor) {
        this.vehicle = vehicle;
        this.bravery = bravery;
        this.mood = mood;
        this.honor = honor;
    }
    
    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public Mood getMood() {
        return mood;
    }

    public Bravery getBravery() {
        return bravery;
    }

    public Honor getHonor() {
        return honor;
    }
    
    @Override
    public String toString() {
        return this.mood + ", " + this.honor + ", " + 
               this.bravery + " driver\n\twith a " + this.vehicle;
    }

    public Double getStartLoc() {
        return startLoc;
    }
    
    public void setStartLoc(Double startLoc) {
        this.startLoc = startLoc;
    }
}
