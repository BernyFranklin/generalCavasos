package com.cis055;

import java.util.*;
import java.util.Arrays;

// This class creates a user menu and the functions involved to use it
public class Menu {
    
    // Attributes
    private Scanner input;

    // Constructor
    public Menu() {
        // Set attricbutes
        this.input = new Scanner(System.in);
    }

    // print() function
    public void print() {
        printLine();
        System.out.println("General Cavasos Command App");
        printLine();
        printOptions('i', "Issue a command");
        printOptions('l', "List all commands");
        printOptions('u', "Undo last command");
        printOptions('r', "Redo last command");
        printOptions('q', "Quit");
        printLine();
    }

    // printCommand function formats a string to display the menu options
    private static void printOptions(Character command, String description) {
        System.out.printf("%s\t%s\n", command, description);
    }
    // printLine function prints a line of 40 dashes
    private static void printLine() {
        System.out.println("----------------------------------------");
    }

    // getCommand gets a character and evaluates if valid selection
    public Character getCommand() {
        // Initialize flag for loop
        boolean goodInput = false;
        Character command = '_';
        
        // Enter loop until valid 
        while (!goodInput) {
            // Prompt for input
            System.out.print("Enter a command: ");
            // Read it
            String rawInput = input.nextLine();
            // Convert to lower
            if (rawInput.length() > 0) {
                rawInput = rawInput.toLowerCase();
                command = rawInput.charAt(0);
            }
            // Send for validation
            goodInput = validateCommand(command);
            // Flag for invalid input
            if (!goodInput) {
                System.out.printf("\nInvalid selection, please try again\n\n");
            }
        }   // End of loop
        // Return valid char
        return command;
    }

    // validateCommand crosses input versus valid menu options
    private static boolean validateCommand(Character userInput) {
        // Return Value
        boolean isValid = false;
        // Valid options
        Character[] options = {'i', 'l', 'u', 'r', 'q'};
        // Crosscheck input 
        for (int i = 0; i < options.length ; i++) {
            if (userInput == options[i]) {
                isValid = true;
                break;
            }
        }
        // Return results
        return isValid;
    }
}
