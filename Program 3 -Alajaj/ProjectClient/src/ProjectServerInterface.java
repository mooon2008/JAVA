import java.rmi.Remote;
public interface ProjectServerInterface extends Remote {

  public int calculateSum(int n ) throws java.rmi.RemoteException;

    public long calculateSum(long n);
}
