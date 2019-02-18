/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.io.Serializable;
import java.util.*;

/**
 * class Warehouse
 * {
 * 0..1 -- * Product products;
 * }
 * class Manager
 * {
 * unique String username;
 * String password;
 * }
 */
// line 36 "../../../../IMSPersistence.ump"
// line 51 "../../../../IMS.ump"
public class Customer implements Serializable
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextId = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private String firstName;
  private String surName;

  //Autounique Attributes
  private int id;

  //Customer Associations
  private IMS iMS;
  private List<Transaction> transactions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(String aFirstName, String aSurName, IMS aIMS)
  {
    // line 57 "../../../../IMS.ump"
    if(aFirstName == null || aFirstName.length() == 0 ) {
      		throw new RuntimeException("The first name of a customer cannot be empty");
      	}
      	if (aFirstName.length() > 20) {
      		throw new RuntimeException("Customer first name character cannot be more than 20");
      	}
    // END OF UMPLE BEFORE INJECTION
    // line 66 "../../../../IMS.ump"
    if(aSurName == null || aSurName.length() == 0 ) {
      		throw new RuntimeException("The sur name of a customer cannot be empty");
      	}
      	if (aSurName.length() > 20) {
      		throw new RuntimeException("Customer sur name character cannot be more than 20");
      	}
    // END OF UMPLE BEFORE INJECTION
    firstName = aFirstName;
    surName = aSurName;
    id = nextId++;
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

  public boolean setFirstName(String aFirstName)
  {
    boolean wasSet = false;
    // line 57 "../../../../IMS.ump"
    if(aFirstName == null || aFirstName.length() == 0 ) {
      		throw new RuntimeException("The first name of a customer cannot be empty");
      	}
      	if (aFirstName.length() > 20) {
      		throw new RuntimeException("Customer first name character cannot be more than 20");
      	}
    // END OF UMPLE BEFORE INJECTION
    firstName = aFirstName;
    wasSet = true;
    return wasSet;
  }

  public boolean setSurName(String aSurName)
  {
    boolean wasSet = false;
    // line 66 "../../../../IMS.ump"
    if(aSurName == null || aSurName.length() == 0 ) {
      		throw new RuntimeException("The sur name of a customer cannot be empty");
      	}
      	if (aSurName.length() > 20) {
      		throw new RuntimeException("Customer sur name character cannot be more than 20");
      	}
    // END OF UMPLE BEFORE INJECTION
    surName = aSurName;
    wasSet = true;
    return wasSet;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getSurName()
  {
    return surName;
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
  public Transaction addTransaction(IMS aIMS)
  {
    return new Transaction(this, aIMS);
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
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "firstName" + ":" + getFirstName()+ "," +
            "surName" + ":" + getSurName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 39 "../../../../IMSPersistence.ump"
  private static final long serialVersionUID = 2315070137928790501L ;

  
}