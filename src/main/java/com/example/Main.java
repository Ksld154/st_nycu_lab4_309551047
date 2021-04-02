package com.example;

import java.util.Scanner;
import com.example.Game;

public class Main {

    private static String getUserInput(int userIndex) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter Player %d choice (rock, paper or scissors): \n", userIndex);
        String userInput = scanner.nextLine();

        return userInput;
    }

    public static void main (String[] args) {
        Game game = new Game();
        System.out.println("=== Welcome to Rock-Paper-Scissors game ===");

        // User1
        String user1Input = getUserInput(1);
        game.inputChecker(user1Input);

        // User2
        String user2Input = getUserInput(2);
        game.inputChecker(user2Input);

        String result = game.start(user1Input, user2Input);
        System.out.println(result);
    }
}
