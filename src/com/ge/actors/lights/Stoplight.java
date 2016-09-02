package com.ge.actors.lights;

import com.ge.proto.Light;


public class Stoplight extends Light {
    
    
    private Color color;
    
    public Stoplight() {
        this.color = Color.Green;
        super.timer = 0.0;
    }
    
    public Stoplight(Color color) {
        this.color = color;
        this.timer = 0.0;
    }
    
    @Override
    public Color getColor() {
        return this.color;
    }
    
    @Override
    public void change() {
        this.color = this.color.next();
    }
}
