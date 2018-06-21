/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdullah S. Alajaj
 */
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;
import java.util.Map;
import java.util.Vector;
import java.io.Serializable;

public class ProjectServer{
	
  public static void main(String args[]){
	  
	  try{     
	        int port = 9999; 
	        String host = "localhost";
	        courseRegistrationServerImpl ex_Object = new courseRegistrationServerImpl();
	        start_Registry(port);        
	        String registr = "rmi://" + host + ":" + port + "/registration";
               
                ex_Object.addClasses();// add classes to server
               
	        LocateRegistry.getRegistry(port);
	        Naming.rebind(registr, ex_Object);

	        System.out.println(" Server ready.");
	      }
          catch (Exception D){
	        D.printStackTrace();
	      }
	    }

	    private static void start_Registry(int port)throws RemoteException{
	      try{
	        Registry registry = LocateRegistry.getRegistry(port);
	        registry.list( ); 
	      }catch (RemoteException e){ 
	        
	        System.out.println ("RMI registry have not been be located at port " + port);
                
	        Registry registry = LocateRegistry.createRegistry(port);
                registry.list( ); 
	        System.out.println("RMI registry created at port " + port);
	      }
  }
}
