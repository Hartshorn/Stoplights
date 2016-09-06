package com.ge.proto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
        
        private static final List<Light.Color> VALUES = 
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();
        
        public static Light.Color randomColor() {
            return VALUES.get(RANDOM.nextInt(SIZE));
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
