package com.cis055;

import java.util.Random;
import org.json.simple.*;
import java.util.Scanner;

public class CavazosExample {

  public static void main(String[] args) {
    String fileName =
      "/Users/frankbernal/Documents/GitHub/sjccFall22/generalCavasos/src/generalcavasos/src/main/java/com/cis055/commands.json";

    // read coammands
    JSONArray commandJSONArray = JSONFile.readArray(fileName);
    String[] commandArray = getCommandArray(commandJSONArray);
    System.out.println(commandArray);

    // Create Menu object
    Menu appMenu = new Menu();

    // Initialize command
    char command = '_';

    appMenu.print();
    command = appMenu.getCommand();

    

    
    // print list of all commands
    //System.out.println("----- List of all commands -----");
    //print(commandArray);

    //System.out.println(
    //  "----- Issuing 5 random commands from General Cavazos -----"
    //);
    //randomCommand(commandArray, 5);
  }

  // randomly issue commands from General Cavazos
  public static void randomCommand(String[] commandArray, int numCommand) {
    Random rand = new Random();
    System.out.printf("Number\tCommand\n");
    System.out.printf("------\t---------------\n");
    for (int i = 0; i < numCommand; i++) {
      int randIndex = rand.nextInt(commandArray.length);
      System.out.printf("%04d\t%s\n", i, commandArray[randIndex]);
    }
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
}

  