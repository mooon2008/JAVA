
import javafx.scene.Node;
import java.util.Scanner;
import java.io.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.server.*;
import java.rmi.*;
import java.io.Serializable;


/**
 *
 * @author Abdullah S. Alajaj
 */

public class courseRegistrationServerImpl     extends UnicastRemoteObject implements ProjectServerInterface{

	protected courseRegistrationServerImpl() throws RemoteException {
		super();
		
	}

        
  
    Node ClassesHead = null;
    
         public class Node   
        {
          
            public int code, Cridit;
           public String Name, PHDName, InfoOneLine;
                Node next;

                public Node()
                        {
                           code = 0;
                           Cridit =0;
                           Name = "";
                           PHDName = "";
                           InfoOneLine = "";
                        }
        }//end classes class 
         

    public String addClasses()
    {
                       
            try {
                BufferedReader reader =null;
                File file = new File("CoursesFall18.txt");
                reader = new BufferedReader (new FileReader(file));
                
               
                String lineJustFetched = null;
                String[] wordsArray;
                
                while(true)
                {
                    lineJustFetched = reader.readLine(); 
                    
                    Node PTR  = new Node();
                    Node ScanNode = ClassesHead;
                    
                    if(lineJustFetched == null)
                    {
                        break;
                    }else
                    {
                        
                        PTR.InfoOneLine = lineJustFetched;
                        wordsArray = lineJustFetched.split("\t");
                        
                        PTR.code = Integer.parseInt(wordsArray[0]);
                        PTR.Name = wordsArray[1];
                        PTR.Cridit = Integer.parseInt(wordsArray[2]);
                        PTR.PHDName = wordsArray[3];
                        PTR.next = null;
                        
                        
                        if (ScanNode == null )// if head
                        {
                            ClassesHead = PTR;
                            
                            
                        }
                        else
                        {
                            
                            while (ScanNode.next != null)
                                ScanNode = ScanNode.next;
                            
                            ScanNode.next = PTR;
                            
                        }
                        
                    }// end big else
                }//end while loop
              
            } // end add classes
            catch (FileNotFoundException ex) {
                Logger.getLogger(courseRegistrationServerImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(courseRegistrationServerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
                  return "All classes ready";
    }
    
 @Override
    public String ClassInfo(int getcode)
    {
                           Node ScanNode = ClassesHead;
           
           while(ScanNode != null && ScanNode.code != getcode)
           {
               ScanNode = ScanNode.next;
           }
           if (ScanNode == null)
               return "Class code does not exist";
           else
             return ScanNode.InfoOneLine;
    }//end class info
      
       
                          
   
      
          
        RegistrationList RegistrationListHead = null;

         public  class RegistrationList {
            int code;
           String  ClassesRegistered;
           String StudentName;
           RegistrationList next; 
          
          public RegistrationList()
          {
              code =0;
              ClassesRegistered = "";
              StudentName = "";
              next = null;
              
          }
         
         }
/*  @Override 
             public String Update(RegistrationList name, RegistrationList code)
             {
                 return code.toString()+name;
             }*/
  @Override          
           public String addRegist(int CourseCode, String StudentName)
           {
               Node ScanNode =  ClassesHead;
               RegistrationList PTR = new RegistrationList();
               RegistrationList NewRegist = new RegistrationList();
               
               NewRegist.code = CourseCode;
               NewRegist.StudentName = StudentName;
               NewRegist.next = null;
               
               PTR = RegistrationListHead;
               
               
              
               while (ScanNode != null && ScanNode.code != CourseCode) // find if class exsit 
                  ScanNode = ScanNode.next;
              
              if(ScanNode == null)
              return "Class Code does not exist";
              
              else if (PTR == null) // first student to register a class
              {
                  NewRegist.ClassesRegistered = ScanNode.InfoOneLine;
                  RegistrationListHead = NewRegist;
                  
              }
              else
              {
                while (PTR.next != null)
                    PTR = PTR.next;
                  
                PTR.next = NewRegist;
                NewRegist.ClassesRegistered = ScanNode.InfoOneLine;
                
              }

              return NewRegist.StudentName + " now Register for " + ScanNode.Name;
           }
       
  
        
 @Override
    public String DropStudent(int CourseCode, String StudentName) throws RemoteException {
             Node ScanNode =  ClassesHead;
               RegistrationList PTR;
               RegistrationList Priv = null;
               PTR = RegistrationListHead;
               
               while( ScanNode.code != CourseCode)
               {
                 ScanNode =ScanNode.next;
                
                 if (ScanNode == null)
                return "Class does not exist";  
               }

              while (true ) 
              {
                                                      

              
                 if((CourseCode == PTR.code) && (StudentName.equals(PTR.StudentName)))
                  {
                  String SName ="";
                  if(PTR == RegistrationListHead)
                  {
                      RegistrationListHead = RegistrationListHead.next;
                     SName = PTR.StudentName;
                      PTR = null;
                      return   SName + " Droped out of " +ScanNode.Name+ " class";
                  }
                  else
                  {
                     Priv.next = PTR.next;
                     SName = PTR.StudentName;
                     PTR =null;
                     return   SName + " Droped out of " +ScanNode.Name+ " class";
                  }
                  } 
                  else if(PTR == null)
                 return "Student not register for this class";
                  
                  Priv = PTR;  
                  PTR = PTR.next; 
                  

 

                 
                }//end while loop
         }//end drop function 
       
      

    public Vector< String> requestStudents(int courseCode)  throws RemoteException  {
          Vector<String> ForReturn = new Vector();
          RegistrationList PTR = new RegistrationList();
          Node ScanNode = new Node();
          PTR = RegistrationListHead;
          ScanNode = ClassesHead;
          
          while (ScanNode != null && ScanNode.code != courseCode)
              ScanNode = ScanNode.next;

          if(ScanNode == null)
          {
                 ForReturn.add("Class does not exist");
                 return  ForReturn; 
          }

          
          ForReturn.add(ScanNode.InfoOneLine);
          
          while (PTR != null && ScanNode != null)
          {
              if (PTR.ClassesRegistered == ScanNode.InfoOneLine)
                  ForReturn.add(PTR.StudentName);   
         
          PTR = PTR.next;
          }//end while loop
          
          
          if(ForReturn.size() < 1 )
          ForReturn.add("Eaher there is not student Register for this class or class does not exist");
          
          
          
                  return  ForReturn; 
         }//end requstStudent
                
                
       
 
}

