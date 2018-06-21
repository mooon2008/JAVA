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

public class CalculateSumServerImpl extends UnicastRemoteObject implements ProjectServerInterface {
  public CalculateSumServerImpl() throws java.rmi.RemoteException
  {}
  public long calculateSum(long n) throws java.rmi.RemoteException
    {
     
       /*
        int res =0;        
        for(int i = 0;i <= n; i++)
        {
           res = res+i;
        }
	*/    
     long res;
     res = (n*(n+1))/2;
     return res;
  }

    @Override
    public int calculateSum(int n) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}