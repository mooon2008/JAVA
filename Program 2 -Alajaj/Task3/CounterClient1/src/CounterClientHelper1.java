import java.net.*;

 

/**

 * This class is a module which provides the application logic

 * for a Counter Client.

 * @author M. L. Liu
 * Used by Abdullah S. Alajaj

 */

 

public class CounterClientHelper1 {

    

   public static int getCounter(String hostName,

      String portNum) throws Exception {  

 

      int counter = 0;

      String message = "";

      try {     

              InetAddress serverHost =

             InetAddress.getByName(hostName);

              int serverPort = Integer.parseInt(portNum);

          // instantiates a datagram socket for both sending

          // and receiving data

          System.out.println("Connection request made");
          
         MyStreamSocket mySocket = new MyStreamSocket (serverHost, serverPort); 


               // now receive the timestamp

          message = mySocket.receiveMessage();

/**/      System.out.println("Message received: " + message);

          counter = Integer.parseInt(message.trim());
            
            // dicconnect is implied 
              mySocket.close( );

       } // end try

         catch (Exception ex) {

          ex.printStackTrace( );

         } // end catch

       return counter;

   } //end main

} //end class