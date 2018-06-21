/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;
/**
 *
 * @author M. L. Liu 
 * @Used by Abdullah Alajaj
 */
public class MyDatagramSocket extends DatagramSocket
{
    static final int MAX_LEN = 10;
    MyDatagramSocket (int portNo) throws SocketException
    {
        super (portNo);
    }
    
    public void sendMessage (InetAddress receiverHost, int receiverPort, String message) throws IOException 
    {
        byte [ ] sendBuffer = message.getBytes( );
        DatagramPacket datagram = new DatagramPacket (sendBuffer, sendBuffer.length, receiverHost, receiverPort);
        this.send(datagram);
    }
    
     public String receiveMessage()  throws IOException 
     {

    byte[] receiveBuffer = new byte[MAX_LEN];
    DatagramPacket datagram = new DatagramPacket(receiveBuffer, MAX_LEN);
    this.receive(datagram);
    String message = new String(receiveBuffer);
    return message;
    
     }
}
