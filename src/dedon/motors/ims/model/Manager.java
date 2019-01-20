/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.io.Serializable;
import java.util.*;

// line 9 "../../../../IMSPersistence.ump"
// line 17 "../../../../ims.ump"
public class Manager implements Serializable
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Manager> managersByUsername = new HashMap<String, Manager>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Manager Attributes
  private String name;
  private String username;
  private String password;

  //Manager Associations
  private IMS iMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Manager(String aName, String aUsername, String aPassword, IMS aIMS)
  {
    name = aName;
    password = aPassword;
    if (!setUsername(aUsername))
    {
      throw new RuntimeException("Cannot create due to duplicate username");
    }
    boolean didAddIMS = setIMS(aIMS);
    if (!didAddIMS)
    {
      throw new RuntimeException("Unable to create manager due to iMS");
    }
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

  public boolean setUsername(String aUsername)
  {
    boolean wasSet = false;
    String anOldUsername = getUsername();
    if (hasWithUsername(aUsername)) {
      return wasSet;
    }
    username = aUsername;
    wasSet = true;
    if (anOldUsername != null) {
      managersByUsername.remove(anOldUsername);
    }
    managersByUsername.put(aUsername, this);
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getUsername()
  {
    return username;
  }
  /* Code from template attribute_GetUnique */
  public static Manager getWithUsername(String aUsername)
  {
    return managersByUsername.get(aUsername);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithUsername(String aUsername)
  {
    return getWithUsername(aUsername) != null;
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
      existingIMS.removeManager(this);
    }
    iMS.addManager(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    managersByUsername.remove(getUsername());
    IMS placeholderIMS = iMS;
    this.iMS = null;
    if(placeholderIMS != null)
    {
      placeholderIMS.removeManager(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "username" + ":" + getUsername()+ "," +
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 12 "../../../../IMSPersistence.ump"
  private static final long serialVersionUID = 2315072607928790501L ;

  
}