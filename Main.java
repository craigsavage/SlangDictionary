package SlangDictionary;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to Slang Dictionary!");

        // Creates a new Slang Dictionary object
        SlangDictionary dictionary = new SlangDictionary();

        // Prints out a random slang from the dictionary
        dictionary.getRandomSlang();

//        // Add new user inputted slang
//        dictionary.addItem(createSlang());
//
//        // Print out the entire slang dictionary
//        dictionary.printSlangDictionary();
    }

    public static Slang createSlang() {
        Scanner in = new Scanner(System.in);

        // Get new user inputted slang and add it to the dictionary
        System.out.print("Enter a new slang word: ");
        String newSlangWord = in.nextLine();

        System.out.print("Enter a definition for your word: ");
        String newSlangDefinition = in.nextLine();

        return new Slang(newSlangWord, newSlangDefinition);
    }
}
