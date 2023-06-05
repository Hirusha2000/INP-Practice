import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

/**
 * @author: Hirusha Geeganage
 * created :6/5/2023--9:37 AM
 **/

public class TCPClient {
 public static void main(String[] args) throws IOException {


  String clientSentence;
  String capitalizedSentence;

  System.out.println("Waiting for clients");

  ServerSocket serverSocket = new ServerSocket(9806);

  while (true){

   Socket socket = serverSocket.accept();
   System.out.println("Connection is established");
   System.out.println("Getting client data");


   // to read the string that sent by client
   BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream())); // bufferader type object ekakata data da gatta

   DataOutputStream outToClient= new DataOutputStream(socket.getOutputStream());


   clientSentence=fromClient.readLine();
   capitalizedSentence=clientSentence.toUpperCase()+'\n';

   outToClient.writeByte(Integer.parseInt(capitalizedSentence));
  }
 }


}
