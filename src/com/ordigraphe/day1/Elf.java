package com.ordigraphe.day1;

public class Elf implements Comparable<Elf>  {

    private Integer numberOfCalories;

    public Elf() {
        this.numberOfCalories = 0;
    }

    public void addCalories(Integer calories) {
        this.numberOfCalories+= calories;
    }

    public Integer getNumberOfCalories() {
        return numberOfCalories;
    }

    public int compareTo(Elf other) {
        return Integer.compare(this.numberOfCalories, other.numberOfCalories);
    }
}
