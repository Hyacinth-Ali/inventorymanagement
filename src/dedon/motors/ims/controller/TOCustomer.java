/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.controller;

// line 3 "../../../../IMSTransferObjects.ump"
public class TOCustomer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TOCustomer Attributes
  private String id;
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TOCustomer(String aId, String aName)
  {
    id = aId;
    name = aName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }

  public String getName()
  {
    return name;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "name" + ":" + getName()+ "]";
  }
}