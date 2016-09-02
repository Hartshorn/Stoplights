package com.ge.proto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Details {
    
    public enum Type { Car, Truck, Semi, SmartCar, Hybrid;
    
        private static final List<Type> VALUES = 
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();
        
        public static Type randomVehicleType() {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    };
    
    public enum Color { Red, Blue, Green, Yellow, Orange, Pink, Rusty;
    
        private static final List<Color> VALUES = 
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();
        
        public static Color randomColor() {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    };
    
    public enum Size { Small, Medium, Large;
    
        private static final List<Size> VALUES = 
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();
        
        public static Size randomSize() {
            return VALUES.get(RANDOM.nextInt(SIZE));
        } 
    };
    
    public enum Speed { Stopped {
                            @Override
                            public Speed slowDown() {
                                return Stopped;
                            };
                        }, 
                        Slow, 
                        Careful, 
                        Fast, 
                        Max {
                            @Override
                            public Speed speedUp() {
                              return Max;  
                            };
                        };
        
        public Speed slowDown() {
            return values()[ordinal() - 1];
        }
        
        public Speed speedUp() {
            return values()[ordinal() + 1];
        }
    
        private static final List<Speed> VALUES = 
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();
        
        public static Speed randomSpeed() {
            return VALUES.get(RANDOM.nextInt(SIZE));
        } 
    };
    
    public enum Priority { High, Low;
    
        private static final List<Priority> VALUES = 
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();
        
        public static Priority randomPriority() {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    };
    
    
    
}
