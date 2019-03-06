/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;

// line 52 "../../../../IMSPersistence.ump"
// line 73 "../../../../IMS.ump"
public class Transaction implements Serializable
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextId = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transaction Attributes
  private Date date;
  private int totalAmount;
  private int amountPaid;
  private int debt;

  //Autounique Attributes
  private int id;

  //Transaction Associations
  private Customer customer;
  private List<Product> products;
  private Manager manager;
  private IMS iMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transaction(Date aDate, Customer aCustomer, Manager aManager, IMS aIMS)
  {
    date = aDate;
    totalAmount = 0;
    amountPaid = 0;
    debt = totalAmount - amountPaid;
    id = nextId++;
    boolean didAddCustomer = setCustomer(aCustomer);
    if (!didAddCustomer)
    {
      throw new RuntimeException("Unable to create transaction due to customer");
    }
    products = new ArrayList<Product>();
    boolean didAddManager = setManager(aManager);
    if (!didAddManager)
    {
      throw new RuntimeException("Unable to create transaction due to manager");
    }
    boolean didAddIMS = setIMS(aIMS);
    if (!didAddIMS)
    {
      throw new RuntimeException("Unable to create transaction due to iMS");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotalAmount(int aTotalAmount)
  {
    boolean wasSet = false;
    totalAmount = aTotalAmount;
    wasSet = true;
    return wasSet;
  }

  public boolean setAmountPaid(int aAmountPaid)
  {
    boolean wasSet = false;
    amountPaid = aAmountPaid;
    wasSet = true;
    return wasSet;
  }

  public boolean setDebt(int aDebt)
  {
    boolean wasSet = false;
    debt = aDebt;
    wasSet = true;
    return wasSet;
  }

  public Date getDate()
  {
    return date;
  }

  public int getTotalAmount()
  {
    return totalAmount;
  }

  public int getAmountPaid()
  {
    return amountPaid;
  }

  public int getDebt()
  {
    return debt;
  }

  public int getId()
  {
    return id;
  }
  /* Code from template association_GetOne */
  public Customer getCustomer()
  {
    return customer;
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
  /* Code from template association_GetOne */
  public Manager getManager()
  {
    return manager;
  }
  /* Code from template association_GetOne */
  public IMS getIMS()
  {
    return iMS;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCustomer(Customer aCustomer)
  {
    boolean wasSet = false;
    if (aCustomer == null)
    {
      return wasSet;
    }

    Customer existingCustomer = customer;
    customer = aCustomer;
    if (existingCustomer != null && !existingCustomer.equals(aCustomer))
    {
      existingCustomer.removeTransaction(this);
    }
    customer.addTransaction(this);
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
    Transaction existingTransactions = aProduct.getTransactions();
    if (existingTransactions == null)
    {
      aProduct.setTransactions(this);
    }
    else if (!this.equals(existingTransactions))
    {
      existingTransactions.removeProduct(aProduct);
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
      aProduct.setTransactions(null);
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
  public boolean setManager(Manager aManager)
  {
    boolean wasSet = false;
    if (aManager == null)
    {
      return wasSet;
    }

    Manager existingManager = manager;
    manager = aManager;
    if (existingManager != null && !existingManager.equals(aManager))
    {
      existingManager.removeTransaction(this);
    }
    manager.addTransaction(this);
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
      existingIMS.removeTransaction(this);
    }
    iMS.addTransaction(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Customer placeholderCustomer = customer;
    this.customer = null;
    if(placeholderCustomer != null)
    {
      placeholderCustomer.removeTransaction(this);
    }
    while( !products.isEmpty() )
    {
      products.get(0).setTransactions(null);
    }
    Manager placeholderManager = manager;
    this.manager = null;
    if(placeholderManager != null)
    {
      placeholderManager.removeTransaction(this);
    }
    IMS placeholderIMS = iMS;
    this.iMS = null;
    if(placeholderIMS != null)
    {
      placeholderIMS.removeTransaction(this);
    }
  }

  // line 58 "../../../../IMSPersistence.ump"
   public static  void reinitializeAutouniqueID(List<Transaction> transactions){
    nextId = 0; 
    for (Transaction transaction : transactions) {
      if (transaction.getId() > nextId) {
        nextId = transaction.getId();
      }
    }
    nextId++;
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "totalAmount" + ":" + getTotalAmount()+ "," +
            "amountPaid" + ":" + getAmountPaid()+ "," +
            "debt" + ":" + getDebt()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "manager = "+(getManager()!=null?Integer.toHexString(System.identityHashCode(getManager())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 55 "../../../../IMSPersistence.ump"
  private static final long serialVersionUID = 8896099585515989380L ;

  
}