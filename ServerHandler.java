import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerHandler extends Thread {
    private Socket socket;
    private SlangDictionary dictionary;

    public ServerHandler(Socket socket, SlangDictionary dict) {
        this.socket = socket;
        this.dictionary = dict;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            String response;
            String wordToFind;
            String wordToAdd, definitionToAdd;

            while(true) {
                // Contains the user's operation choice
                String option = input.readLine();

                // Navigates user to the proper case depending on which they picked
                switch (option.toLowerCase()) {
                    case "random":
                        // Prints out a random slang from the dictionary
                        response = dictionary.getRandomSlang();
                        output.println(response);
                        break;

                    case "search":
                        // Saves the user's search term 
                        wordToFind = input.readLine();

                        // Finds a specific slang word from the dictionary
                        response = dictionary.findSlang(wordToFind);
                        output.println(response);
                        break;

                    case "add":
                        // Gets the word and definition to be added
                        wordToAdd = input.readLine();
                        definitionToAdd = input.readLine();

                        // Adds new user inputted slang to the slang dictionary
                        response = dictionary.addItem(wordToAdd, definitionToAdd);
                        output.println(response);
                        break;

                    case "remove":
                        // Gets the word to be deleted
                        String wordToRemove = input.readLine();

                        // Removes the user inputted slang
                        response = dictionary.removeSlang(wordToRemove);
                        output.println(response);
                        break;

                    case "print":
                        // Sends the entire slang dictionary with the title as one long string separated by pipes
                        String dictionaryTitle = "Slang Dictionary (Updated)|--------------------------|";
                        String entireSlangDictionary = dictionary.getSlangDictionary();
                        output.println(dictionaryTitle + entireSlangDictionary);
                        break;

                    case "exit":
                        // break out of switch
                        break;

                    default:
                        System.out.println("Not a valid entry, exiting");
                }
                
                // Break out of while loop if user inputted exit
                if (option.equals("exit")) { break; }
            }

            // Close I/O streams
            input.close();
            output.close();

        } catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}