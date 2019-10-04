import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 7325)) {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            
            Scanner in = new Scanner(System.in);
            String userInput;
            String response;
            
            System.out.println("\n--------------------------------");
            System.out.println("| Welcome to Slang Dictionary! |");
            System.out.println("--------------------------------\n");
            
            do {
                System.out.println("Enter one of the following options: ");
                System.out.println("\"Random\" - Prints out a random slang from the dictionary.");
                System.out.println("\"Search\" - Finds a specific slang word from the dictionary.");
                System.out.println("\"Add\" - Adds new user inputted slang.");
                System.out.println("\"Remove\" - Removes a slang from the dictionary.");
                System.out.println("\"Print\" - Prints out the entire slang dictionary.");
                System.out.println("\"Exit\" - Close program.");
                
                // Get user input then send it to the server
                userInput = in.nextLine().toLowerCase();
                output.println(userInput);

                if(userInput.equals("search") || userInput.equals("remove") || (userInput.equals("add"))) {
                    System.out.println("Enter word: ");

                    // This allows for an extra input so that user may add a word now and definition after if statement
                    if(userInput.equals("add")) {
                        
                        // Get word to send to server
                        userInput = in.nextLine();
                        output.println(userInput);

                        System.out.println("Enter definition: ");
                    }

                    // Get word to send to server
                    userInput = in.nextLine();
                    output.println(userInput);                 

                    // Get found word (if found) else nothing fonund back from the server
                    response = input.readLine();

                    prettyPrint(response);
                }
                else if(!userInput.equals("exit")) {
                    response = input.readLine();
                    prettyPrint(response);
                }
            } while (!userInput.equals("exit"));
            
            // Close all I/O classes
            input.close();
            output.close();
            in.close();

        } catch(IOException e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }

    /**
     * prettyPrint() is used to print out a formatted version of a phrase.
     * @param phrase the phrase to be formatted.
     */
    public static void prettyPrint(String phrase) {
        
        // Replaces all pipe characters in the string with a new line character
        phrase = phrase.replace("|", "\n");

        System.out.println("\n--------------------------");
        System.out.println(phrase);
        System.out.println("--------------------------\n");
    }
}
