package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int random = rand.nextInt(EnWords.words.length);
        String word = EnWords.words[random];
        char[] stock = new char[word.length()];
        int attempts = 0;

        System.out.println("Welcome to Hangman, no actual hanging involved!\n" +
                "Enter either a character at a time or\n" +
                "the entire word if you can guess it.");

        showWord(stock, word);

        while (true) {
            System.out.println("\nEnter a character: ");
            String input = scanner.next();
            attempts++;
            if (word.contains(input)) {
                for (int i = 0; i < word.length(); i++) {
                    if (word.substring(i, i + 1).equals(input.substring(0, 1))) {
                        stock[i] = input.charAt(0);
                    }
                }
            }
            if (input.length() > 1) {
                if (word.equals(input)) {
                    System.out.println("\nYou guessed after " + attempts + " attempts !");
                    break;
                }
            }
            System.out.println();
            for (int i = 0; i < word.length(); i++) {
                System.out.print(stock[i]);
            }
            if (word.equals(String.valueOf(stock))) {
                System.out.println();
                System.out.println("\nYou guessed after " + attempts + " attempts !");
                break;
            }
        }
    }

    public static void showWord(char[] stock, String word) {
        for (int i = 0; i < word.length(); i++) {
            stock[i] = '_';
            System.out.print(stock[i]);
        }
    }
}