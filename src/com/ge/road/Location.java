package com.ge.road;

import com.ge.proto.Details.Speed;

public class Location {

    private Double value;

    public Location(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return this.value;
    }

    public void incrementValue(Speed speed) {

        switch (speed) {
            case Stopped:
                this.value += 0.1;
                break;
            case Slow:
                this.value += 0.1 * 2;
                break;
            case Careful:
                this.value += 0.1 * 3;
                break;
            case Fast:
                this.value += 0.1 * 5;
                break;
            default:
                break;
        }
        if (this.value > 100.00) {
            this.value = 0.0;
        }
    }
}
