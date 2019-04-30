/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/


import java.io.Serializable;

// line 15 "IMSPersistence.ump"
public class Manager implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Manager()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  // line 21 "IMSPersistence.ump"
   public static  void reinitializeUniqueUserName(List<Manager> managers){
    managersByUserName = new HashMap<String, Manager>();
    for (Manager manager : managers) {
      managersByUserName.put(manager.getUserName(), manager);
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 18 "IMSPersistence.ump"
  private static final long serialVersionUID = 2315072607928790501L ;

  
}