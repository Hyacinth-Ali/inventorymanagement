/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.io.Serializable;
import java.util.*;

// line 76 "../../../../IMSPersistence.ump"
// line 84 "../../../../IMS.ump"
public class User implements Serializable
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextId = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String firstName;
  private String lastName;

  //Autounique Attributes
  private int id;

  //User Associations
  private List<UserRole> roles;
  private IMS iMS;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aFirstName, String aLastName, IMS aIMS, UserRole... allRoles)
  {
    // line 91 "../../../../IMS.ump"
    if(aFirstName == null || aFirstName.length() == 0 ) {
      		throw new RuntimeException("The first name of a user cannot be empty");
      	}
      	if (aFirstName.length() > 20) {
      		throw new RuntimeException("User first name character cannot be more than 20");
      	}
    // END OF UMPLE BEFORE INJECTION
    // line 100 "../../../../IMS.ump"
    if(aLastName == null || aLastName.length() == 0 ) {
      		throw new RuntimeException("The last name of a user cannot be empty");
      	}
      	if (aLastName.length() > 20) {
      		throw new RuntimeException("User last name character cannot be more than 20");
      	}
    // END OF UMPLE BEFORE INJECTION
    firstName = aFirstName;
    lastName = aLastName;
    id = nextId++;
    roles = new ArrayList<UserRole>();
    boolean didAddRoles = setRoles(allRoles);
    if (!didAddRoles)
    {
      throw new RuntimeException("Unable to create User, must have 1 to 2 roles");
    }
    boolean didAddIMS = setIMS(aIMS);
    if (!didAddIMS)
    {
      throw new RuntimeException("Unable to create user due to iMS");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFirstName(String aFirstName)
  {
    boolean wasSet = false;
    // line 91 "../../../../IMS.ump"
    if(aFirstName == null || aFirstName.length() == 0 ) {
      		throw new RuntimeException("The first name of a user cannot be empty");
      	}
      	if (aFirstName.length() > 20) {
      		throw new RuntimeException("User first name character cannot be more than 20");
      	}
    // END OF UMPLE BEFORE INJECTION
    firstName = aFirstName;
    wasSet = true;
    return wasSet;
  }

  public boolean setLastName(String aLastName)
  {
    boolean wasSet = false;
    // line 100 "../../../../IMS.ump"
    if(aLastName == null || aLastName.length() == 0 ) {
      		throw new RuntimeException("The last name of a user cannot be empty");
      	}
      	if (aLastName.length() > 20) {
      		throw new RuntimeException("User last name character cannot be more than 20");
      	}
    // END OF UMPLE BEFORE INJECTION
    lastName = aLastName;
    wasSet = true;
    return wasSet;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public int getId()
  {
    return id;
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
  /* Code from template association_GetOne */
  public IMS getIMS()
  {
    return iMS;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRoles()
  {
    return 1;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfRoles()
  {
    return 2;
  }
  /* Code from template association_AddUnidirectionalMN */
  public boolean addRole(UserRole aRole)
  {
    boolean wasAdded = false;
    if (roles.contains(aRole)) { return false; }
    if (numberOfRoles() < maximumNumberOfRoles())
    {
      roles.add(aRole);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean removeRole(UserRole aRole)
  {
    boolean wasRemoved = false;
    if (!roles.contains(aRole))
    {
      return wasRemoved;
    }

    if (numberOfRoles() <= minimumNumberOfRoles())
    {
      return wasRemoved;
    }

    roles.remove(aRole);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_SetUnidirectionalMN */
  public boolean setRoles(UserRole... newRoles)
  {
    boolean wasSet = false;
    ArrayList<UserRole> verifiedRoles = new ArrayList<UserRole>();
    for (UserRole aRole : newRoles)
    {
      if (verifiedRoles.contains(aRole))
      {
        continue;
      }
      verifiedRoles.add(aRole);
    }

    if (verifiedRoles.size() != newRoles.length || verifiedRoles.size() < minimumNumberOfRoles() || verifiedRoles.size() > maximumNumberOfRoles())
    {
      return wasSet;
    }

    roles.clear();
    roles.addAll(verifiedRoles);
    wasSet = true;
    return wasSet;
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

  public void delete()
  {
    roles.clear();
    IMS placeholderIMS = iMS;
    this.iMS = null;
    if(placeholderIMS != null)
    {
      placeholderIMS.removeUser(this);
    }
  }

  // line 83 "../../../../IMSPersistence.ump"
   public static  void reinitializeAutouniqueID(List<User> users){
    nextId = 0; 
    for (User user : users) {
      if (user.getId() > nextId) {
        nextId = user.getId();
      }
    }
    nextId++;
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "firstName" + ":" + getFirstName()+ "," +
            "lastName" + ":" + getLastName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 80 "../../../../IMSPersistence.ump"
  private static final long serialVersionUID = 386717976743499839L ;

  
}