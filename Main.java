package SlangDictionary;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to Slang Dictionary!");

        // Initialize an ArrayList for storing new slang
        ArrayList<Slang> slangDictionary = new ArrayList<>();

        // Add the new slang to the dictionary (Manually to start populating dictionary)
        slangDictionary.add(new Slang("Facts", "used to say that something is true."));
        slangDictionary.add(new Slang("Roadman", "a young adult boy that deals drugs, smokes weed, does robberies, etc... "));

        // Get new user inputted slang and add it to the dictionary
        System.out.print("Enter a new slang word: ");
        String newSlangWord = in.nextLine();
        System.out.print("Enter a definition for your word: ");
        String newSlangDefinition = in.nextLine();

        // Add new user inputted slang
        slangDictionary.add(new Slang(newSlangWord, newSlangDefinition));

        // Print out the entire slang dictionary
        printSlangDictionary(slangDictionary);
    }

    public void createSlang() {
//        Scanner in = new Scanner(System.in);
    }

    /**
     * Prints out every slang in the dictionary (so far)
     * @param slangs used to store the current slang object to be printed.
     */
    public static void printSlangDictionary(ArrayList<Slang> slangs) {
        System.out.println("\nSlang Dictionary (Updated)");
        System.out.println("--------------------------");

        for (Slang slang : slangs) {
            System.out.println(slang);
        }
    }
}
