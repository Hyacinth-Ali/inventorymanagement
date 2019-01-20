/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.util.*;

// line 12 "../../../../ims.ump"
public class Warehouse
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Warehouse Associations
  private List<Product> products;
  private IMS iMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Warehouse(IMS aIMS)
  {
    products = new ArrayList<Product>();
    boolean didAddIMS = setIMS(aIMS);
    if (!didAddIMS)
    {
      throw new RuntimeException("Unable to create warehouse due to iMS");
    }
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
  /* Code from template association_GetOne */
  public IMS getIMS()
  {
    return iMS;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfProducts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Product addProduct(String aName, double aUnitprice, int aQuantity, IMS aIMS)
  {
    return new Product(aName, aUnitprice, aQuantity, this, aIMS);
  }

  public boolean addProduct(Product aProduct)
  {
    boolean wasAdded = false;
    if (products.contains(aProduct)) { return false; }
    Warehouse existingWarehouse = aProduct.getWarehouse();
    boolean isNewWarehouse = existingWarehouse != null && !this.equals(existingWarehouse);
    if (isNewWarehouse)
    {
      aProduct.setWarehouse(this);
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
    //Unable to remove aProduct, as it must always have a warehouse
    if (!this.equals(aProduct.getWarehouse()))
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
      existingIMS.removeWarehouse(this);
    }
    iMS.addWarehouse(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=products.size(); i > 0; i--)
    {
      Product aProduct = products.get(i - 1);
      aProduct.delete();
    }
    IMS placeholderIMS = iMS;
    this.iMS = null;
    if(placeholderIMS != null)
    {
      placeholderIMS.removeWarehouse(this);
    }
  }

}