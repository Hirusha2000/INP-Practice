import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: Hirusha Geeganage
 * created :6/5/2023--9:15 AM
 **/

public class Server {
 public static void main(String[] args) {


  try {
   System.out.println("waiting for client requests");
   ServerSocket serverSocket = new ServerSocket(9806);
   Socket socket =serverSocket.accept(); //
  } catch (IOException e) {
   e.printStackTrace();
  }
 }
}
