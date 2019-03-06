/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.io.Serializable;
import java.util.*;
import java.sql.Date;

// line 16 "../../../../IMSPersistence.ump"
// line 52 "../../../../IMS.ump"
public class Manager extends UserRole implements Serializable
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Manager> managersByUserName = new HashMap<String, Manager>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Manager Attributes
  private String userName;
  private String password;

  //Manager Associations
  private IMS iMS;
  private List<Transaction> transactions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Manager(String aUserName, String aPassword, IMS aIMS)
  {
    super();
    // line 59 "../../../../IMS.ump"
    if(aUserName == null || aUserName.length() == 0 ) {
      		throw new RuntimeException("The user name of a manager cannot be empty");
      	}
      	if (aUserName.length() > 10 || aUserName.length() < 5) {
      		throw new RuntimeException("Manager user name character should be between 5 to 10 characters");
      	}
    // END OF UMPLE BEFORE INJECTION
    password = aPassword;
    if (!setUserName(aUserName))
    {
      throw new RuntimeException("Cannot create due to duplicate userName");
    }
    boolean didAddIMS = setIMS(aIMS);
    if (!didAddIMS)
    {
      throw new RuntimeException("Unable to create manager due to iMS");
    }
    transactions = new ArrayList<Transaction>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setUserName(String aUserName)
  {
    boolean wasSet = false;
    // line 59 "../../../../IMS.ump"
    if(aUserName == null || aUserName.length() == 0 ) {
      		throw new RuntimeException("The user name of a manager cannot be empty");
      	}
      	if (aUserName.length() > 10 || aUserName.length() < 5) {
      		throw new RuntimeException("Manager user name character should be between 5 to 10 characters");
      	}
    // END OF UMPLE BEFORE INJECTION
    String anOldUserName = getUserName();
    if (hasWithUserName(aUserName)) {
      return wasSet;
    }
    userName = aUserName;
    wasSet = true;
    if (anOldUserName != null) {
      managersByUserName.remove(anOldUserName);
    }
    managersByUserName.put(aUserName, this);
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public String getUserName()
  {
    return userName;
  }
  /* Code from template attribute_GetUnique */
  public static Manager getWithUserName(String aUserName)
  {
    return managersByUserName.get(aUserName);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithUserName(String aUserName)
  {
    return getWithUserName(aUserName) != null;
  }

  public String getPassword()
  {
    return password;
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
      existingIMS.removeManager(this);
    }
    iMS.addManager(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTransactions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Transaction addTransaction(Date aDate, Customer aCustomer, IMS aIMS)
  {
    return new Transaction(aDate, aCustomer, this, aIMS);
  }

  public boolean addTransaction(Transaction aTransaction)
  {
    boolean wasAdded = false;
    if (transactions.contains(aTransaction)) { return false; }
    Manager existingManager = aTransaction.getManager();
    boolean isNewManager = existingManager != null && !this.equals(existingManager);
    if (isNewManager)
    {
      aTransaction.setManager(this);
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
    //Unable to remove aTransaction, as it must always have a manager
    if (!this.equals(aTransaction.getManager()))
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
    managersByUserName.remove(getUserName());
    IMS placeholderIMS = iMS;
    this.iMS = null;
    if(placeholderIMS != null)
    {
      placeholderIMS.removeManager(this);
    }
    for(int i=transactions.size(); i > 0; i--)
    {
      Transaction aTransaction = transactions.get(i - 1);
      aTransaction.delete();
    }
    super.delete();
  }

  // line 22 "../../../../IMSPersistence.ump"
   public static  void reinitializeUniqueUserName(List<Manager> managers){
    managersByUserName = new HashMap<String, Manager>();
    for (Manager manager : managers) {
      managersByUserName.put(manager.getUserName(), manager);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "userName" + ":" + getUserName()+ "," +
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 19 "../../../../IMSPersistence.ump"
  private static final long serialVersionUID = 2315072607928790501L ;

  
}