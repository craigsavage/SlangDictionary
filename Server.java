import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(7325)) {
            System.out.println("Starting Server!");
            
            // Initializes a new Slang Dictionary 
            SlangDictionary dict = new SlangDictionary();
            
            while(true) {
                new ServerHandler(serverSocket.accept(), dict).start();
                System.out.println("Client Connected");
            }
        } catch(IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
