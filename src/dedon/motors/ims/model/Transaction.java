/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;

// line 51 "../../../../IMSPersistence.ump"
// line 90 "../../../../IMS.ump"
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
  private double totalAmount;
  private double amountPaid;

  //Autounique Attributes
  private int id;

  //Transaction Associations
  private IMS iMS;
  private Customer customer;
  private List<Product> products;
  private Manager manager;
  private List<Receipt> receipts;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transaction(Date aDate, IMS aIMS, Customer aCustomer, Manager aManager)
  {
    date = aDate;
    totalAmount = 0;
    amountPaid = 0;
    id = nextId++;
    boolean didAddIMS = setIMS(aIMS);
    if (!didAddIMS)
    {
      throw new RuntimeException("Unable to create transaction due to iMS");
    }
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
    receipts = new ArrayList<Receipt>();
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

  public boolean setTotalAmount(double aTotalAmount)
  {
    boolean wasSet = false;
    totalAmount = aTotalAmount;
    wasSet = true;
    return wasSet;
  }

  public boolean setAmountPaid(double aAmountPaid)
  {
    boolean wasSet = false;
    amountPaid = aAmountPaid;
    wasSet = true;
    return wasSet;
  }

  public Date getDate()
  {
    return date;
  }

  public double getTotalAmount()
  {
    return totalAmount;
  }

  public double getAmountPaid()
  {
    return amountPaid;
  }

  public int getId()
  {
    return id;
  }
  /* Code from template association_GetOne */
  public IMS getIMS()
  {
    return iMS;
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
  /* Code from template association_GetMany */
  public Receipt getReceipt(int index)
  {
    Receipt aReceipt = receipts.get(index);
    return aReceipt;
  }

  public List<Receipt> getReceipts()
  {
    List<Receipt> newReceipts = Collections.unmodifiableList(receipts);
    return newReceipts;
  }

  public int numberOfReceipts()
  {
    int number = receipts.size();
    return number;
  }

  public boolean hasReceipts()
  {
    boolean has = receipts.size() > 0;
    return has;
  }

  public int indexOfReceipt(Receipt aReceipt)
  {
    int index = receipts.indexOf(aReceipt);
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
      existingIMS.removeTransaction(this);
    }
    iMS.addTransaction(this);
    wasSet = true;
    return wasSet;
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
  /* Code from template association_AddUnidirectionalMany */
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
    if (products.contains(aProduct))
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfReceipts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Receipt addReceipt(Date aDate, IMS aIMS)
  {
    return new Receipt(aDate, aIMS, this);
  }

  public boolean addReceipt(Receipt aReceipt)
  {
    boolean wasAdded = false;
    if (receipts.contains(aReceipt)) { return false; }
    Transaction existingTransaction = aReceipt.getTransaction();
    boolean isNewTransaction = existingTransaction != null && !this.equals(existingTransaction);
    if (isNewTransaction)
    {
      aReceipt.setTransaction(this);
    }
    else
    {
      receipts.add(aReceipt);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeReceipt(Receipt aReceipt)
  {
    boolean wasRemoved = false;
    //Unable to remove aReceipt, as it must always have a transaction
    if (!this.equals(aReceipt.getTransaction()))
    {
      receipts.remove(aReceipt);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addReceiptAt(Receipt aReceipt, int index)
  {  
    boolean wasAdded = false;
    if(addReceipt(aReceipt))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReceipts()) { index = numberOfReceipts() - 1; }
      receipts.remove(aReceipt);
      receipts.add(index, aReceipt);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveReceiptAt(Receipt aReceipt, int index)
  {
    boolean wasAdded = false;
    if(receipts.contains(aReceipt))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfReceipts()) { index = numberOfReceipts() - 1; }
      receipts.remove(aReceipt);
      receipts.add(index, aReceipt);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addReceiptAt(aReceipt, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    IMS placeholderIMS = iMS;
    this.iMS = null;
    if(placeholderIMS != null)
    {
      placeholderIMS.removeTransaction(this);
    }
    Customer placeholderCustomer = customer;
    this.customer = null;
    if(placeholderCustomer != null)
    {
      placeholderCustomer.removeTransaction(this);
    }
    products.clear();
    Manager placeholderManager = manager;
    this.manager = null;
    if(placeholderManager != null)
    {
      placeholderManager.removeTransaction(this);
    }
    for(int i=receipts.size(); i > 0; i--)
    {
      Receipt aReceipt = receipts.get(i - 1);
      aReceipt.delete();
    }
  }

  // line 57 "../../../../IMSPersistence.ump"
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
            "amountPaid" + ":" + getAmountPaid()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "manager = "+(getManager()!=null?Integer.toHexString(System.identityHashCode(getManager())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 54 "../../../../IMSPersistence.ump"
  private static final long serialVersionUID = 8896099585515989380L ;

  
}