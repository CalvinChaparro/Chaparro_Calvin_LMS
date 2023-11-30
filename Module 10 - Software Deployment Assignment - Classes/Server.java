package chapter33;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server extends Application {
  @Override
  public void start(Stage primaryStage) {
    // Text area for displaying contents
    TextArea ta = new TextArea();

    // Create a scene and place it in the stage
    Scene scene = new Scene(new ScrollPane(ta), 450, 200);
    primaryStage.setTitle("Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    new Thread(() -> {
      try {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8000);
        Platform.runLater(() ->
                ta.appendText("Server started at " + new Date() + '\n'));

        // Listen for a connection request
        Socket socket = serverSocket.accept();

        // Create data input and output streams
        DataInputStream inputFromClient = new DataInputStream(
                socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(
                socket.getOutputStream());

        while (true) {
          // Receive number from client
          int number = inputFromClient.readInt();

          // Check if number is prime
          boolean isPrime = isPrime(number);

          // Send result back to client
          outputToClient.writeBoolean(isPrime);

          Platform.runLater(() -> {
            ta.appendText("Number received from client: "
                    + number + '\n');
            ta.appendText("Is Prime? " + (isPrime ? "Yes" : "No") + '\n');
          });
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }).start();
  }

  public static void main(String[] args) {
    launch(args);
  }

  // This helper method checks if a number is prime
  private static boolean isPrime(int number) {
    if (number <= 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
