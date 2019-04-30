/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/


import java.io.Serializable;

// line 51 "IMSPersistence.ump"
public class Transaction implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transaction()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  // line 57 "IMSPersistence.ump"
   public static  void reinitializeAutouniqueID(List<Transaction> transactions){
    nextId = 0; 
    for (Transaction transaction : transactions) {
      if (transaction.getId() > nextId) {
        nextId = transaction.getId();
      }
    }
    nextId++;
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 54 "IMSPersistence.ump"
  private static final long serialVersionUID = 8896099585515989380L ;

  
}