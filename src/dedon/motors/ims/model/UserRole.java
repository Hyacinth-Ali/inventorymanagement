/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;

// line 56 "../../../../IMS.ump"
public abstract class UserRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UserRole Associations
  private User user;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UserRole(User aUser)
  {
    boolean didAddUser = setUser(aUser);
    if (!didAddUser)
    {
      throw new RuntimeException("Unable to create role due to user");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public User getUser()
  {
    return user;
  }
  /* Code from template association_SetOneToAtMostN */
  public boolean setUser(User aUser)
  {
    boolean wasSet = false;
    //Must provide user to role
    if (aUser == null)
    {
      return wasSet;
    }

    //user already at maximum (2)
    if (aUser.numberOfRoles() >= User.maximumNumberOfRoles())
    {
      return wasSet;
    }
    
    User existingUser = user;
    user = aUser;
    if (existingUser != null && !existingUser.equals(aUser))
    {
      boolean didRemove = existingUser.removeRole(this);
      if (!didRemove)
      {
        user = existingUser;
        return wasSet;
      }
    }
    user.addRole(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    User placeholderUser = user;
    this.user = null;
    if(placeholderUser != null)
    {
      placeholderUser.removeRole(this);
    }
  }

}