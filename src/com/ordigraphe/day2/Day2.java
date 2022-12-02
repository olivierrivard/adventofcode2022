package com.ordigraphe.day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static void main(String[] args) {


        List<Turn> turns = new ArrayList<>();

        try {
            List<String> allLines = Files.readAllLines(Paths.get("input2.txt"));

            for (String line : allLines) {

                Hand opponentPlay;
                switch (line.charAt(0)) {
                    case 'A':
                        opponentPlay = Hand.ROCK;
                        break;
                    case 'B':
                        opponentPlay = Hand.PAPER;
                        break;
                    default:
                        opponentPlay = Hand.SCISSOR;
                        break;
                }

                Hand yourPlay;
                switch (line.charAt(2)) {
                    case 'X':
                        yourPlay = getLosingValue(opponentPlay);
                        break;
                    case 'Y':
                        yourPlay = opponentPlay;
                        break;
                    default:
                        yourPlay = yourPlay = getWinningValue(opponentPlay);;
                        break;

                }

                turns.add(new Turn(opponentPlay, yourPlay));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(turns.stream().mapToInt(Turn::getScore).sum());
        System.out.println();


    }

    public static Hand getLosingValue(Hand opponentHand) {
        switch (opponentHand) {
            case ROCK:
                return Hand.SCISSOR;
            case SCISSOR:
                return Hand.PAPER;
            default:
                return Hand.ROCK;
        }
    }

    public static Hand getWinningValue(Hand opponentHand) {
        switch (opponentHand) {
            case ROCK:
                return Hand.PAPER;
            case SCISSOR:
                return Hand.ROCK;
            default:
                return Hand.SCISSOR;
        }
    }
}
