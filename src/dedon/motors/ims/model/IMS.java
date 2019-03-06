/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.io.Serializable;
import java.util.*;
import java.sql.Date;

// line 3 "../../../../IMSPersistence.ump"
// line 5 "../../../../IMS.ump"
public class IMS implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //IMS Associations
  private List<Product> products;
  private List<Warehouse> warehouse;
  private List<Customer> customers;
  private List<Transaction> transactions;
  private List<Manager> managers;
  private List<User> users;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public IMS()
  {
    products = new ArrayList<Product>();
    warehouse = new ArrayList<Warehouse>();
    customers = new ArrayList<Customer>();
    transactions = new ArrayList<Transaction>();
    managers = new ArrayList<Manager>();
    users = new ArrayList<User>();
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
  /* Code from template association_GetMany */
  public Warehouse getWarehouse(int index)
  {
    Warehouse aWarehouse = warehouse.get(index);
    return aWarehouse;
  }

  public List<Warehouse> getWarehouse()
  {
    List<Warehouse> newWarehouse = Collections.unmodifiableList(warehouse);
    return newWarehouse;
  }

  public int numberOfWarehouse()
  {
    int number = warehouse.size();
    return number;
  }

  public boolean hasWarehouse()
  {
    boolean has = warehouse.size() > 0;
    return has;
  }

  public int indexOfWarehouse(Warehouse aWarehouse)
  {
    int index = warehouse.indexOf(aWarehouse);
    return index;
  }
  /* Code from template association_GetMany */
  public Customer getCustomer(int index)
  {
    Customer aCustomer = customers.get(index);
    return aCustomer;
  }

  public List<Customer> getCustomers()
  {
    List<Customer> newCustomers = Collections.unmodifiableList(customers);
    return newCustomers;
  }

  public int numberOfCustomers()
  {
    int number = customers.size();
    return number;
  }

  public boolean hasCustomers()
  {
    boolean has = customers.size() > 0;
    return has;
  }

  public int indexOfCustomer(Customer aCustomer)
  {
    int index = customers.indexOf(aCustomer);
    return index;
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
  /* Code from template association_GetMany */
  public Manager getManager(int index)
  {
    Manager aManager = managers.get(index);
    return aManager;
  }

  public List<Manager> getManagers()
  {
    List<Manager> newManagers = Collections.unmodifiableList(managers);
    return newManagers;
  }

  public int numberOfManagers()
  {
    int number = managers.size();
    return number;
  }

  public boolean hasManagers()
  {
    boolean has = managers.size() > 0;
    return has;
  }

  public int indexOfManager(Manager aManager)
  {
    int index = managers.indexOf(aManager);
    return index;
  }
  /* Code from template association_GetMany */
  public User getUser(int index)
  {
    User aUser = users.get(index);
    return aUser;
  }

  public List<User> getUsers()
  {
    List<User> newUsers = Collections.unmodifiableList(users);
    return newUsers;
  }

  public int numberOfUsers()
  {
    int number = users.size();
    return number;
  }

  public boolean hasUsers()
  {
    boolean has = users.size() > 0;
    return has;
  }

  public int indexOfUser(User aUser)
  {
    int index = users.indexOf(aUser);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfProducts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Product addProduct(String aName)
  {
    return new Product(aName, this);
  }

  public boolean addProduct(Product aProduct)
  {
    boolean wasAdded = false;
    if (products.contains(aProduct)) { return false; }
    IMS existingIMS = aProduct.getIMS();
    boolean isNewIMS = existingIMS != null && !this.equals(existingIMS);
    if (isNewIMS)
    {
      aProduct.setIMS(this);
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
    //Unable to remove aProduct, as it must always have a iMS
    if (!this.equals(aProduct.getIMS()))
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfWarehouse()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Warehouse addWarehouse()
  {
    return new Warehouse(this);
  }

  public boolean addWarehouse(Warehouse aWarehouse)
  {
    boolean wasAdded = false;
    if (warehouse.contains(aWarehouse)) { return false; }
    IMS existingIMS = aWarehouse.getIMS();
    boolean isNewIMS = existingIMS != null && !this.equals(existingIMS);
    if (isNewIMS)
    {
      aWarehouse.setIMS(this);
    }
    else
    {
      warehouse.add(aWarehouse);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeWarehouse(Warehouse aWarehouse)
  {
    boolean wasRemoved = false;
    //Unable to remove aWarehouse, as it must always have a iMS
    if (!this.equals(aWarehouse.getIMS()))
    {
      warehouse.remove(aWarehouse);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addWarehouseAt(Warehouse aWarehouse, int index)
  {  
    boolean wasAdded = false;
    if(addWarehouse(aWarehouse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWarehouse()) { index = numberOfWarehouse() - 1; }
      warehouse.remove(aWarehouse);
      warehouse.add(index, aWarehouse);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWarehouseAt(Warehouse aWarehouse, int index)
  {
    boolean wasAdded = false;
    if(warehouse.contains(aWarehouse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWarehouse()) { index = numberOfWarehouse() - 1; }
      warehouse.remove(aWarehouse);
      warehouse.add(index, aWarehouse);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWarehouseAt(aWarehouse, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCustomers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Customer addCustomer()
  {
    return new Customer(this);
  }

  public boolean addCustomer(Customer aCustomer)
  {
    boolean wasAdded = false;
    if (customers.contains(aCustomer)) { return false; }
    IMS existingIMS = aCustomer.getIMS();
    boolean isNewIMS = existingIMS != null && !this.equals(existingIMS);
    if (isNewIMS)
    {
      aCustomer.setIMS(this);
    }
    else
    {
      customers.add(aCustomer);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCustomer(Customer aCustomer)
  {
    boolean wasRemoved = false;
    //Unable to remove aCustomer, as it must always have a iMS
    if (!this.equals(aCustomer.getIMS()))
    {
      customers.remove(aCustomer);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCustomerAt(Customer aCustomer, int index)
  {  
    boolean wasAdded = false;
    if(addCustomer(aCustomer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCustomers()) { index = numberOfCustomers() - 1; }
      customers.remove(aCustomer);
      customers.add(index, aCustomer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCustomerAt(Customer aCustomer, int index)
  {
    boolean wasAdded = false;
    if(customers.contains(aCustomer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCustomers()) { index = numberOfCustomers() - 1; }
      customers.remove(aCustomer);
      customers.add(index, aCustomer);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCustomerAt(aCustomer, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTransactions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Transaction addTransaction(Date aDate, Customer aCustomer, Manager aManager)
  {
    return new Transaction(aDate, aCustomer, aManager, this);
  }

  public boolean addTransaction(Transaction aTransaction)
  {
    boolean wasAdded = false;
    if (transactions.contains(aTransaction)) { return false; }
    IMS existingIMS = aTransaction.getIMS();
    boolean isNewIMS = existingIMS != null && !this.equals(existingIMS);
    if (isNewIMS)
    {
      aTransaction.setIMS(this);
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
    //Unable to remove aTransaction, as it must always have a iMS
    if (!this.equals(aTransaction.getIMS()))
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfManagers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Manager addManager(String aUserName, String aPassword)
  {
    return new Manager(aUserName, aPassword, this);
  }

  public boolean addManager(Manager aManager)
  {
    boolean wasAdded = false;
    if (managers.contains(aManager)) { return false; }
    IMS existingIMS = aManager.getIMS();
    boolean isNewIMS = existingIMS != null && !this.equals(existingIMS);
    if (isNewIMS)
    {
      aManager.setIMS(this);
    }
    else
    {
      managers.add(aManager);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeManager(Manager aManager)
  {
    boolean wasRemoved = false;
    //Unable to remove aManager, as it must always have a iMS
    if (!this.equals(aManager.getIMS()))
    {
      managers.remove(aManager);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addManagerAt(Manager aManager, int index)
  {  
    boolean wasAdded = false;
    if(addManager(aManager))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfManagers()) { index = numberOfManagers() - 1; }
      managers.remove(aManager);
      managers.add(index, aManager);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveManagerAt(Manager aManager, int index)
  {
    boolean wasAdded = false;
    if(managers.contains(aManager))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfManagers()) { index = numberOfManagers() - 1; }
      managers.remove(aManager);
      managers.add(index, aManager);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addManagerAt(aManager, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUsers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public User addUser(String aFirstName, String aLastName, UserRole... allRoles)
  {
    return new User(aFirstName, aLastName, this, allRoles);
  }

  public boolean addUser(User aUser)
  {
    boolean wasAdded = false;
    if (users.contains(aUser)) { return false; }
    IMS existingIMS = aUser.getIMS();
    boolean isNewIMS = existingIMS != null && !this.equals(existingIMS);
    if (isNewIMS)
    {
      aUser.setIMS(this);
    }
    else
    {
      users.add(aUser);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUser(User aUser)
  {
    boolean wasRemoved = false;
    //Unable to remove aUser, as it must always have a iMS
    if (!this.equals(aUser.getIMS()))
    {
      users.remove(aUser);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUserAt(User aUser, int index)
  {  
    boolean wasAdded = false;
    if(addUser(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUserAt(User aUser, int index)
  {
    boolean wasAdded = false;
    if(users.contains(aUser))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUsers()) { index = numberOfUsers() - 1; }
      users.remove(aUser);
      users.add(index, aUser);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUserAt(aUser, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (products.size() > 0)
    {
      Product aProduct = products.get(products.size() - 1);
      aProduct.delete();
      products.remove(aProduct);
    }
    
    while (warehouse.size() > 0)
    {
      Warehouse aWarehouse = warehouse.get(warehouse.size() - 1);
      aWarehouse.delete();
      warehouse.remove(aWarehouse);
    }
    
    while (customers.size() > 0)
    {
      Customer aCustomer = customers.get(customers.size() - 1);
      aCustomer.delete();
      customers.remove(aCustomer);
    }
    
    while (transactions.size() > 0)
    {
      Transaction aTransaction = transactions.get(transactions.size() - 1);
      aTransaction.delete();
      transactions.remove(aTransaction);
    }
    
    while (managers.size() > 0)
    {
      Manager aManager = managers.get(managers.size() - 1);
      aManager.delete();
      managers.remove(aManager);
    }
    
    while (users.size() > 0)
    {
      User aUser = users.get(users.size() - 1);
      aUser.delete();
      users.remove(aUser);
    }
    
  }

  // line 9 "../../../../IMSPersistence.ump"
   public void reinitialize(){
    User.reinitializeAutouniqueID(this.getUsers());
    Product.reinitializeUniqueName(this.getProducts());
    Manager.reinitializeUniqueUserName(this.getManagers());
    Transaction.reinitializeAutouniqueID(this.getTransactions());
  }

  // line 15 "../../../../IMS.ump"
   public java.util.Date getCurrentDate(){
    java.util.Calendar cal = java.util.Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    java.util.Date date = cal.getTime();
    return date;
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 6 "../../../../IMSPersistence.ump"
  private static final long serialVersionUID = -2683593616927798071L ;

  
}