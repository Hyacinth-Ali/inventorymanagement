/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.io.Serializable;
import java.util.*;

// line 75 "../../../../IMSPersistence.ump"
// line 97 "../../../../IMS.ump"
public class User implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String name;

  //User Associations
  private IMS iMS;
  private List<UserRole> roles;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aName, IMS aIMS)
  {
    // line 101 "../../../../IMS.ump"
    if(aName == null || aName.length() == 0 ) {
      		throw new RuntimeException("The name of a user cannot be empty");
      	}
      	if (aName.length() > 30) {
      		throw new RuntimeException("The name cannot be more than 30 characters");
      	}
    // END OF UMPLE BEFORE INJECTION
    name = aName;
    boolean didAddIMS = setIMS(aIMS);
    if (!didAddIMS)
    {
      throw new RuntimeException("Unable to create user due to iMS");
    }
    roles = new ArrayList<UserRole>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    // line 101 "../../../../IMS.ump"
    if(aName == null || aName.length() == 0 ) {
      		throw new RuntimeException("The name of a user cannot be empty");
      	}
      	if (aName.length() > 30) {
      		throw new RuntimeException("The name cannot be more than 30 characters");
      	}
    // END OF UMPLE BEFORE INJECTION
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template association_GetOne */
  public IMS getIMS()
  {
    return iMS;
  }
  /* Code from template association_GetMany */
  public UserRole getRole(int index)
  {
    UserRole aRole = roles.get(index);
    return aRole;
  }

  public List<UserRole> getRoles()
  {
    List<UserRole> newRoles = Collections.unmodifiableList(roles);
    return newRoles;
  }

  public int numberOfRoles()
  {
    int number = roles.size();
    return number;
  }

  public boolean hasRoles()
  {
    boolean has = roles.size() > 0;
    return has;
  }

  public int indexOfRole(UserRole aRole)
  {
    int index = roles.indexOf(aRole);
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
      existingIMS.removeUser(this);
    }
    iMS.addUser(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRoles()
  {
    return 0;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfRoles()
  {
    return 2;
  }
  /* Code from template association_AddOptionalNToOne */


  public boolean addRole(UserRole aRole)
  {
    boolean wasAdded = false;
    if (roles.contains(aRole)) { return false; }
    if (numberOfRoles() >= maximumNumberOfRoles())
    {
      return wasAdded;
    }

    User existingUser = aRole.getUser();
    boolean isNewUser = existingUser != null && !this.equals(existingUser);
    if (isNewUser)
    {
      aRole.setUser(this);
    }
    else
    {
      roles.add(aRole);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRole(UserRole aRole)
  {
    boolean wasRemoved = false;
    //Unable to remove aRole, as it must always have a user
    if (!this.equals(aRole.getUser()))
    {
      roles.remove(aRole);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRoleAt(UserRole aRole, int index)
  {  
    boolean wasAdded = false;
    if(addRole(aRole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoles()) { index = numberOfRoles() - 1; }
      roles.remove(aRole);
      roles.add(index, aRole);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRoleAt(UserRole aRole, int index)
  {
    boolean wasAdded = false;
    if(roles.contains(aRole))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRoles()) { index = numberOfRoles() - 1; }
      roles.remove(aRole);
      roles.add(index, aRole);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRoleAt(aRole, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    IMS placeholderIMS = iMS;
    this.iMS = null;
    if(placeholderIMS != null)
    {
      placeholderIMS.removeUser(this);
    }
    for(int i=roles.size(); i > 0; i--)
    {
      UserRole aRole = roles.get(i - 1);
      aRole.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 79 "../../../../IMSPersistence.ump"
  private static final long serialVersionUID = 386717976743499839L ;

  
}