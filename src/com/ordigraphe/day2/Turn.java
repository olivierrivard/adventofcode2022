package com.ordigraphe.day2;

public class Turn {
    private Hand opponentPlay;
    private Hand yourPlay;
    private Integer score;

    public Turn(Hand opponentPlay, Hand yourPlay) {
        this.opponentPlay = opponentPlay;
        this.yourPlay = yourPlay;
        this.score = 0;
        this.calculateScore();
    }

    private void calculateScore() {

        score+= yourPlay.getScore();
        switch (opponentPlay) {
            case ROCK:
                if (yourPlay.equals(Hand.PAPER)) {
                    score+=6;
                }
                if (yourPlay.equals(Hand.ROCK)) {
                    score+=3;
                }
                break;
            case PAPER:
                if (yourPlay.equals(Hand.SCISSOR)) {
                    score+=6;
                }
                if (yourPlay.equals(Hand.PAPER)) {
                    score+=3;
                }
                break;
            case SCISSOR:
                if (yourPlay.equals(Hand.ROCK)) {
                    score+=6;
                }
                if (yourPlay.equals(Hand.SCISSOR)) {
                    score+=3;
                }
                break;
        }
    }

    public Hand getOpponentPlay() {
        return opponentPlay;
    }

    public Hand getYourPlay() {
        return yourPlay;
    }

    public Integer getScore() {
        return score;
    }
}
