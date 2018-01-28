/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;

/**
 *
 * @author LinaMasoud
 */
public class ChatHandler extends Thread{
    
    BufferedReader br;
    PrintStream ps;
    static Vector<ChatHandler> clientsVector = new Vector<ChatHandler>();

    public ChatHandler(Socket s) throws IOException {
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        ps = new PrintStream(s.getOutputStream());
        clientsVector.add(this);
        start();
    }
    
    public void run(){
        while(true){
            try {
                String msg = br.readLine();
                msgToAll(msg);
            } 
            catch (IOException ex) {
                    ex.printStackTrace();
                try {
                    br.close();
                    ps.close();
                } catch (IOException ex1) {
                    ex1.printStackTrace();
                }
            }       
    }
    }
    public void msgToAll(String str){
            for(ChatHandler ch: clientsVector){
                ch.ps.println();
                ch.ps.println(str);
            }
    }
    
}
