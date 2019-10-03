package assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.lang.Runnable;

public class ProxyServer {

    //cache is a Map: the key is the URL and the value is the file name of the file that stores the cached content
    Map<String, String> cache;

    ServerSocket proxySocket;

    String logFileName = "./log.txt";


    public static void main(String[] args) throws Exception {
    	System.out.println("starting");
    	int input = System.in.read();
        ProxyServer server = new ProxyServer();
        server.startServer(input, server);
    }

        void startServer(int proxyPort, ProxyServer server) {

        	cache = new ConcurrentHashMap<>();

            // create the directory to store cached files. 
            File cacheDir = new File("cached");
            if (!cacheDir.exists() || (cacheDir.exists() && !cacheDir.isDirectory())) {
                cacheDir.mkdirs();
            }
            /**
             * To do: create a serverSocket to listen on the port (proxyPort)
             * Create a thread (RequestHandler) for each new client connection
             * remember to catch Exceptions! - done
             *
             */

            try {
            	 //String clientSentence;
                 //String capitalizedSentence;
                 ServerSocket welcomeSocket = new ServerSocket(proxyPort);
                 
                 while (true) {
                 	System.out.println("waiting to accept");
                     Socket connectionSocket = welcomeSocket.accept(); //the incoming client
                     System.out.println("Connected, sending to request handler");
                     new RequestHandler(connectionSocket, server);
                     
                    // BufferedReader inFromClient= new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

                    // DataOutputStream outToClient= new DataOutputStream(connectionSocket.getOutputStream());

                    // clientSentence = inFromClient.readLine();

                    // capitalizedSentence = clientSentence.toUpperCase() + '\n';

                    // outToClient.writeBytes(capitalizedSentence);
                 }
                           
            } catch (Exception e) {
            		System.out.println("failed to create new socket thread");
            }

           
        }



	

    public String getCache(String hashcode) {
        return cache.get(hashcode);
    }

    public void putCache(String hashcode, String fileName) {
        cache.put(hashcode, fileName);
    }

    public synchronized void writeLog(String info) {

        /**
         * To do write string (info) to the log file, and add the current time
         * stamp e.g. String timeStamp = new
         * SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
         *
         */
    }



}
