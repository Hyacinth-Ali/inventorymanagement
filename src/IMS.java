/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/


import java.io.Serializable;

// line 3 "IMSPersistence.ump"
public class IMS implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public IMS()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  // line 9 "IMSPersistence.ump"
   public void reinitialize(){
    Product.reinitializeUniqueName(this.getProducts());
    Manager.reinitializeUniqueUserName(this.getManagers());
    Transaction.reinitializeAutouniqueID(this.getTransactions());
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 6 "IMSPersistence.ump"
  private static final long serialVersionUID = -2683593616927798071L ;

  
}