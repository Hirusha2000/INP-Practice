import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;

/**
 * @author: Hirusha Geeganage
 * created :6/5/2023--10:27 AM
 **/

public class ChatServer {

 private static final int PORT=9001;
public static HashSet<String> names= new HashSet<String>();

public static HashSet<PrintWriter> writers =new HashSet<PrintWriter>();

    public static void main(String[] args) {

    }

    private static class Handler implements Runnable {

        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;


        public Handler (Socket socket){
            this.socket=socket;
        }

        public  void run(){

            try {
                in= new BufferedReader(new InputStreamReader(socket.getInputStream()));

                out=new PrintWriter(socket.getOutputStream(),true);

                while (true) {
out.println("SubmitName");
name=in.readLine();

if (name==null){
    return;
}
if (!names.contains(name)) {
names.add(name);
    break;
}

out.println("Names Accepted");
writers.add(out);


              while (true){


                  String input=in.readLine();
                  if(input==null){
                      return;
                  }
                  for( PrintWriter writer :writers){
                      writer.println("Message" +name +":" +input);
                  }
              }


                }

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e);
            } finally {
                if (names!=null) {
                    names.remove(name);
                }
                if (out!=null) {
                    writers.remove(out);
                }

                try {
                    socket.close();
                } catch (IOException e){

                }
            }
        }

    }


}
