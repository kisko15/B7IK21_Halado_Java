package org.example;

public class Teacher implements PersonChecker{

    private String name;
    private int age;
    private float wordInMinutes;

    private static final double MAXIMUM_WORD_IN_MINUTES = 100;

    public Teacher(String name, int age, float wordInMinutes) {
        this.name = name;
        this.age = age;
        this.wordInMinutes = wordInMinutes;
    }

    @Override
    public boolean isOk() {
        return wordInMinutes < MAXIMUM_WORD_IN_MINUTES;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", wordInMinutes=" + wordInMinutes +
                '}';
    }
}
