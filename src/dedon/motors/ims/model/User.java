/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;
import java.io.Serializable;
import java.util.*;

// line 76 "../../../../IMSPersistence.ump"
// line 107 "../../../../IMS.ump"
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

  public User(String aName, IMS aIMS, UserRole... allRoles)
  {
    // line 111 "../../../../IMS.ump"
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
    boolean didAddRoles = setRoles(allRoles);
    if (!didAddRoles)
    {
      throw new RuntimeException("Unable to create User, must have 1 to 2 roles");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    // line 111 "../../../../IMS.ump"
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
    return 1;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfRoles()
  {
    return 2;
  }
  /* Code from template association_AddMNToOptionalOne */
  public boolean addRole(UserRole aRole)
  {
    boolean wasAdded = false;
    if (roles.contains(aRole)) { return false; }
    if (numberOfRoles() >= maximumNumberOfRoles())
    {
      return wasAdded;
    }
    User existingUser = aRole.getUser();
    if (existingUser != null && existingUser.numberOfRoles() <= minimumNumberOfRoles())
    {
      return wasAdded;
    }
    else if (existingUser != null)
    {
      existingUser.roles.remove(aRole);
    }
    roles.add(aRole);
    setUser(aRole,this);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRole(UserRole aRole)
  {
    boolean wasRemoved = false;
    if (roles.contains(aRole) && numberOfRoles() > minimumNumberOfRoles())
    {
      roles.remove(aRole);
      setUser(aRole,null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_SetMNToOptionalOne */
  public boolean setRoles(UserRole... newRoles)
  {
    boolean wasSet = false;
    if (newRoles.length < minimumNumberOfRoles() || newRoles.length > maximumNumberOfRoles())
    {
      return wasSet;
    }

    ArrayList<UserRole> checkNewRoles = new ArrayList<UserRole>();
    HashMap<User,Integer> userToNewRoles = new HashMap<User,Integer>();
    for (UserRole aRole : newRoles)
    {
      if (checkNewRoles.contains(aRole))
      {
        return wasSet;
      }
      else if (aRole.getUser() != null && !this.equals(aRole.getUser()))
      {
        User existingUser = aRole.getUser();
        if (!userToNewRoles.containsKey(existingUser))
        {
          userToNewRoles.put(existingUser, new Integer(existingUser.numberOfRoles()));
        }
        Integer currentCount = userToNewRoles.get(existingUser);
        int nextCount = currentCount - 1;
        if (nextCount < 1)
        {
          return wasSet;
        }
        userToNewRoles.put(existingUser, new Integer(nextCount));
      }
      checkNewRoles.add(aRole);
    }

    roles.removeAll(checkNewRoles);

    for (UserRole orphan : roles)
    {
      setUser(orphan, null);
    }
    roles.clear();
    for (UserRole aRole : newRoles)
    {
      if (aRole.getUser() != null)
      {
        aRole.getUser().roles.remove(aRole);
      }
      setUser(aRole, this);
      roles.add(aRole);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_GetPrivate */
  private void setUser(UserRole aRole, User aUser)
  {
    try
    {
      java.lang.reflect.Field mentorField = aRole.getClass().getDeclaredField("user");
      mentorField.setAccessible(true);
      mentorField.set(aRole, aUser);
    }
    catch (Exception e)
    {
      throw new RuntimeException("Issue internally setting aUser to aRole", e);
    }
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
    for(UserRole aRole : roles)
    {
      setUser(aRole,null);
    }
    roles.clear();
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
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "iMS = "+(getIMS()!=null?Integer.toHexString(System.identityHashCode(getIMS())):"null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 80 "../../../../IMSPersistence.ump"
  private static final long serialVersionUID = 386717976743499839L ;

  
}