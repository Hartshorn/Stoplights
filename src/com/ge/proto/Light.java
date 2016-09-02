package com.ge.proto;

public abstract class Light {
    
    public enum Color { 
        Green,
        Yellow, 
        Red {
            @Override
            public Color next() {
                return values()[0];
            };
        };
                        
        public Color next() {
            return values()[ordinal() + 1];
        }
    }
    
    public Double timer;
    
    public abstract Color getColor();
    public abstract void change();
    
    public Double getTimer() {
        return timer;
    }

    public void setTimer(Double timer) {
        this.timer = timer;
    }
}
