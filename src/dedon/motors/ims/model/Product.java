/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.util.*;

// line 5 "../../../../ims.ump"
public class Product
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Product> productsByName = new HashMap<String, Product>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Product Attributes
  private String name;
  private double unitprice;
  private int quantity;

  //Product Associations
  private Warehouse warehouse;
  private IMS iMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Product(String aName, double aUnitprice, int aQuantity, Warehouse aWarehouse, IMS aIMS)
  {
    unitprice = aUnitprice;
    quantity = aQuantity;
    if (!setName(aName))
    {
      throw new RuntimeException("Cannot create due to duplicate name");
    }
    boolean didAddWarehouse = setWarehouse(aWarehouse);
    if (!didAddWarehouse)
    {
      throw new RuntimeException("Unable to create product due to warehouse");
    }
    boolean didAddIMS = setIMS(aIMS);
    if (!didAddIMS)
    {
      throw new RuntimeException("Unable to create product due to iMS");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    String anOldName = getName();
    if (hasWithName(aName)) {
      return wasSet;
    }
    name = aName;
    wasSet = true;
    if (anOldName != null) {
      productsByName.remove(anOldName);
    }
    productsByName.put(aName, this);
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
  /* Code from template attribute_GetUnique */
  public static Product getWithName(String aName)
  {
    return productsByName.get(aName);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithName(String aName)
  {
    return getWithName(aName) != null;
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
  public Warehouse getWarehouse()
  {
    return warehouse;
  }
  /* Code from template association_GetOne */
  public IMS getIMS()
  {
    return iMS;
  }
  /* Code from template association_SetOneToMany */
  public boolean setWarehouse(Warehouse aWarehouse)
  {
    boolean wasSet = false;
    if (aWarehouse == null)
    {
      return wasSet;
    }

    Warehouse existingWarehouse = warehouse;
    warehouse = aWarehouse;
    if (existingWarehouse != null && !existingWarehouse.equals(aWarehouse))
    {
      existingWarehouse.removeProduct(this);
    }
    warehouse.addProduct(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setIMS(IMS aIMS)
  {
    boolean wasSet = false;
    if (aIMS == null)
    {
      return wasSet;
    }

    IMS existingIMS = iMS;
    iMS = aIMS;
    if (existingIMS != null && !existingIMS.equals(aIMS))
    {
      existingIMS.removeProduct(this);
    }
    iMS.addProduct(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    productsByName.remove(getName());
    Warehouse placeholderWarehouse = warehouse;
    this.warehouse = null;
    if(placeholderWarehouse != null)
    {
      placeholderWarehouse.removeProduct(this);
    }
    IMS placeholderIMS = iMS;
    this.iMS = null;
    if(placeholderIMS != null)
    {
      placeholderIMS.removeProduct(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "unitprice" + ":" + getUnitprice()+ "," +
            "quantity" + ":" + getQuantity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "warehouse = "+(getWarehouse()!=null?Integer.toHexString(System.identityHashCode(getWarehouse())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null");
  }
}