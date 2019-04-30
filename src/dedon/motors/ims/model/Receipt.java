/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.sql.Date;

// line 131 "../../../../IMS.ump"
public class Receipt
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Receipt Attributes
  private Date date;

  //Receipt Associations
  private IMS iMS;
  private Transaction transaction;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Receipt(Date aDate, IMS aIMS, Transaction aTransaction)
  {
    date = aDate;
    boolean didAddIMS = setIMS(aIMS);
    if (!didAddIMS)
    {
      throw new RuntimeException("Unable to create receipt due to iMS");
    }
    boolean didAddTransaction = setTransaction(aTransaction);
    if (!didAddTransaction)
    {
      throw new RuntimeException("Unable to create receipt due to transaction");
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

  public Date getDate()
  {
    return date;
  }
  /* Code from template association_GetOne */
  public IMS getIMS()
  {
    return iMS;
  }
  /* Code from template association_GetOne */
  public Transaction getTransaction()
  {
    return transaction;
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
      existingIMS.removeReceipt(this);
    }
    iMS.addReceipt(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setTransaction(Transaction aTransaction)
  {
    boolean wasSet = false;
    if (aTransaction == null)
    {
      return wasSet;
    }

    Transaction existingTransaction = transaction;
    transaction = aTransaction;
    if (existingTransaction != null && !existingTransaction.equals(aTransaction))
    {
      existingTransaction.removeReceipt(this);
    }
    transaction.addReceipt(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    IMS placeholderIMS = iMS;
    this.iMS = null;
    if(placeholderIMS != null)
    {
      placeholderIMS.removeReceipt(this);
    }
    Transaction placeholderTransaction = transaction;
    this.transaction = null;
    if(placeholderTransaction != null)
    {
      placeholderTransaction.removeReceipt(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "transaction = "+(getTransaction()!=null?Integer.toHexString(System.identityHashCode(getTransaction())):"null");
  }
}