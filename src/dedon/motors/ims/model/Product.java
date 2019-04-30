/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.io.Serializable;
import java.util.*;

// line 31 "../../../../IMSPersistence.ump"
// line 30 "../../../../IMS.ump"
public class Product implements Serializable
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
  private double price;

  //Product Associations
  private List<Item> items;
  private IMS iMS;
  private Warehouse warehouse;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Product(String aName, double aPrice, IMS aIMS)
  {
    // line 37 "../../../../IMS.ump"
    if(aName == null || aName.length() == 0 ) {
      		throw new RuntimeException("The name of a product cannot be empty");
      	}
      	if (aName.length() > 25) {
      		throw new RuntimeException("Product character cannot be more than 25");
      	}
    // END OF UMPLE BEFORE INJECTION
    // line 46 "../../../../IMS.ump"
    if (aPrice == 0 ) {
      		throw new RuntimeException("The price of a product cannot be zero");
      	}
      	if (aPrice < 0 ) {
      		throw new RuntimeException("The price of a product cannot be negative");
      	}
    // END OF UMPLE BEFORE INJECTION
    price = aPrice;
    if (!setName(aName))
    {
      throw new RuntimeException("Cannot create due to duplicate name");
    }
    items = new ArrayList<Item>();
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
    // line 37 "../../../../IMS.ump"
    if(aName == null || aName.length() == 0 ) {
      		throw new RuntimeException("The name of a product cannot be empty");
      	}
      	if (aName.length() > 25) {
      		throw new RuntimeException("Product character cannot be more than 25");
      	}
    // END OF UMPLE BEFORE INJECTION
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

  public boolean setPrice(double aPrice)
  {
    boolean wasSet = false;
    // line 46 "../../../../IMS.ump"
    if (aPrice == 0 ) {
      		throw new RuntimeException("The price of a product cannot be zero");
      	}
      	if (aPrice < 0 ) {
      		throw new RuntimeException("The price of a product cannot be negative");
      	}
    // END OF UMPLE BEFORE INJECTION
    price = aPrice;
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

  public double getPrice()
  {
    return price;
  }
  /* Code from template association_GetMany */
  public Item getItem(int index)
  {
    Item aItem = items.get(index);
    return aItem;
  }

  public List<Item> getItems()
  {
    List<Item> newItems = Collections.unmodifiableList(items);
    return newItems;
  }

  public int numberOfItems()
  {
    int number = items.size();
    return number;
  }

  public boolean hasItems()
  {
    boolean has = items.size() > 0;
    return has;
  }

  public int indexOfItem(Item aItem)
  {
    int index = items.indexOf(aItem);
    return index;
  }
  /* Code from template association_GetOne */
  public IMS getIMS()
  {
    return iMS;
  }
  /* Code from template association_GetOne */
  public Warehouse getWarehouse()
  {
    return warehouse;
  }

  public boolean hasWarehouse()
  {
    boolean has = warehouse != null;
    return has;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfItems()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Item addItem()
  {
    return new Item(this);
  }

  public boolean addItem(Item aItem)
  {
    boolean wasAdded = false;
    if (items.contains(aItem)) { return false; }
    Product existingProduct = aItem.getProduct();
    boolean isNewProduct = existingProduct != null && !this.equals(existingProduct);
    if (isNewProduct)
    {
      aItem.setProduct(this);
    }
    else
    {
      items.add(aItem);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeItem(Item aItem)
  {
    boolean wasRemoved = false;
    //Unable to remove aItem, as it must always have a product
    if (!this.equals(aItem.getProduct()))
    {
      items.remove(aItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addItemAt(Item aItem, int index)
  {  
    boolean wasAdded = false;
    if(addItem(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveItemAt(Item aItem, int index)
  {
    boolean wasAdded = false;
    if(items.contains(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItems()) { index = numberOfItems() - 1; }
      items.remove(aItem);
      items.add(index, aItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addItemAt(aItem, index);
    }
    return wasAdded;
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
  /* Code from template association_SetOptionalOneToMany */
  public boolean setWarehouse(Warehouse aWarehouse)
  {
    boolean wasSet = false;
    Warehouse existingWarehouse = warehouse;
    warehouse = aWarehouse;
    if (existingWarehouse != null && !existingWarehouse.equals(aWarehouse))
    {
      existingWarehouse.removeProduct(this);
    }
    if (aWarehouse != null)
    {
      aWarehouse.addProduct(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    productsByName.remove(getName());
    while (items.size() > 0)
    {
      Item aItem = items.get(items.size() - 1);
      aItem.delete();
      items.remove(aItem);
    }
    
    IMS placeholderIMS = iMS;
    this.iMS = null;
    if(placeholderIMS != null)
    {
      placeholderIMS.removeProduct(this);
    }
    if (warehouse != null)
    {
      Warehouse placeholderWarehouse = warehouse;
      this.warehouse = null;
      placeholderWarehouse.removeProduct(this);
    }
  }

  // line 37 "../../../../IMSPersistence.ump"
   public static  void reinitializeUniqueName(List<Product> products){
    productsByName = new HashMap<String, Product>();
    for (Product product : products) {
      productsByName.put(product.getName(), product);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "price" + ":" + getPrice()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "warehouse = "+(getWarehouse()!=null?Integer.toHexString(System.identityHashCode(getWarehouse())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 34 "../../../../IMSPersistence.ump"
  private static final long serialVersionUID = 8896099581655989380L ;

  
}