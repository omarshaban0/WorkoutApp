package com.patrickbanez.workoutapp.User;

public enum Goal {
    WEIGHT_LOSS ,
    MUSCLE_BUILDING ,
    STRENGTH_BUILDING ,
    MAINTENANCE ;

    @Override
    public String toString() {
        if (this == WEIGHT_LOSS) {
            return "Weight Loss";
        } else if (this == MUSCLE_BUILDING) {
            return "Muscle Building";
        } else if (this == STRENGTH_BUILDING) {
            return "Strength Building";
        } else {
            return "Maintenance";
        }
    }
}
