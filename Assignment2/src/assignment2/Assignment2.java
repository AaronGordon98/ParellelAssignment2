/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package assignment2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
*/
/**
 *
 * @author Aaron.gordon
 *
public class Assignment2 
{


    public static void main(String[] args) {
        // TODO code application logic here
        String sentence; 
        String modifiedSentence; 

        BufferedReader inFromUser = 
          new BufferedReader(new InputStreamReader(System.in)); 

        try
        {
            Socket clientSocket = new Socket("hostname", 6789); 
            
            DataOutputStream outToServer = 
                    new DataOutputStream(clientSocket.getOutputStream()); 
            
            BufferedReader inFromServer = 
                new BufferedReader(new
                InputStreamReader(clientSocket.getInputStream())); 

            sentence = inFromUser.readLine(); 

            outToServer.writeBytes(sentence + '\n'); 

            modifiedSentence = inFromServer.readLine(); 

            System.out.println("FROM SERVER: " + modifiedSentence); 

            clientSocket.close(); 

        }  catch(Exception e)
        {
            
        }
        

        

    }
    
}
*/