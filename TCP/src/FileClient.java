import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) {
        new FileClient();
    }

    public FileClient() {
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter IP address of the server:");
            String serverAddress = bufReader.readLine();
            Socket clientSocket = new Socket(serverAddress, 8000);
            System.out.println("Connecting to Server. ");

            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            System.out.println("Enter File Name:");
            String fileName = bufReader.readLine();
            output.writeUTF(fileName);

            String echoedFile = input.readUTF();
            System.out.println(" ");
            System.out.println("Content of a File:\n\n" + echoedFile);
            System.out.println(" ");

            clientSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
