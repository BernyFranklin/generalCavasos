package com.cis055;

import java.util.Random;
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

  public static void main(String[] args) {
    //String fileName =
    //  "/Users/frankbernal/Documents/GitHub/sjccFall22/generalCavasos/src/generalcavasos/src/main/java/com/cis055/commands.json";

    // read coammands
    //JSONArray commandJSONArray = JSONFile.readArray(fileName);
    //String[] commandArray = getCommandArray(commandJSONArray);
   // System.out.println(commandArray);

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

    //System.out.println(
    //  "----- Issuing 5 random commands from General Cavazos -----"
    //);
    //randomCommand(commandArray, 5);
  }   // End of main Program

  // randomly issue commands from General Cavazos
  public static void randomCommand(String[] commandArray) {
    Random rand = new Random();
    int randIndex = rand.nextInt(commandArray.length);
    commandHistory.push(commandArray[randIndex]);
    System.out.printf("[General Cavasos]: \"%s!\"\n", commandArray[randIndex]);
  }

  // print command array
  public static void print(String[] commandArray) {
    System.out.printf("Number\tCommand\n");
    System.out.printf("------\t---------------\n");
    for (int i = 0; i < commandArray.length; i++) {
      System.out.printf("%04d\t%s\n", i, commandArray[i]);
    }
  }

  // get array of commands
  public static String[] getCommandArray(JSONArray commandArray) {
    String[] arr = new String[commandArray.size()];

    // get names from json object
    for (int i = 0; i < commandArray.size(); i++) {
      String command = commandArray.get(i).toString();
      arr[i] = command;
    }
    return arr;
  }

  // Execute commands
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
        System.out.printf("\nThank you General Cavasos!\n\n");
        break;
      default:
        System.out.println("Unknown Selection");
        break;
    }
  }

  // bigLine prints a line that's 40 dashes
  private static void bigLine() {
    System.out.println("----------------------------------------");
  }

  // header prints a header
  private static void header(String commandHeader) {
    bigLine();
    System.out.printf("\t%s\n", commandHeader);
    bigLine();
  }

  // undoLastCommand() removes the last command and tells the user
  private static void undoLastCommand() {
    // Pop the last command
    String undoCommand = commandHistory.pop();
    // If empty alert user
    if (commandHistory.empty()) {
      System.out.printf("\n[General Cavasos]: \"There are no more orders to undo\"");
    }
    // Print the order to undo
    else {
    System.out.printf("\n[General Cavasos]: \"Belay the last order: %s\"\n", undoCommand);
    }
  }

  // redoLastCommand() repeats the last command made
  private static void redoLastCommand() {
    String repeatCommand = commandHistory.peek();
    if (commandHistory.empty()) {
      System.out.printf("\n[General Cavasos]: \"There are no orders to repeat\"");
    }
    else {
      System.out.printf("\n[General Cavasos]: \"Repeat: %s\"", repeatCommand);
    }
  }
}

  