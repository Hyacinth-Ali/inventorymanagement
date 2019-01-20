/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.io.Serializable;
import java.util.*;

// line 3 "../../../../IMSPersistence.ump"
// line 24 "../../../../ims.ump"
public class IMS implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //IMS Associations
  private List<Product> products;
  private List<Warehouse> warehouse;
  private List<Manager> manager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public IMS()
  {
    products = new ArrayList<Product>();
    warehouse = new ArrayList<Warehouse>();
    manager = new ArrayList<Manager>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Product getProduct(int index)
  {
    Product aProduct = products.get(index);
    return aProduct;
  }

  public List<Product> getProducts()
  {
    List<Product> newProducts = Collections.unmodifiableList(products);
    return newProducts;
  }

  public int numberOfProducts()
  {
    int number = products.size();
    return number;
  }

  public boolean hasProducts()
  {
    boolean has = products.size() > 0;
    return has;
  }

  public int indexOfProduct(Product aProduct)
  {
    int index = products.indexOf(aProduct);
    return index;
  }
  /* Code from template association_GetMany */
  public Warehouse getWarehouse(int index)
  {
    Warehouse aWarehouse = warehouse.get(index);
    return aWarehouse;
  }

  public List<Warehouse> getWarehouse()
  {
    List<Warehouse> newWarehouse = Collections.unmodifiableList(warehouse);
    return newWarehouse;
  }

  public int numberOfWarehouse()
  {
    int number = warehouse.size();
    return number;
  }

  public boolean hasWarehouse()
  {
    boolean has = warehouse.size() > 0;
    return has;
  }

  public int indexOfWarehouse(Warehouse aWarehouse)
  {
    int index = warehouse.indexOf(aWarehouse);
    return index;
  }
  /* Code from template association_GetMany */
  public Manager getManager(int index)
  {
    Manager aManager = manager.get(index);
    return aManager;
  }

  public List<Manager> getManager()
  {
    List<Manager> newManager = Collections.unmodifiableList(manager);
    return newManager;
  }

  public int numberOfManager()
  {
    int number = manager.size();
    return number;
  }

  public boolean hasManager()
  {
    boolean has = manager.size() > 0;
    return has;
  }

  public int indexOfManager(Manager aManager)
  {
    int index = manager.indexOf(aManager);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfProducts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Product addProduct(String aName, double aUnitprice, int aQuantity, Warehouse aWarehouse)
  {
    return new Product(aName, aUnitprice, aQuantity, aWarehouse, this);
  }

  public boolean addProduct(Product aProduct)
  {
    boolean wasAdded = false;
    if (products.contains(aProduct)) { return false; }
    IMS existingIMS = aProduct.getIMS();
    boolean isNewIMS = existingIMS != null && !this.equals(existingIMS);
    if (isNewIMS)
    {
      aProduct.setIMS(this);
    }
    else
    {
      products.add(aProduct);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeProduct(Product aProduct)
  {
    boolean wasRemoved = false;
    //Unable to remove aProduct, as it must always have a iMS
    if (!this.equals(aProduct.getIMS()))
    {
      products.remove(aProduct);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addProductAt(Product aProduct, int index)
  {  
    boolean wasAdded = false;
    if(addProduct(aProduct))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProducts()) { index = numberOfProducts() - 1; }
      products.remove(aProduct);
      products.add(index, aProduct);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveProductAt(Product aProduct, int index)
  {
    boolean wasAdded = false;
    if(products.contains(aProduct))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProducts()) { index = numberOfProducts() - 1; }
      products.remove(aProduct);
      products.add(index, aProduct);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addProductAt(aProduct, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfWarehouse()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Warehouse addWarehouse()
  {
    return new Warehouse(this);
  }

  public boolean addWarehouse(Warehouse aWarehouse)
  {
    boolean wasAdded = false;
    if (warehouse.contains(aWarehouse)) { return false; }
    IMS existingIMS = aWarehouse.getIMS();
    boolean isNewIMS = existingIMS != null && !this.equals(existingIMS);
    if (isNewIMS)
    {
      aWarehouse.setIMS(this);
    }
    else
    {
      warehouse.add(aWarehouse);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeWarehouse(Warehouse aWarehouse)
  {
    boolean wasRemoved = false;
    //Unable to remove aWarehouse, as it must always have a iMS
    if (!this.equals(aWarehouse.getIMS()))
    {
      warehouse.remove(aWarehouse);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addWarehouseAt(Warehouse aWarehouse, int index)
  {  
    boolean wasAdded = false;
    if(addWarehouse(aWarehouse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWarehouse()) { index = numberOfWarehouse() - 1; }
      warehouse.remove(aWarehouse);
      warehouse.add(index, aWarehouse);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWarehouseAt(Warehouse aWarehouse, int index)
  {
    boolean wasAdded = false;
    if(warehouse.contains(aWarehouse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWarehouse()) { index = numberOfWarehouse() - 1; }
      warehouse.remove(aWarehouse);
      warehouse.add(index, aWarehouse);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWarehouseAt(aWarehouse, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfManager()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Manager addManager(String aName, String aUsername, String aPassword)
  {
    return new Manager(aName, aUsername, aPassword, this);
  }

  public boolean addManager(Manager aManager)
  {
    boolean wasAdded = false;
    if (manager.contains(aManager)) { return false; }
    IMS existingIMS = aManager.getIMS();
    boolean isNewIMS = existingIMS != null && !this.equals(existingIMS);
    if (isNewIMS)
    {
      aManager.setIMS(this);
    }
    else
    {
      manager.add(aManager);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeManager(Manager aManager)
  {
    boolean wasRemoved = false;
    //Unable to remove aManager, as it must always have a iMS
    if (!this.equals(aManager.getIMS()))
    {
      manager.remove(aManager);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addManagerAt(Manager aManager, int index)
  {  
    boolean wasAdded = false;
    if(addManager(aManager))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfManager()) { index = numberOfManager() - 1; }
      manager.remove(aManager);
      manager.add(index, aManager);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveManagerAt(Manager aManager, int index)
  {
    boolean wasAdded = false;
    if(manager.contains(aManager))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfManager()) { index = numberOfManager() - 1; }
      manager.remove(aManager);
      manager.add(index, aManager);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addManagerAt(aManager, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (products.size() > 0)
    {
      Product aProduct = products.get(products.size() - 1);
      aProduct.delete();
      products.remove(aProduct);
    }
    
    while (warehouse.size() > 0)
    {
      Warehouse aWarehouse = warehouse.get(warehouse.size() - 1);
      aWarehouse.delete();
      warehouse.remove(aWarehouse);
    }
    
    while (manager.size() > 0)
    {
      Manager aManager = manager.get(manager.size() - 1);
      aManager.delete();
      manager.remove(aManager);
    }
    
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 6 "../../../../IMSPersistence.ump"
  private static final long serialVersionUID = -2683593616927798071L ;

  
}