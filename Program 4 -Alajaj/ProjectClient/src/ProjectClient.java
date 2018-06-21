/*
*Spring 2018
*Lawrence Technological University
*DS 3580
* 4/15/2018
 * Created by Abdullah S. Alajaj
 */
import java.rmi.*;
import java.util.*;
import java.io.Serializable;

public class ProjectClient{
  public static void main(String args[]) throws RemoteException{
	 
       
      try{
	        int port = 9999, classnumber = 0;
                String Name ="", Result = "";
               
                
	        String host = "localhost";
	        String registr = "rmi://" + host + ":" + port + "/registration";
                ProjectServerInterface face = (ProjectServerInterface)Naming.lookup(registr);
	        System.out.println("Connected " );
	       
                
                while (true)
                {
                System.out.println("Give me a command (G for Get Course Info, R for Register for a class"
                        + ", D for Drop a student out of a class, S Students names Registered for a class, E to exit) :");
	    	Scanner scan= new Scanner(System.in);
	    	char command  = scan.next().charAt(0);
	   
                
	    	
                if (command == 'G' || command == 'g'  )
                {
                  System.out.println("What is the class code? ");
                  classnumber = scan.nextInt();
                   Result = face.ClassInfo(classnumber);
                    
                   System.out.println(Result);
                }
                else if (command == 'R' || command == 'r'  )
                {
                  System.out.println("What is the class code? ");
                  classnumber = scan.nextInt();
                  System.out.println("What is the student last name? (note that it is case senstive) ");
                  Name = scan.next();
                  
                  Result = face.addRegist(classnumber, Name);
                  
                  System.out.println(Result);
                }
                else if (command == 'D' || command == 'd'  )
                {
                  System.out.println("What is the class code you want to drop a student from? ");
                  classnumber = scan.nextInt();
                  System.out.println("What is the student last name? (note that it is case senstive) ");
                  Name = scan.next();
                  
                  Result = face.DropStudent(classnumber, Name);
                  
                  System.out.println(Result);
                    
                }
                else if (command == 'S' || command == 's'  )
                {
                   System.out.println("What is the class code? ");
                  classnumber = scan.nextInt();
                  Vector<String> Roster = null;
                          
                          Roster = face.requestStudents(classnumber);
                    
                         for (int i =0; i<Roster.size(); i++)
                         System.out.println(Roster.get(i));
                }
                else if (command == 'E' || command == 'e' )
                {
                      System.out.println("Thank you for using my app and have nice day"); 
                       System.exit(0);
                }
                   
                else
                {
                    char not_correct  = command;
 
                    System.out.println(not_correct + " not correct entry");                 
                }
                
                
                } //end while loop 
                 
	      } // end try// end try
      
      
	      catch (Exception e){
	        e.printStackTrace();
	      } 
  }
}


