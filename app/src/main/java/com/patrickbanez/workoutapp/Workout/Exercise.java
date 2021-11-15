/*
// Exercise class to hold info for exercises
// Uses an underlying ExerciseAmount ArrayList for sets
*/

package com.patrickbanez.workoutapp.Workout;

import java.util.Iterator;
import java.util.*;

public class Exercise implements Iterable<Set> {
    private String name;
    private String helpInfo;
    private ArrayList<Set> sets;
    private int calories;
    //need to find/create a class to hold the time
    private int duration;
    private int caloriesPerRep;

    public Exercise(String name, int caloriesPerRep) {
        this.caloriesPerRep = caloriesPerRep;
        this.name = name;
        helpInfo = "";
        calories = 0;
        duration = 0;
        sets = new ArrayList<Set>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHelp(String helpInfo) {
        this.helpInfo = helpInfo;
    }

    public String getHelp() {
        return helpInfo;
    }

    public int getCalories() {
        return calories;
    }

    public int getDuration() {
        return duration;
    }

    public boolean removeSetAt(int index) {
        return (sets.remove(index) != null);
    }

    public boolean addSet(int reps, double weight) {
        //add calories & duration
        //inaccurate testing math below
        calories += caloriesPerRep * reps;
        duration += reps * 5;
        return sets.add(new Set(reps, weight));
    }

    public Set getSet(int index) {
        return sets.get(index);
    }

    public SetIterator iterator() {
        return new SetIterator(this);
    }

}

class SetIterator implements Iterator<Set> {
    private int currentIndex = 0;
    private Exercise exercise;

    public SetIterator(Exercise exercise) {
        this.exercise = exercise;
    }

    public boolean hasNext() {
        return (exercise.getSet(currentIndex + 1) != null);
    }

    public Set next() {
        Set set = exercise.getSet(currentIndex);
        currentIndex++;
        return set;
    }
}