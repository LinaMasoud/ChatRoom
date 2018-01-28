/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author LinaMasoud
 */
public class ComplexServer extends Thread{

    /**
     * @param args the command line arguments
     */
    ServerSocket ss;
    Socket s;
    
    public ComplexServer() throws IOException{
        ss = new ServerSocket(5550);
        start();
    }
    
    @Override
    public void run(){
      while(true){
            try {
                s = ss.accept();
                new ChatHandler(s);
            } 
            catch (IOException ex) {
              ex.printStackTrace();
            } 
        }    
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new ComplexServer();
    }
    
}
