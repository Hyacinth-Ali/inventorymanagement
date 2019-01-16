/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package productmanagemnet;

// line 3 "../productmang.ump"
public class Product
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Product Attributes
  private String name;
  private double unitprice;
  private int quantity;

  //Product Associations
  private Warehouse inWarehouse;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Product(String aName, double aUnitprice, int aQuantity)
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

  public boolean setUnitprice(double aUnitprice)
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

  public double getUnitprice()
  {
    return unitprice;
  }

  public int getQuantity()
  {
    return quantity;
  }
  /* Code from template association_GetOne */
  public Warehouse getInWarehouse()
  {
    return inWarehouse;
  }

  public boolean hasInWarehouse()
  {
    boolean has = inWarehouse != null;
    return has;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setInWarehouse(Warehouse aInWarehouse)
  {
    boolean wasSet = false;
    Warehouse existingInWarehouse = inWarehouse;
    inWarehouse = aInWarehouse;
    if (existingInWarehouse != null && !existingInWarehouse.equals(aInWarehouse))
    {
      existingInWarehouse.removeProduct(this);
    }
    if (aInWarehouse != null)
    {
      aInWarehouse.addProduct(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (inWarehouse != null)
    {
      Warehouse placeholderInWarehouse = inWarehouse;
      this.inWarehouse = null;
      placeholderInWarehouse.removeProduct(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "unitprice" + ":" + getUnitprice()+ "," +
            "quantity" + ":" + getQuantity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "inWarehouse = "+(getInWarehouse()!=null?Integer.toHexString(System.identityHashCode(getInWarehouse())):"null");
  }
}