/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/


import java.io.Serializable;

// line 30 "IMSPersistence.ump"
public class Product implements Serializable
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Product()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  // line 36 "IMSPersistence.ump"
   public static  void reinitializeUniqueName(List<Product> products){
    productsByName = new HashMap<String, Product>();
    for (Product product : products) {
      productsByName.put(product.getName(), product);
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 33 "IMSPersistence.ump"
  private static final long serialVersionUID = 8896099581655989380L ;

  
}