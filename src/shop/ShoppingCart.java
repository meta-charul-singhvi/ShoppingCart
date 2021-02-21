package shop;
// **********************************************************************
//   ShoppingCart.java
//
//   Represents a shopping cart as an array of items
// **********************************************************************
import java.text.NumberFormat;

public class ShoppingCart
{

    private Item[] cart;
    private int itemCount;      // total number of items in the cart
    private double totalPrice;  // total price of items in the cart
    private int capacity;       // current cart capacity

    // -----------------------------------------------------------
    //  Creates an empty shopping cart with a capacity of 5 items.
    // -----------------------------------------------------------
    public ShoppingCart()
    {

      capacity = 5;
      cart = new Item[capacity];
      itemCount = 0;
      totalPrice = 0.0;
    }

    // -------------------------------------------------------
    //  Adds an item to the shopping cart.
    // -------------------------------------------------------
    public void addToCart(String itemName, double price, int quantity)
    { 

        Item temp = new Item(itemName, price, quantity);
        totalPrice += (price * quantity);
        cart[itemCount] = temp;
        itemCount += 1;
        if(itemCount==capacity)
        {
            increaseSize();
        }
    }
    
    
    // -------------------------------------------------------
    //  Removes an item from the shopping cart.
    // -------------------------------------------------------
    public void editItemDetailInCart(String itemName, int UpdtQuantity)
    { 
        Item temp = new Item(itemName, 0, 0);
        int i=0;
        for(i=0; i < itemCount; i++)
        {
            if (temp.getName().equals( cart[i].getName()) ){
            	break;
            }
        }
        Item updateItem = new Item(cart[i].getName(), cart[i].getPrice(), cart[i].getQuantity());
       
        totalPrice -= updateItem.getPrice() * updateItem.getQuantity();
        totalPrice += UpdtQuantity * updateItem.getQuantity();
        cart[i].updtQuantity(UpdtQuantity);
        temp=null;
        
        updateItem = cart[i];
        System.out.println("Item Updated successfully : " + updateItem);
        updateItem = null;
    }
    
    
    // -------------------------------------------------------
    //  Removes an item from the shopping cart.
    // -------------------------------------------------------
    public void removeFromCart(String itemName)
    { 
    	Item getItemByName = new Item(itemName);
    	double price = getItemByName.getPrice();
    	int quantity = getItemByName.getQuantity();
    	
        Item temp = new Item(itemName, price, quantity);
        int i=0;
        for(i=0; i < itemCount; i++)
        {
            if (temp.getName().equals( cart[i].getName()) ){
            	break;
            }
        }
        Item removeItem = new Item(cart[i].getName(), cart[i].getPrice(), cart[i].getQuantity());
        for(int j = i; j<=itemCount; j++){
        	temp=cart[j+1];
        	cart[j]=temp;
        }
        cart[itemCount]=null;
        itemCount-=1;
        capacity= cart.length;
        totalPrice -= removeItem.getPrice() * removeItem.getQuantity();
        temp=null;
        System.out.println("Item removed successfully : " + removeItem);
        removeItem = null;
    }

    // -------------------------------------------------------
    //  Returns the contents of the cart together with
    //  summary information.
    // -------------------------------------------------------
    public String displayItems()
    {
      
      String contents = "\nShopping Cart\n";
      contents += "\nItem\tUnit Price\tQuantity\tTotal\n";

      for (int i = 0; i < itemCount; i++)
          contents += cart[i].toString() + "\n";

      return contents;
    }
    
    public String printBill()
    {
      String contents = "\nTotal Bill : " + (totalPrice) + "\n";
      return contents;
    }
    

    // ---------------------------------------------------------
    //  Increases the capacity of the shopping cart by 3
    // ---------------------------------------------------------
    private void increaseSize()
    {
        Item[] temp = new Item[capacity+3];
        for(int i=0; i < capacity; i++)
        {
            temp[i] = cart[i];
        }
        cart = temp; 
        temp = null;
        capacity = cart.length;
    }
    
    
}