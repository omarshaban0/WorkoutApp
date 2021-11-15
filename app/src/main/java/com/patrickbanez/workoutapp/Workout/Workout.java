/*
// Workout class to hold workout info
// Uses an underlying ArrayList to hold the exercises
*/

package com.patrickbanez.workoutapp.Workout;

import java.util.Iterator;
import java.util.*;

class Workout implements Iterable<Exercise> {
    private final int MAX_EXERCISES = 100;
    private ArrayList<Exercise> exercises;
    private String workoutType;
    private String name;
    private String description;

    public Workout() {
        this.name = "";
        description = "";
        workoutType = "";
        exercises = new ArrayList<Exercise>();
    }

    public boolean addExercise(Exercise e) {
        if(exercises.size() >= MAX_EXERCISES) {
            return false;
        }
        return exercises.add(e);
    }

    public boolean removeExercise(String name) {
        for(Exercise e: exercises) {
            if(e.getName().equals(name)) {
                exercises.remove(e);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(int index) {
        return exercises.get(index);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setWorkoutType(String type) {
        this.workoutType = type;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public int getCalories() {
        //loops through arraylist and adds all calories together and returns sum
        int calories = 0;
        for (Exercise e : exercises) {
            calories += e.getCalories();
        }
        return calories;
    }

    public int getDuration() {
        //loops through arraylist and adds all durations together and returns sum
        int duration = 0;
        for (Exercise e : exercises) {
            duration += e.getDuration();
        }
        return duration;
    }

    public WorkoutIterator iterator() {
        return new WorkoutIterator(this);
    }
}

class WorkoutIterator implements Iterator<Exercise> {
    private int currentIndex = 0;
    private Workout workout;

    public WorkoutIterator(Workout workout) {
        this.workout = workout;
    }

    public boolean hasNext() {
        return (workout.getExercise(currentIndex + 1) != null);
    }

    public Exercise next() {
        Exercise e = workout.getExercise(currentIndex);
        currentIndex++;
        return e;
    }
}