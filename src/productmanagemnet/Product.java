/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package productmanagemnet;

// line 3 "../productmang.ump"
public class Product
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Product Attributes
  private String studentNumber;
  private String name;
  private int gradeAverage;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Product(String aStudentNumber, String aName, int aGradeAverage)
  {
    studentNumber = aStudentNumber;
    name = aName;
    gradeAverage = aGradeAverage;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStudentNumber(String aStudentNumber)
  {
    boolean wasSet = false;
    studentNumber = aStudentNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setGradeAverage(int aGradeAverage)
  {
    boolean wasSet = false;
    gradeAverage = aGradeAverage;
    wasSet = true;
    return wasSet;
  }

  /**
   * defaults to String
   */
  public String getStudentNumber()
  {
    return studentNumber;
  }

  public String getName()
  {
    return name;
  }

  /**
   * implemented as int
   */
  public int getGradeAverage()
  {
    return gradeAverage;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "studentNumber" + ":" + getStudentNumber()+ "," +
            "name" + ":" + getName()+ "," +
            "gradeAverage" + ":" + getGradeAverage()+ "]";
  }
}