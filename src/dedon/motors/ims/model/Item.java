/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;

// line 46 "../../../../IMS.ump"
public class Item
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Item Attributes
  private double price;

  //Item Associations
  private Product product;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Item(double aPrice, Product aProduct)
  {
    // line 50 "../../../../IMS.ump"
    if(aPrice == 0.00 ) {
      		throw new RuntimeException("Price of an item cannot be zero.");
      	}
      	if (aPrice < 0.00) {
      		throw new RuntimeException("Price of an item cannot be negative value.");
      	}
    // END OF UMPLE BEFORE INJECTION
    price = aPrice;
    boolean didAddProduct = setProduct(aProduct);
    if (!didAddProduct)
    {
      throw new RuntimeException("Unable to create item due to product");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPrice(double aPrice)
  {
    boolean wasSet = false;
    // line 50 "../../../../IMS.ump"
    if(aPrice == 0.00 ) {
      		throw new RuntimeException("Price of an item cannot be zero.");
      	}
      	if (aPrice < 0.00) {
      		throw new RuntimeException("Price of an item cannot be negative value.");
      	}
    // END OF UMPLE BEFORE INJECTION
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public double getPrice()
  {
    return price;
  }
  /* Code from template association_GetOne */
  public Product getProduct()
  {
    return product;
  }
  /* Code from template association_SetOneToMany */
  public boolean setProduct(Product aProduct)
  {
    boolean wasSet = false;
    if (aProduct == null)
    {
      return wasSet;
    }

    Product existingProduct = product;
    product = aProduct;
    if (existingProduct != null && !existingProduct.equals(aProduct))
    {
      existingProduct.removeItem(this);
    }
    product.addItem(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Product placeholderProduct = product;
    this.product = null;
    if(placeholderProduct != null)
    {
      placeholderProduct.removeItem(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "price" + ":" + getPrice()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "product = "+(getProduct()!=null?Integer.toHexString(System.identityHashCode(getProduct())):"null");
  }
}