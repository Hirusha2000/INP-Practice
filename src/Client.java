import java.io.IOException;
import java.net.Socket;

/**
 * @author: Hirusha Geeganage
 * created :6/5/2023--9:27 AM
 **/

public class Client {
 public static void main(String[] args) {


  try {
   System.out.println("Client Started");
   Socket socket= new Socket("localhost",9806);
  } catch (IOException e) {
   e.printStackTrace();// prashnayak aawoth eka screen eke display kara ganna puluwan
  }

 }
}
