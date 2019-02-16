/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.io.Serializable;
import java.sql.Date;

// line 43 "../../../../IMSPersistence.ump"
// line 61 "../../../../IMS.ump"
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
  private Customer buyer;
  private Manager manager;
  private IMS iMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transaction(Date aDate, int aTotalAmount, int aAmountPaid, Customer aBuyer, Manager aManager, IMS aIMS)
  {
    date = aDate;
    totalAmount = aTotalAmount;
    amountPaid = aAmountPaid;
    debt = totalAmount - amountPaid;
    boolean didAddBuyer = setBuyer(aBuyer);
    if (!didAddBuyer)
    {
      throw new RuntimeException("Unable to create transaction due to buyer");
    }
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
  /* Code from template association_GetOne */
  public Customer getBuyer()
  {
    return buyer;
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
  public boolean setBuyer(Customer aBuyer)
  {
    boolean wasSet = false;
    if (aBuyer == null)
    {
      return wasSet;
    }

    Customer existingBuyer = buyer;
    buyer = aBuyer;
    if (existingBuyer != null && !existingBuyer.equals(aBuyer))
    {
      existingBuyer.removeTransaction(this);
    }
    buyer.addTransaction(this);
    wasSet = true;
    return wasSet;
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
    Customer placeholderBuyer = buyer;
    this.buyer = null;
    if(placeholderBuyer != null)
    {
      placeholderBuyer.removeTransaction(this);
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


  public String toString()
  {
    return super.toString() + "["+
            "totalAmount" + ":" + getTotalAmount()+ "," +
            "amountPaid" + ":" + getAmountPaid()+ "," +
            "debt" + ":" + getDebt()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "buyer = "+(getBuyer()!=null?Integer.toHexString(System.identityHashCode(getBuyer())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "manager = "+(getManager()!=null?Integer.toHexString(System.identityHashCode(getManager())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 46 "../../../../IMSPersistence.ump"
  private static final long serialVersionUID = 8896099585515989380L ;

  
}