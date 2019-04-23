/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;

// line 146 "../../../../IMS.ump"
public class Employee extends UserRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Employee Attributes
  private String password;

  //Employee Associations
  private IMS iMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Employee(String aPassword, IMS aIMS)
  {
    super();
    // line 151 "../../../../IMS.ump"
    if(aPassword == null || aPassword.length() == 0 ) {
      		throw new RuntimeException("The password cannot be empty");
      	}
      	if (aPassword.length() > 10 || aPassword.length() < 5) {
      		throw new RuntimeException("The password should be between 5 to 10 characters");
      	}
    // END OF UMPLE BEFORE INJECTION
    password = aPassword;
    boolean didAddIMS = setIMS(aIMS);
    if (!didAddIMS)
    {
      throw new RuntimeException("Unable to create employee due to iMS");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    // line 151 "../../../../IMS.ump"
    if(aPassword == null || aPassword.length() == 0 ) {
      		throw new RuntimeException("The password cannot be empty");
      	}
      	if (aPassword.length() > 10 || aPassword.length() < 5) {
      		throw new RuntimeException("The password should be between 5 to 10 characters");
      	}
    // END OF UMPLE BEFORE INJECTION
    password = aPassword;
    wasSet = true;
    return wasSet;
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
      existingIMS.removeEmployee(this);
    }
    iMS.addEmployee(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    IMS placeholderIMS = iMS;
    this.iMS = null;
    if(placeholderIMS != null)
    {
      placeholderIMS.removeEmployee(this);
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null");
  }
}