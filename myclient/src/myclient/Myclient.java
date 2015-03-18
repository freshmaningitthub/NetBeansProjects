/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author my
 */
public class Myclient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Socket socket=new Socket("localhost",8000);
         DataInputStream dataFromServer=new DataInputStream(socket.getInputStream());
        DataOutputStream dataToServer=new DataOutputStream(socket.getOutputStream());
       //dataToServer.writeChar('C');
       dataToServer.write("From Client.".getBytes());
        System.out.println(dataFromServer.read());
        
    }
    
}
