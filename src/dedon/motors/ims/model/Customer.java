/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.io.Serializable;
import java.util.*;
import java.sql.Date;

// line 45 "../../../../IMSPersistence.ump"
// line 94 "../../../../IMS.ump"
public class Customer extends UserRole implements Serializable
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Customer> customersByCustomerID = new HashMap<String, Customer>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private String customerID;
  private double debt;

  //Customer Associations
  private IMS iMS;
  private List<Transaction> transactions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(String aCustomerID, IMS aIMS)
  {
    super();
    debt = 0;
    if (!setCustomerID(aCustomerID))
    {
      throw new RuntimeException("Cannot create due to duplicate customerID");
    }
    boolean didAddIMS = setIMS(aIMS);
    if (!didAddIMS)
    {
      throw new RuntimeException("Unable to create customer due to iMS");
    }
    transactions = new ArrayList<Transaction>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCustomerID(String aCustomerID)
  {
    boolean wasSet = false;
    String anOldCustomerID = getCustomerID();
    if (hasWithCustomerID(aCustomerID)) {
      return wasSet;
    }
    customerID = aCustomerID;
    wasSet = true;
    if (anOldCustomerID != null) {
      customersByCustomerID.remove(anOldCustomerID);
    }
    customersByCustomerID.put(aCustomerID, this);
    return wasSet;
  }

  public boolean setDebt(double aDebt)
  {
    boolean wasSet = false;
    debt = aDebt;
    wasSet = true;
    return wasSet;
  }

  public String getCustomerID()
  {
    return customerID;
  }
  /* Code from template attribute_GetUnique */
  public static Customer getWithCustomerID(String aCustomerID)
  {
    return customersByCustomerID.get(aCustomerID);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithCustomerID(String aCustomerID)
  {
    return getWithCustomerID(aCustomerID) != null;
  }

  public double getDebt()
  {
    return debt;
  }
  /* Code from template association_GetOne */
  public IMS getIMS()
  {
    return iMS;
  }
  /* Code from template association_GetMany */
  public Transaction getTransaction(int index)
  {
    Transaction aTransaction = transactions.get(index);
    return aTransaction;
  }

  public List<Transaction> getTransactions()
  {
    List<Transaction> newTransactions = Collections.unmodifiableList(transactions);
    return newTransactions;
  }

  public int numberOfTransactions()
  {
    int number = transactions.size();
    return number;
  }

  public boolean hasTransactions()
  {
    boolean has = transactions.size() > 0;
    return has;
  }

  public int indexOfTransaction(Transaction aTransaction)
  {
    int index = transactions.indexOf(aTransaction);
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
      existingIMS.removeCustomer(this);
    }
    iMS.addCustomer(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTransactions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Transaction addTransaction(Date aDate, IMS aIMS, Manager aManager)
  {
    return new Transaction(aDate, aIMS, this, aManager);
  }

  public boolean addTransaction(Transaction aTransaction)
  {
    boolean wasAdded = false;
    if (transactions.contains(aTransaction)) { return false; }
    Customer existingCustomer = aTransaction.getCustomer();
    boolean isNewCustomer = existingCustomer != null && !this.equals(existingCustomer);
    if (isNewCustomer)
    {
      aTransaction.setCustomer(this);
    }
    else
    {
      transactions.add(aTransaction);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTransaction(Transaction aTransaction)
  {
    boolean wasRemoved = false;
    //Unable to remove aTransaction, as it must always have a customer
    if (!this.equals(aTransaction.getCustomer()))
    {
      transactions.remove(aTransaction);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTransactionAt(Transaction aTransaction, int index)
  {  
    boolean wasAdded = false;
    if(addTransaction(aTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransactions()) { index = numberOfTransactions() - 1; }
      transactions.remove(aTransaction);
      transactions.add(index, aTransaction);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTransactionAt(Transaction aTransaction, int index)
  {
    boolean wasAdded = false;
    if(transactions.contains(aTransaction))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTransactions()) { index = numberOfTransactions() - 1; }
      transactions.remove(aTransaction);
      transactions.add(index, aTransaction);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTransactionAt(aTransaction, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    customersByCustomerID.remove(getCustomerID());
    IMS placeholderIMS = iMS;
    this.iMS = null;
    if(placeholderIMS != null)
    {
      placeholderIMS.removeCustomer(this);
    }
    for(int i=transactions.size(); i > 0; i--)
    {
      Transaction aTransaction = transactions.get(i - 1);
      aTransaction.delete();
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "customerID" + ":" + getCustomerID()+ "," +
            "debt" + ":" + getDebt()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 48 "../../../../IMSPersistence.ump"
  private static final long serialVersionUID = 2315070137928790501L ;

  
}