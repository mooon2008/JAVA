import java.net.*;

/**
 * This example illustrates a process which sends then receives
 * using a datagram socket.
 * @author M. L. Liu
 * @used by Abdullah Alajaj 
 */
public class Example2SenderReceiver {
// An application which sends then receives a message using
// connectionless datagram socket.
// Four command line arguments are expected, in order: 
//    <domain name or IP address of the receiver>
//    <port number of the receiver's datagram socket>
//    <port number of this process's datagram socket>
//    <message, a string, to send>

   public static void main(String[] args) {
       MyDatagramSocket mySocket = null;
       
      if (args.length != 4)
         System.out.println
            ("This program requires four command line arguments");
      else {
         try {   
    
                    InetAddress receiverHost = InetAddress.getByName(args[0]);
            int receiverPort = Integer.parseInt(args[1]);
                    int myPort = Integer.parseInt(args[2]);
            String message = args[3];
                mySocket = new MyDatagramSocket(myPort);  
             // instantiates a datagram socket for both sending
             // and receiving data


while(true){  
  
            
                        
            
               mySocket.sendMessage( receiverHost, receiverPort, message); 
           // now wait to receive a datagram from the socket
            System.out.println(mySocket.receiveMessage());
            
                        Thread.sleep(3000); // pause for 3 sec  
               
                        
                } //end while 
            
         } // end try
             catch (Exception ex) {
            ex.printStackTrace( );
           mySocket.close( );
             } //end catch
      } //end else
   } //end main 

} //end class