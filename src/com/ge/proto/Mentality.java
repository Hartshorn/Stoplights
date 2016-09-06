package com.ge.proto;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Mentality {
    
    public enum Mood { Happy, Indifferent, Sad;
    
        private static final List<Mood> VALUES = 
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();
        
        public static Mood randomMood() {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    };
    
    public enum Bravery { Brave, Cautious, Scared;
    
        private static final List<Bravery> VALUES = 
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();
        
        public static Bravery randomBravery() {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    };
    
    public enum Honor { Honorable, Dishonorable;
    
        private static final List<Honor> VALUES = 
                Collections.unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();
        
        public static Honor randomHonor() {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    };
}
