import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author: Hirusha Geeganage
 * created :6/5/2023--11:25 AM
 **/

public class ChatClient {

    BufferedReader in;
    PrintWriter out;

    JFrame  frame = new JFrame("The Chatter");
    JTextField textField =new JTextField(40);
    JTextArea messageArea = new JTextArea(8,40);


    public ChatClient(){
        textField.setEditable(false);
        messageArea.setEditable(false);
        frame.getContentPane().add(textField,"North");
        frame.getContentPane().add(new JScrollPane(messageArea),"Center");
        frame.pack();


        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                out.println(textField.getText());
                textField.setText("");

            }
        });


    }

    private String getServerAddress (){

        return JOptionPane.showInputDialog(
                frame,
                "Enter the Ip Address of the server :",
                "Welcome to the Chatter by Hirusha",
                JOptionPane.QUESTION_MESSAGE
        );
    }

private String getName(){

        return JOptionPane.showInputDialog(
                frame,
                "Enter Your Name",
                "Welcome to the chatter",
                JOptionPane.QUESTION_MESSAGE
        );
}


private void Run() throws IOException {

        String ServerAddress = getServerAddress();
    Socket socket = new Socket( getServerAddress(),9001);

    in =new BufferedReader(new InputStreamReader(socket.getInputStream()));

    out=new PrintWriter(socket.getOutputStream(),true);



    while (true){
        String line=in.readLine();

        if (line.startsWith("SUBMITNAME")) {
            out.println(getName());
        } else if (line.startsWith("NAMEACCEPTED")) {
            textField.setEditable(true);
        } else if (line.startsWith("MESSAGE")){
            messageArea.append(line.substring(8) + "\n");
        }
    }
}


    public static void main(String[] args)  throws Exception{

        ChatClient client = new ChatClient();
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(true);
       /* client.run();*/

    }


}
