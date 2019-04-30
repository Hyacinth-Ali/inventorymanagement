/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.0.4181.a593105a9 modeling language!*/

package dedon.motors.ims.model;

// line 46 "../../../../IMS.ump"
public class Item
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Item Associations
  private Product product;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Item(Product aProduct)
  {
    boolean didAddProduct = setProduct(aProduct);
    if (!didAddProduct)
    {
      throw new RuntimeException("Unable to create item due to product");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
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

}