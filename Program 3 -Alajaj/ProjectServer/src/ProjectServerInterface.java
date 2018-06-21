/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nicole
 */
import java.rmi.Remote;
public interface ProjectServerInterface extends Remote {

  public int calculateSum(int n ) throws java.rmi.RemoteException;
}
