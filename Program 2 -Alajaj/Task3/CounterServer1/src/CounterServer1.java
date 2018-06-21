
import java.io.*;
import java.net.*;
 

/**

 * This module contains the application logic of a Counter server

 * which uses a  datagram socket for interprocess communication.

 * A command-line argument is required to specify the server port.

 * @author M. L. Liu
 * Used by Abdullah S. Alajaj

 */

 

public class CounterServer1 {

 

   /* state information */

   static int counter = 0;

 

   public static void main(String[] args) {

      int serverPort = 12345;    // default port

      if (args.length == 1 )

         serverPort = Integer.parseInt(args[0]);      

      try {

         // instantiates a datagram socket for both sending

         // and receiving data
   	   ServerSocket myConnectionSocket = 
            new ServerSocket(serverPort);
           
           System.out.println("Counter server ready."); 
           

/**/     

         while (true) {  // forever loop

             System.out.println("Waiting for a connection."); 
             
            MyStreamSocket mySocket = new MyStreamSocket
                (myConnectionSocket.accept( ));

            System.out.println("A client has made connection");

            // The message received is unimportant; it is the sender's

            // address that we need in order to reply.

                 // Now increment the counter, then send its value to the client.

            increment( );

/**/        System.out.println("counter sent: "+ counter);

            // Now send the reply to the requestor

            mySocket.sendMessage(String.valueOf(counter));

             } //end while

       } // end try

         catch (Exception ex) {

          ex.printStackTrace( );

         }

   } //end main

 

   static private synchronized void increment( ){

       counter++;   

   }

 

} // end class 