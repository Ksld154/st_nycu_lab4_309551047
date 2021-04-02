package com.example;


public class Game {

    static final String SCISSORS = "scissors";
    static final String ROCK = "rock";
    static final String PAPER = "paper";

    public void inputChecker(String userInput) throws IllegalArgumentException {
        if(!userInput.equals(SCISSORS) && !userInput.equals(ROCK) && !userInput.equals(PAPER)) {
            throw new IllegalArgumentException("Bad input!");
        }

    }

    public String start(String user1Input, String user2Input) {
        if(user1Input.equals(user2Input)) {
            return "Draw!";
        }
        else if ((user1Input.equals(SCISSORS) && user2Input.equals(PAPER)) ||
                (user1Input.equals(ROCK) && user2Input.equals(SCISSORS)) ||
                (user1Input.equals(PAPER) && user2Input.equals(ROCK))) {
            return "Player 1 win!";
        }
        else {
            return "Player 2 win!";
        }
    }
}
