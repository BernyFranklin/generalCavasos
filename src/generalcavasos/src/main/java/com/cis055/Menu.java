package com.cis055;

import java.util.*;

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
        printCommand('i', "Issue a command");
        printCommand('l', "List all commands");
        printCommand('u', "Undo last command");
        printCommand('r', "Redo last command");
        printCommand('q', "Quit");
        printLine();
    }

    // printCommand function formats a string to display the menu options
    private static void printCommand(Character command, String description) {
        System.out.printf("%s\t%s\n", command, description);
    }
    // printLine function prints a line of 40 dashes
    private static void printLine() {
        System.out.println("----------------------------------------");
    }
}
