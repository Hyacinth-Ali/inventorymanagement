/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.sql.Date;
import java.util.*;

// line 149 "../../../../IMS.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private Date orderedDate;
  private Date arrivalDate;

  //Order Associations
  private IMS iMS;
  private Supplier supplier;
  private List<Product> products;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(Date aOrderedDate, IMS aIMS, Product... allProducts)
  {
    orderedDate = aOrderedDate;
    arrivalDate = null;
    boolean didAddIMS = setIMS(aIMS);
    if (!didAddIMS)
    {
      throw new RuntimeException("Unable to create order due to iMS");
    }
    products = new ArrayList<Product>();
    boolean didAddProducts = setProducts(allProducts);
    if (!didAddProducts)
    {
      throw new RuntimeException("Unable to create Order, must have at least 1 products");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOrderedDate(Date aOrderedDate)
  {
    boolean wasSet = false;
    orderedDate = aOrderedDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setArrivalDate(Date aArrivalDate)
  {
    boolean wasSet = false;
    arrivalDate = aArrivalDate;
    wasSet = true;
    return wasSet;
  }

  public Date getOrderedDate()
  {
    return orderedDate;
  }

  public Date getArrivalDate()
  {
    return arrivalDate;
  }
  /* Code from template association_GetOne */
  public IMS getIMS()
  {
    return iMS;
  }
  /* Code from template association_GetOne */
  public Supplier getSupplier()
  {
    return supplier;
  }

  public boolean hasSupplier()
  {
    boolean has = supplier != null;
    return has;
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
      existingIMS.removeOrder(this);
    }
    iMS.addOrder(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetUnidirectionalOptionalOne */
  public boolean setSupplier(Supplier aNewSupplier)
  {
    boolean wasSet = false;
    supplier = aNewSupplier;
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfProducts()
  {
    return 1;
  }
  /* Code from template association_AddUnidirectionalMStar */
  public boolean addProduct(Product aProduct)
  {
    boolean wasAdded = false;
    if (products.contains(aProduct)) { return false; }
    products.add(aProduct);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeProduct(Product aProduct)
  {
    boolean wasRemoved = false;
    if (!products.contains(aProduct))
    {
      return wasRemoved;
    }

    if (numberOfProducts() <= minimumNumberOfProducts())
    {
      return wasRemoved;
    }

    products.remove(aProduct);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_SetUnidirectionalMStar */
  public boolean setProducts(Product... newProducts)
  {
    boolean wasSet = false;
    ArrayList<Product> verifiedProducts = new ArrayList<Product>();
    for (Product aProduct : newProducts)
    {
      if (verifiedProducts.contains(aProduct))
      {
        continue;
      }
      verifiedProducts.add(aProduct);
    }

    if (verifiedProducts.size() != newProducts.length || verifiedProducts.size() < minimumNumberOfProducts())
    {
      return wasSet;
    }

    products.clear();
    products.addAll(verifiedProducts);
    wasSet = true;
    return wasSet;
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
    IMS placeholderIMS = iMS;
    this.iMS = null;
    if(placeholderIMS != null)
    {
      placeholderIMS.removeOrder(this);
    }
    supplier = null;
    products.clear();
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "orderedDate" + "=" + (getOrderedDate() != null ? !getOrderedDate().equals(this)  ? getOrderedDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "arrivalDate" + "=" + (getArrivalDate() != null ? !getArrivalDate().equals(this)  ? getArrivalDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "supplier = "+(getSupplier()!=null?Integer.toHexString(System.identityHashCode(getSupplier())):"null");
  }
}