package com.ordigraphe.day2;

public enum Hand {
    ROCK(1),
    PAPER(2),
    SCISSOR(3);

    private final Integer score;

    Hand(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }
}
