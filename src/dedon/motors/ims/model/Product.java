/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.io.Serializable;
import java.util.*;

// line 22 "../../../../IMSPersistence.ump"
// line 24 "../../../../IMS.ump"
public class Product implements Serializable
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Product> productsByName = new HashMap<String, Product>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Product Attributes
  private String name;
  private int unitprice;
  private int quantity;

  //Product Associations
  private IMS iMS;
  private Warehouse warehouse;
  private List<Transaction> transactions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Product(String aName, IMS aIMS)
  {
    // line 31 "../../../../IMS.ump"
    if(aName == null || aName.length() == 0 ) {
      		throw new RuntimeException("The name of a product cannot be empty");
      	}
      	if (aName.length() > 30) {
      		throw new RuntimeException("Product character cannot be more than 30");
      	}
    // END OF UMPLE BEFORE INJECTION
    unitprice = 0;
    quantity = 0;
    if (!setName(aName))
    {
      throw new RuntimeException("Cannot create due to duplicate name");
    }
    boolean didAddIMS = setIMS(aIMS);
    if (!didAddIMS)
    {
      throw new RuntimeException("Unable to create product due to iMS");
    }
    transactions = new ArrayList<Transaction>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    // line 31 "../../../../IMS.ump"
    if(aName == null || aName.length() == 0 ) {
      		throw new RuntimeException("The name of a product cannot be empty");
      	}
      	if (aName.length() > 30) {
      		throw new RuntimeException("Product character cannot be more than 30");
      	}
    // END OF UMPLE BEFORE INJECTION
    String anOldName = getName();
    if (hasWithName(aName)) {
      return wasSet;
    }
    name = aName;
    wasSet = true;
    if (anOldName != null) {
      productsByName.remove(anOldName);
    }
    productsByName.put(aName, this);
    return wasSet;
  }

  public boolean setUnitprice(int aUnitprice)
  {
    boolean wasSet = false;
    unitprice = aUnitprice;
    wasSet = true;
    return wasSet;
  }

  public boolean setQuantity(int aQuantity)
  {
    boolean wasSet = false;
    quantity = aQuantity;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template attribute_GetUnique */
  public static Product getWithName(String aName)
  {
    return productsByName.get(aName);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithName(String aName)
  {
    return getWithName(aName) != null;
  }

  public int getUnitprice()
  {
    return unitprice;
  }

  public int getQuantity()
  {
    return quantity;
  }
  /* Code from template association_GetOne */
  public IMS getIMS()
  {
    return iMS;
  }
  /* Code from template association_GetOne */
  public Warehouse getWarehouse()
  {
    return warehouse;
  }

  public boolean hasWarehouse()
  {
    boolean has = warehouse != null;
    return has;
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
      existingIMS.removeProduct(this);
    }
    iMS.addProduct(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setWarehouse(Warehouse aWarehouse)
  {
    boolean wasSet = false;
    Warehouse existingWarehouse = warehouse;
    warehouse = aWarehouse;
    if (existingWarehouse != null && !existingWarehouse.equals(aWarehouse))
    {
      existingWarehouse.removeProduct(this);
    }
    if (aWarehouse != null)
    {
      aWarehouse.addProduct(this);
    }
    wasSet = true;
    return wasSet;
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
    if (aTransaction.indexOfProduct(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTransaction.addProduct(this);
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
    if (aTransaction.indexOfProduct(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTransaction.removeProduct(this);
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
    productsByName.remove(getName());
    IMS placeholderIMS = iMS;
    this.iMS = null;
    if(placeholderIMS != null)
    {
      placeholderIMS.removeProduct(this);
    }
    if (warehouse != null)
    {
      Warehouse placeholderWarehouse = warehouse;
      this.warehouse = null;
      placeholderWarehouse.removeProduct(this);
    }
    ArrayList<Transaction> copyOfTransactions = new ArrayList<Transaction>(transactions);
    transactions.clear();
    for(Transaction aTransaction : copyOfTransactions)
    {
      aTransaction.removeProduct(this);
    }
  }

  // line 28 "../../../../IMSPersistence.ump"
   public static  void reinitializeUniqueName(List<Product> products){
    productsByName = new HashMap<String, Product>();
    for (Product product : products) {
      productsByName.put(product.getName(), product);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "unitprice" + ":" + getUnitprice()+ "," +
            "quantity" + ":" + getQuantity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "warehouse = "+(getWarehouse()!=null?Integer.toHexString(System.identityHashCode(getWarehouse())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 25 "../../../../IMSPersistence.ump"
  private static final long serialVersionUID = 8896099581655989380L ;

  
}