/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.util.*;

// line 68 "../../../../IMS.ump"
public abstract class UserRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UserRole Attributes
  private String name;
  private String address;

  //UserRole Associations
  private List<Transaction> transactions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UserRole(String aName, String aAddress)
  {
    name = aName;
    address = aAddress;
    transactions = new ArrayList<Transaction>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTransactions()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addTransaction(Transaction aTransaction)
  {
    boolean wasAdded = false;
    if (transactions.contains(aTransaction)) { return false; }
    transactions.add(aTransaction);
    if (aTransaction.indexOfUserRole(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTransaction.addUserRole(this);
      if (!wasAdded)
      {
        transactions.remove(aTransaction);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeTransaction(Transaction aTransaction)
  {
    boolean wasRemoved = false;
    if (!transactions.contains(aTransaction))
    {
      return wasRemoved;
    }

    int oldIndex = transactions.indexOf(aTransaction);
    transactions.remove(oldIndex);
    if (aTransaction.indexOfUserRole(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTransaction.removeUserRole(this);
      if (!wasRemoved)
      {
        transactions.add(oldIndex,aTransaction);
      }
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
    ArrayList<Transaction> copyOfTransactions = new ArrayList<Transaction>(transactions);
    transactions.clear();
    for(Transaction aTransaction : copyOfTransactions)
    {
      if (aTransaction.numberOfUserRoles() <= Transaction.minimumNumberOfUserRoles())
      {
        aTransaction.delete();
      }
      else
      {
        aTransaction.removeUserRole(this);
      }
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "address" + ":" + getAddress()+ "]";
  }
}