/*
// Set class to hold set info
*/

package com.patrickbanez.workoutapp.Workout;

public class Set {
    private double weight;
    private int reps;

    public Set(int reps, double weight) {
        this.reps = reps;
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps){
        this.reps = reps;
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }
}