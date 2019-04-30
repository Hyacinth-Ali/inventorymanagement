/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.io.Serializable;
import java.util.*;

// line 77 "../../../../IMSPersistence.ump"
// line 59 "../../../../IMS.ump"
public class Warehouse implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Warehouse Associations
  private IMS iMS;
  private List<Product> products;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Warehouse(IMS aIMS)
  {
    boolean didAddIMS = setIMS(aIMS);
    if (!didAddIMS)
    {
      throw new RuntimeException("Unable to create warehouse due to iMS");
    }
    products = new ArrayList<Product>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public IMS getIMS()
  {
    return iMS;
  }
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
  /* Code from template association_SetOneToOptionalOne */
  public boolean setIMS(IMS aNewIMS)
  {
    boolean wasSet = false;
    if (aNewIMS == null)
    {
      //Unable to setIMS to null, as warehouse must always be associated to a iMS
      return wasSet;
    }
    
    Warehouse existingWarehouse = aNewIMS.getWarehouse();
    if (existingWarehouse != null && !equals(existingWarehouse))
    {
      //Unable to setIMS, the current iMS already has a warehouse, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    IMS anOldIMS = iMS;
    iMS = aNewIMS;
    iMS.setWarehouse(this);

    if (anOldIMS != null)
    {
      anOldIMS.setWarehouse(null);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfProducts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addProduct(Product aProduct)
  {
    boolean wasAdded = false;
    if (products.contains(aProduct)) { return false; }
    Warehouse existingWarehouse = aProduct.getWarehouse();
    if (existingWarehouse == null)
    {
      aProduct.setWarehouse(this);
    }
    else if (!this.equals(existingWarehouse))
    {
      existingWarehouse.removeProduct(aProduct);
      addProduct(aProduct);
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
    if (products.contains(aProduct))
    {
      products.remove(aProduct);
      aProduct.setWarehouse(null);
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

  public void delete()
  {
    IMS existingIMS = iMS;
    iMS = null;
    if (existingIMS != null)
    {
      existingIMS.setWarehouse(null);
    }
    while( !products.isEmpty() )
    {
      products.get(0).setWarehouse(null);
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 80 "../../../../IMSPersistence.ump"
  private static final long serialVersionUID = 386717977557499839L ;

  
}