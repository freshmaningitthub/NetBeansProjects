/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author my
 */
public class Myserver {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    static DataInputStream dataFromClient = null;
    static DataOutputStream dataToClient = null;

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ServerJFrame sjf = new ServerJFrame();
        sjf.show();
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket socket = serverSocket.accept();
        dataFromClient = new DataInputStream(socket.getInputStream());
        dataToClient = new DataOutputStream(socket.getOutputStream());
        try {
            //System.out.println(dataFromClient.readUTF());
            while (true) {
                ServerJFrame.serverMessageArea.append("Client:"+dataFromClient.readUTF()+'\n');
                // dataToClient.writeUTF("From Server");
            }
        } catch (IOException ex) {
            Logger.getLogger(Myserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        // dataToClient.writeChar('S');
    }

}
