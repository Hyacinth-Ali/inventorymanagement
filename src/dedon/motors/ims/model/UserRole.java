/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;

// line 65 "../../../../IMS.ump"
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

  public UserRole()
  {}

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public User getUser()
  {
    return user;
  }

  public boolean hasUser()
  {
    boolean has = user != null;
    return has;
  }

  public void delete()
  {
    if (user != null)
    {
      if (user.numberOfRoles() <= 1)
      {
        user.delete();
      }
      else
      {
        User placeholderUser = user;
        this.user = null;
        placeholderUser.removeRole(this);
      }
    }
  }

}