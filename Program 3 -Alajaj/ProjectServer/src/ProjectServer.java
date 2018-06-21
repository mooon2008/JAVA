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

public class ProjectServer{
  //Main method
  public static void main(String args[]) throws java.rmi.RemoteException{
  try{
    CalculateSumServerImpl obj = new  CalculateSumServerImpl();
    Naming.rebind("ProjectServer",obj);
  }
 catch(Exception e)
 {}
 }   
}