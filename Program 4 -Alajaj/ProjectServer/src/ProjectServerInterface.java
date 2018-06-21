

/**
 *
 * @author Abdullah Alajaj
 */

import java.rmi.Remote;
import java.util.Map;
import java.util.Vector;
import java.io.Serializable;

public interface ProjectServerInterface extends Remote {
    
        public String ClassInfo (int getcode)throws java.rmi.RemoteException;
        
        public String addRegist(int CourseCode, String StudentName)throws java.rmi.RemoteException;
        public String DropStudent (int CourseCode, String StudentName) throws java.rmi.RemoteException;
        public Vector<String> requestStudents (int courseCode) throws java.rmi.RemoteException;
        
}

