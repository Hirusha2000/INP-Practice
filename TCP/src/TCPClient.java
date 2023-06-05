import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author: Hirusha Geeganage
 * created :6/5/2023--9:36 AM
 **/

public class TCPClient {
 public static void main(String[] args) throws IOException {


  String sentence;
  String modifiedSentence;

  BufferedReader fromUser= new BufferedReader(new InputStreamReader(System.in));

  Socket socket =new Socket("localhost",9806);
  System.out.println("Enter a string");
  DataOutputStream outtoServer =new DataOutputStream(socket.getOutputStream());

  BufferedReader infromserver= new BufferedReader(new InputStreamReader(socket.getInputStream()));


  sentence=fromUser.readLine();
  outtoServer.writeBytes(sentence +'\n');

  modifiedSentence=infromserver.readLine();
  System.out.println(" From Server =" + modifiedSentence);
  socket.close();
 }
}
