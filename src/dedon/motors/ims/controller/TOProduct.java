/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.controller;

// line 8 "../../../../IMSTransferObjects.ump"
public class TOProduct
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TOProduct Attributes
  private String name;
  private int price;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TOProduct(String aName, int aPrice)
  {
    name = aName;
    price = aPrice;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrice(int aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getPrice()
  {
    return price;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "price" + ":" + getPrice()+ "]";
  }
}