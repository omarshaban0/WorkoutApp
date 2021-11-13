package com.patrickbanez.workoutapp.User;

public class User {
    private String firstName, lastName, email;
    private String uid;
    private int heightFt, heightIn, age;
    private double weight;
    private Goal goal;

    // User cannot be created without a first name, last name, email, goal, and uid.
    private User(){};

    // First name, last name, email, and uid are required when creating a user.
    /**
     * Initializes required fields to given parameters and initializes optional fields to 0.
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param uid generated from CreateUserActivity
     */
    public User(String firstName, String lastName, String email, Goal goal, String uid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.goal = goal;
        this.uid = uid;
        age = 0;
        heightFt = 0;
        heightIn = 0;
        weight = 0.0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getHeightFt() {
        return heightFt;
    }

    public void setHeightFt(int heightFt) {
        this.heightFt = heightFt;
    }

    public int getHeightIn() {
        return heightIn;
    }

    public void setHeightIn(int heightIn) {
        this.heightIn = heightIn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public Goal getGoal() {
        return goal;
    }
}
