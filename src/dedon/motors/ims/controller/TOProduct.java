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
  private int unitprice;
  private int quantity;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TOProduct(String aName, int aUnitprice, int aQuantity)
  {
    name = aName;
    unitprice = aUnitprice;
    quantity = aQuantity;
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

  public boolean setUnitprice(int aUnitprice)
  {
    boolean wasSet = false;
    unitprice = aUnitprice;
    wasSet = true;
    return wasSet;
  }

  public boolean setQuantity(int aQuantity)
  {
    boolean wasSet = false;
    quantity = aQuantity;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getUnitprice()
  {
    return unitprice;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "unitprice" + ":" + getUnitprice()+ "," +
            "quantity" + ":" + getQuantity()+ "]";
  }
}