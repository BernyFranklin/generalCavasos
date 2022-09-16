package com.cis055;
/*
 * GeneralCavasos
 * Frank Bernal
 * CIS-055
 * Date Started: 15 Sep 2022
 * Date Finished: 15 Sep 2022
 */

import org.json.simple.*;
import java.util.*;

public class CavazosExample {
  // Constants for class
  public static String fileName =
      "/Users/frankbernal/Documents/GitHub/sjccFall22/generalCavasos/src/generalcavasos/src/main/java/com/cis055/commands.json";

  // used to read commands into array
  public static JSONArray commandJSONArray = JSONFile.readArray(fileName);
  public static String[] commandArray = getCommandArray(commandJSONArray);
  // Empty stack
  public static Stack<String> commandHistory = new Stack<String>();

  // Main Program
  public static void main(String[] args) {
    // Create Menu object
    Menu appMenu = new Menu();

    // Initialize command
    char command = '_';
    // Loop menu until quit
    while (command != 'q') {
      appMenu.print();
      command = appMenu.getCommand();
      executeCommand(command);
    }
  }   // End of main Program

  // ------------This is the start of all class functions------------------

  // randomCommand() randomly issue commands from General Cavazos
  public static void randomCommand(String[] commandArray) {
    // New instance of Random
    Random rand = new Random();
    // Get an index between 0 and length
    int randIndex = rand.nextInt(commandArray.length);
    // Add command to stack
    commandHistory.push(commandArray[randIndex]);
    // Print Command for user
    System.out.printf("[General Cavazos]: \"%s!\"\n", commandArray[randIndex]);
  }

  // print() prints command array
  public static void print(String[] commandArray) {
    // Print a small header and all commands available
    System.out.printf("Number\tCommand\n");
    System.out.printf("------\t---------------\n");
    // Loop used to iterate through all commands
    for (int i = 0; i < commandArray.length; i++) {
      System.out.printf("%04d\t%s\n", i, commandArray[i]);
    }
  }

  // getCommandArray() gets array of commands by reading the JSON object
  public static String[] getCommandArray(JSONArray commandArray) {
    String[] arr = new String[commandArray.size()];

    // get names from json object
    for (int i = 0; i < commandArray.size(); i++) {
      String command = commandArray.get(i).toString();
      arr[i] = command;
    }
    return arr;
  }

  // executeCommand() uses a switch case to perform the commands
  public static void executeCommand(Character command) {
    switch (command) {
      case 'i':
        header("A command has been issued");
        randomCommand(commandArray);
        break;
      case 'l':
        header("List of all commands");
        print(commandArray);
        break;
      case 'u':
        header("Undo last command");
        undoLastCommand();
        break;
      case 'r':
        header("Redo last command");
        redoLastCommand();
        break;
      case 'q':
        System.out.printf("\nThank you General Cavazos!\n\n");
        break;
      default:
        System.out.println("Unknown Selection");
        break;
    }
  }

  // bigLine() prints a line that's 40 dashes
  private static void bigLine() {
    System.out.println("----------------------------------------");
  }

  // header() prints a header for the command selected
  private static void header(String commandHeader) {
    bigLine();
    System.out.printf("\t%s\n", commandHeader);
    bigLine();
  }

  // undoLastCommand() removes the last command and tells the user
  private static void undoLastCommand() {
    // If stack is empty
    if (commandHistory.empty()) {
      System.out.printf("\n[General Cavazos]: \"There are no more orders to undo\"\n");
    }
    // Pop the last command
    else {
      String undoCommand = commandHistory.pop();
      // Print the command to undo
      System.out.printf("\n[General Cavazos]: \"Belay the last order: %s!\"\n", undoCommand);
    }
  }

  // redoLastCommand() repeats the last command made
  private static void redoLastCommand() {
    // If none tell the user
    if (commandHistory.empty()) {
      System.out.printf("\n[General Cavazos]: \"There are no orders to repeat\"\n");
    }
    else {
      // Peek at the last command entered
      String repeatCommand = commandHistory.peek();
      // Otherwise, repeat
      System.out.printf("\n[General Cavazos]: \"Repeat: %s!\"\n", repeatCommand);
    }
  }
} // End of Cavazos

  