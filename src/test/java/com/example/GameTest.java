package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

import com.example.*;

class GameTest {

    static final String SCISSORS = "scissors";
    static final String ROCK = "rock";
    static final String PAPER = "paper";

    static final String PLAYER1_WIN = "Player 1 win!";
    static final String PLAYER2_WIN = "Player 2 win!";
    static final String DRAW = "Draw!";

    private static Stream<Arguments> allGameResults() {
        return Stream.of(

            // a. Player1 all win cases
            Arguments.of(SCISSORS, PAPER, PLAYER1_WIN),
            Arguments.of(ROCK, SCISSORS, PLAYER1_WIN),
            Arguments.of(PAPER, ROCK, PLAYER1_WIN),

            // b. Player all lose cases
            Arguments.of(SCISSORS, ROCK, PLAYER2_WIN),
            Arguments.of(ROCK, PAPER, PLAYER2_WIN),
            Arguments.of(PAPER, SCISSORS, PLAYER2_WIN),

            // c. all draw cases
            Arguments.of(SCISSORS, SCISSORS, DRAW),
            Arguments.of(ROCK, ROCK, DRAW),
            Arguments.of(PAPER, PAPER, DRAW)
        );
    }

    @ParameterizedTest()
    @MethodSource("allGameResults")
    public void allGameResultsTest(String user1Input, String user2Input, String expected) {
        Game game = new Game();
        String result = game.start(user1Input, user2Input);
        assertEquals(result, expected);
    }


    // d. valid input
    @Test
    public void validInputCases() {
        Game game = new Game();
        String[] validInputs = {SCISSORS, ROCK, PAPER};
        for (String userInput: validInputs) {
            assertDoesNotThrow(()-> game.inputChecker(userInput));
        }
    }


    // d. invalid input
    @Test
    public void invalidInputCases() {
        Game game = new Game();

        String[] invalidInputs = {"peko", "miko", "suisei"};
        for (String userInput: invalidInputs) {
            Exception exception = assertThrows(IllegalArgumentException.class, ()-> game.inputChecker(userInput));

            String expectedMsg = "IllegalArgumentException";
            String actualMsg = exception.toString();
            assertTrue(actualMsg.contains(expectedMsg));
        }
    }
}