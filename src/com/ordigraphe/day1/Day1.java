package com.ordigraphe.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Day1 {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here


        List<Elf> elves = new ArrayList<>();

        try {
            List<String> allLines = Files.readAllLines(Paths.get("input1.txt"));

            Elf elf = new Elf();
            for (String line : allLines) {
                if (line.isEmpty()) {
                    elves.add(elf);
                    elf = new Elf();
                } else {
                    elf.addCalories(Integer.valueOf(line));
                }
            }
            elves.add(elf);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(findElfWithMoreCalories(elves));
        System.out.println(findTop3ElvesCalories(elves));

    }

    private static Integer findElfWithMoreCalories(List<Elf> elves) {

        return elves.stream().mapToInt(Elf::getNumberOfCalories).max().orElseThrow(NoSuchElementException::new);
    }

    private static Integer findTop3ElvesCalories(List<Elf> elves) {
        elves.sort(Comparator.comparing(Elf::getNumberOfCalories).reversed());
        return elves.stream().limit(3).mapToInt(Elf::getNumberOfCalories).sum();
    }


}
