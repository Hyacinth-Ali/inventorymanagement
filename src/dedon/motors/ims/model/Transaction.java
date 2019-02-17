/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;

// line 43 "../../../../IMSPersistence.ump"
// line 59 "../../../../IMS.ump"
public class Transaction implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transaction Attributes
  private Date date;
  private int totalAmount;
  private int amountPaid;
  private int debt;

  //Transaction Associations
  private List<UserRole> userRoles;
  private List<Product> products;
  private IMS iMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transaction(Date aDate, int aTotalAmount, int aAmountPaid, IMS aIMS, UserRole... allUserRoles)
  {
    date = aDate;
    totalAmount = aTotalAmount;
    amountPaid = aAmountPaid;
    debt = totalAmount - amountPaid;
    userRoles = new ArrayList<UserRole>();
    boolean didAddUserRoles = setUserRoles(allUserRoles);
    if (!didAddUserRoles)
    {
      throw new RuntimeException("Unable to create Transaction, must have 1 to 2 userRoles");
    }
    products = new ArrayList<Product>();
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
  /* Code from template association_GetMany */
  public UserRole getUserRole(int index)
  {
    UserRole aUserRole = userRoles.get(index);
    return aUserRole;
  }

  public List<UserRole> getUserRoles()
  {
    List<UserRole> newUserRoles = Collections.unmodifiableList(userRoles);
    return newUserRoles;
  }

  public int numberOfUserRoles()
  {
    int number = userRoles.size();
    return number;
  }

  public boolean hasUserRoles()
  {
    boolean has = userRoles.size() > 0;
    return has;
  }

  public int indexOfUserRole(UserRole aUserRole)
  {
    int index = userRoles.indexOf(aUserRole);
    return index;
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
  public IMS getIMS()
  {
    return iMS;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfUserRolesValid()
  {
    boolean isValid = numberOfUserRoles() >= minimumNumberOfUserRoles() && numberOfUserRoles() <= maximumNumberOfUserRoles();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUserRoles()
  {
    return 1;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfUserRoles()
  {
    return 2;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addUserRole(UserRole aUserRole)
  {
    boolean wasAdded = false;
    if (userRoles.contains(aUserRole)) { return false; }
    if (numberOfUserRoles() >= maximumNumberOfUserRoles())
    {
      return wasAdded;
    }

    userRoles.add(aUserRole);
    if (aUserRole.indexOfTransaction(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aUserRole.addTransaction(this);
      if (!wasAdded)
      {
        userRoles.remove(aUserRole);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMNToMany */
  public boolean removeUserRole(UserRole aUserRole)
  {
    boolean wasRemoved = false;
    if (!userRoles.contains(aUserRole))
    {
      return wasRemoved;
    }

    if (numberOfUserRoles() <= minimumNumberOfUserRoles())
    {
      return wasRemoved;
    }

    int oldIndex = userRoles.indexOf(aUserRole);
    userRoles.remove(oldIndex);
    if (aUserRole.indexOfTransaction(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aUserRole.removeTransaction(this);
      if (!wasRemoved)
      {
        userRoles.add(oldIndex,aUserRole);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMNToMany */
  public boolean setUserRoles(UserRole... newUserRoles)
  {
    boolean wasSet = false;
    ArrayList<UserRole> verifiedUserRoles = new ArrayList<UserRole>();
    for (UserRole aUserRole : newUserRoles)
    {
      if (verifiedUserRoles.contains(aUserRole))
      {
        continue;
      }
      verifiedUserRoles.add(aUserRole);
    }

    if (verifiedUserRoles.size() != newUserRoles.length || verifiedUserRoles.size() < minimumNumberOfUserRoles() || verifiedUserRoles.size() > maximumNumberOfUserRoles())
    {
      return wasSet;
    }

    ArrayList<UserRole> oldUserRoles = new ArrayList<UserRole>(userRoles);
    userRoles.clear();
    for (UserRole aNewUserRole : verifiedUserRoles)
    {
      userRoles.add(aNewUserRole);
      if (oldUserRoles.contains(aNewUserRole))
      {
        oldUserRoles.remove(aNewUserRole);
      }
      else
      {
        aNewUserRole.addTransaction(this);
      }
    }

    for (UserRole anOldUserRole : oldUserRoles)
    {
      anOldUserRole.removeTransaction(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserRoleAt(UserRole aUserRole, int index)
  {  
    boolean wasAdded = false;
    if(addUserRole(aUserRole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUserRoles()) { index = numberOfUserRoles() - 1; }
      userRoles.remove(aUserRole);
      userRoles.add(index, aUserRole);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserRoleAt(UserRole aUserRole, int index)
  {
    boolean wasAdded = false;
    if(userRoles.contains(aUserRole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUserRoles()) { index = numberOfUserRoles() - 1; }
      userRoles.remove(aUserRole);
      userRoles.add(index, aUserRole);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserRoleAt(aUserRole, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfProducts()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addProduct(Product aProduct)
  {
    boolean wasAdded = false;
    if (products.contains(aProduct)) { return false; }
    products.add(aProduct);
    if (aProduct.indexOfTransaction(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aProduct.addTransaction(this);
      if (!wasAdded)
      {
        products.remove(aProduct);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeProduct(Product aProduct)
  {
    boolean wasRemoved = false;
    if (!products.contains(aProduct))
    {
      return wasRemoved;
    }

    int oldIndex = products.indexOf(aProduct);
    products.remove(oldIndex);
    if (aProduct.indexOfTransaction(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aProduct.removeTransaction(this);
      if (!wasRemoved)
      {
        products.add(oldIndex,aProduct);
      }
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
      existingIMS.removeTransaction(this);
    }
    iMS.addTransaction(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<UserRole> copyOfUserRoles = new ArrayList<UserRole>(userRoles);
    userRoles.clear();
    for(UserRole aUserRole : copyOfUserRoles)
    {
      aUserRole.removeTransaction(this);
    }
    ArrayList<Product> copyOfProducts = new ArrayList<Product>(products);
    products.clear();
    for(Product aProduct : copyOfProducts)
    {
      aProduct.removeTransaction(this);
    }
    IMS placeholderIMS = iMS;
    this.iMS = null;
    if(placeholderIMS != null)
    {
      placeholderIMS.removeTransaction(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "totalAmount" + ":" + getTotalAmount()+ "," +
            "amountPaid" + ":" + getAmountPaid()+ "," +
            "debt" + ":" + getDebt()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 46 "../../../../IMSPersistence.ump"
  private static final long serialVersionUID = 8896099585515989380L ;

  
}