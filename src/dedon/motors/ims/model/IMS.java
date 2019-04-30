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
  private List<Audit> audits;
  private Warehouse warehouse;
  private List<Supplier> suppliers;
  private List<Receipt> receipts;
  private List<Employee> employees;
  private List<Order> orders;
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
    audits = new ArrayList<Audit>();
    suppliers = new ArrayList<Supplier>();
    receipts = new ArrayList<Receipt>();
    employees = new ArrayList<Employee>();
    orders = new ArrayList<Order>();
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
  public Audit getAudit(int index)
  {
    Audit aAudit = audits.get(index);
    return aAudit;
  }

  public List<Audit> getAudits()
  {
    List<Audit> newAudits = Collections.unmodifiableList(audits);
    return newAudits;
  }

  public int numberOfAudits()
  {
    int number = audits.size();
    return number;
  }

  public boolean hasAudits()
  {
    boolean has = audits.size() > 0;
    return has;
  }

  public int indexOfAudit(Audit aAudit)
  {
    int index = audits.indexOf(aAudit);
    return index;
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
  public Supplier getSupplier(int index)
  {
    Supplier aSupplier = suppliers.get(index);
    return aSupplier;
  }

  public List<Supplier> getSuppliers()
  {
    List<Supplier> newSuppliers = Collections.unmodifiableList(suppliers);
    return newSuppliers;
  }

  public int numberOfSuppliers()
  {
    int number = suppliers.size();
    return number;
  }

  public boolean hasSuppliers()
  {
    boolean has = suppliers.size() > 0;
    return has;
  }

  public int indexOfSupplier(Supplier aSupplier)
  {
    int index = suppliers.indexOf(aSupplier);
    return index;
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
  /* Code from template association_GetMany */
  public Employee getEmployee(int index)
  {
    Employee aEmployee = employees.get(index);
    return aEmployee;
  }

  public List<Employee> getEmployees()
  {
    List<Employee> newEmployees = Collections.unmodifiableList(employees);
    return newEmployees;
  }

  public int numberOfEmployees()
  {
    int number = employees.size();
    return number;
  }

  public boolean hasEmployees()
  {
    boolean has = employees.size() > 0;
    return has;
  }

  public int indexOfEmployee(Employee aEmployee)
  {
    int index = employees.indexOf(aEmployee);
    return index;
  }
  /* Code from template association_GetMany */
  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
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
  public static int minimumNumberOfAudits()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Audit addAudit()
  {
    return new Audit(this);
  }

  public boolean addAudit(Audit aAudit)
  {
    boolean wasAdded = false;
    if (audits.contains(aAudit)) { return false; }
    IMS existingIMS = aAudit.getIMS();
    boolean isNewIMS = existingIMS != null && !this.equals(existingIMS);
    if (isNewIMS)
    {
      aAudit.setIMS(this);
    }
    else
    {
      audits.add(aAudit);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAudit(Audit aAudit)
  {
    boolean wasRemoved = false;
    //Unable to remove aAudit, as it must always have a iMS
    if (!this.equals(aAudit.getIMS()))
    {
      audits.remove(aAudit);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAuditAt(Audit aAudit, int index)
  {  
    boolean wasAdded = false;
    if(addAudit(aAudit))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAudits()) { index = numberOfAudits() - 1; }
      audits.remove(aAudit);
      audits.add(index, aAudit);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAuditAt(Audit aAudit, int index)
  {
    boolean wasAdded = false;
    if(audits.contains(aAudit))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAudits()) { index = numberOfAudits() - 1; }
      audits.remove(aAudit);
      audits.add(index, aAudit);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAuditAt(aAudit, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOptionalOneToOne */
  public boolean setWarehouse(Warehouse aNewWarehouse)
  {
    boolean wasSet = false;
    if (warehouse != null && !warehouse.equals(aNewWarehouse) && equals(warehouse.getIMS()))
    {
      //Unable to setWarehouse, as existing warehouse would become an orphan
      return wasSet;
    }

    warehouse = aNewWarehouse;
    IMS anOldIMS = aNewWarehouse != null ? aNewWarehouse.getIMS() : null;

    if (!this.equals(anOldIMS))
    {
      if (anOldIMS != null)
      {
        anOldIMS.warehouse = null;
      }
      if (warehouse != null)
      {
        warehouse.setIMS(this);
      }
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfSuppliers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Supplier addSupplier(String aName)
  {
    return new Supplier(aName, this);
  }

  public boolean addSupplier(Supplier aSupplier)
  {
    boolean wasAdded = false;
    if (suppliers.contains(aSupplier)) { return false; }
    IMS existingIMS = aSupplier.getIMS();
    boolean isNewIMS = existingIMS != null && !this.equals(existingIMS);
    if (isNewIMS)
    {
      aSupplier.setIMS(this);
    }
    else
    {
      suppliers.add(aSupplier);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSupplier(Supplier aSupplier)
  {
    boolean wasRemoved = false;
    //Unable to remove aSupplier, as it must always have a iMS
    if (!this.equals(aSupplier.getIMS()))
    {
      suppliers.remove(aSupplier);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addSupplierAt(Supplier aSupplier, int index)
  {  
    boolean wasAdded = false;
    if(addSupplier(aSupplier))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSuppliers()) { index = numberOfSuppliers() - 1; }
      suppliers.remove(aSupplier);
      suppliers.add(index, aSupplier);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSupplierAt(Supplier aSupplier, int index)
  {
    boolean wasAdded = false;
    if(suppliers.contains(aSupplier))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSuppliers()) { index = numberOfSuppliers() - 1; }
      suppliers.remove(aSupplier);
      suppliers.add(index, aSupplier);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSupplierAt(aSupplier, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfReceipts()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Receipt addReceipt(Date aDate, Transaction aTransaction)
  {
    return new Receipt(aDate, this, aTransaction);
  }

  public boolean addReceipt(Receipt aReceipt)
  {
    boolean wasAdded = false;
    if (receipts.contains(aReceipt)) { return false; }
    IMS existingIMS = aReceipt.getIMS();
    boolean isNewIMS = existingIMS != null && !this.equals(existingIMS);
    if (isNewIMS)
    {
      aReceipt.setIMS(this);
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
    //Unable to remove aReceipt, as it must always have a iMS
    if (!this.equals(aReceipt.getIMS()))
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfEmployees()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Employee addEmployee(String aPassword)
  {
    return new Employee(aPassword, this);
  }

  public boolean addEmployee(Employee aEmployee)
  {
    boolean wasAdded = false;
    if (employees.contains(aEmployee)) { return false; }
    IMS existingIMS = aEmployee.getIMS();
    boolean isNewIMS = existingIMS != null && !this.equals(existingIMS);
    if (isNewIMS)
    {
      aEmployee.setIMS(this);
    }
    else
    {
      employees.add(aEmployee);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeEmployee(Employee aEmployee)
  {
    boolean wasRemoved = false;
    //Unable to remove aEmployee, as it must always have a iMS
    if (!this.equals(aEmployee.getIMS()))
    {
      employees.remove(aEmployee);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addEmployeeAt(Employee aEmployee, int index)
  {  
    boolean wasAdded = false;
    if(addEmployee(aEmployee))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEmployees()) { index = numberOfEmployees() - 1; }
      employees.remove(aEmployee);
      employees.add(index, aEmployee);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEmployeeAt(Employee aEmployee, int index)
  {
    boolean wasAdded = false;
    if(employees.contains(aEmployee))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEmployees()) { index = numberOfEmployees() - 1; }
      employees.remove(aEmployee);
      employees.add(index, aEmployee);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEmployeeAt(aEmployee, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrders()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Order addOrder(Date aOrderedDate, Product... allProducts)
  {
    return new Order(aOrderedDate, this, allProducts);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    IMS existingIMS = aOrder.getIMS();
    boolean isNewIMS = existingIMS != null && !this.equals(existingIMS);
    if (isNewIMS)
    {
      aOrder.setIMS(this);
    }
    else
    {
      orders.add(aOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrder, as it must always have a iMS
    if (!this.equals(aOrder.getIMS()))
    {
      orders.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCustomers()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Customer addCustomer(String aCustomerID)
  {
    return new Customer(aCustomerID, this);
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
    return new Transaction(aDate, this, aCustomer, aManager);
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
  public User addUser(String aName, UserRole... allRoles)
  {
    return new User(aName, this, allRoles);
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
    
    while (audits.size() > 0)
    {
      Audit aAudit = audits.get(audits.size() - 1);
      aAudit.delete();
      audits.remove(aAudit);
    }
    
    Warehouse existingWarehouse = warehouse;
    warehouse = null;
    if (existingWarehouse != null)
    {
      existingWarehouse.delete();
      existingWarehouse.setIMS(null);
    }
    while (suppliers.size() > 0)
    {
      Supplier aSupplier = suppliers.get(suppliers.size() - 1);
      aSupplier.delete();
      suppliers.remove(aSupplier);
    }
    
    while (receipts.size() > 0)
    {
      Receipt aReceipt = receipts.get(receipts.size() - 1);
      aReceipt.delete();
      receipts.remove(aReceipt);
    }
    
    while (employees.size() > 0)
    {
      Employee aEmployee = employees.get(employees.size() - 1);
      aEmployee.delete();
      employees.remove(aEmployee);
    }
    
    while (orders.size() > 0)
    {
      Order aOrder = orders.get(orders.size() - 1);
      aOrder.delete();
      orders.remove(aOrder);
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

  // line 20 "../../../../IMS.ump"
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