package shop;

// ***************************************************************
//   Shop.java
//
//   Uses the Item class to create items and add them to a shopping
//   cart stored in an ArrayList.
// ***************************************************************

//import java.util.ArrayList;
import java.util.Scanner;

public class Shop
{
    public static void main (String[] args)
    {
//      ArrayList<Item> cart = new ArrayList<Item>();
//      Item item;
      String itemName;
      double itemPrice;
      int quantity;

      Scanner scan = new Scanner(System.in);

      int ch;
      ShoppingCart cart1 = new ShoppingCart();
      
      while (true) {
          System.out.println("Menu:");
          System.out.println(
                    "1) Add item in shopping cart" + "\n"
                  + "2) Edit item quantity in cart" + "\n"
                  + "3) Remove item from cart" + "\n"
                  + "4) Display Items in cart" + "\n"
                  + "5) Display Bill" + "\n"
                  + "6) Exit " + "\n");
          ch = scan.nextInt();

          switch (ch) {

          case 1:
              
        	  System.out.print ("Enter the name of the item: ");
              itemName = scan.next();

              System.out.print ("Enter the unit price: ");
              itemPrice = scan.nextDouble();

              System.out.print ("Enter the quantity: ");
              quantity = scan.nextInt();
              
              cart1.addToCart(itemName, itemPrice, quantity);
              
              break;

          case 2:

        	  System.out.print ("Enter name of item to be Edited : ");
        	  String editItemName = scan.next();

        	  System.out.print ("Enter new Quantity of "+ editItemName +" : ");
        	  int editItemQty = scan.nextInt();
        	  
              cart1.editItemDetailInCart(editItemName, editItemQty);
        	  
              break;
              
          case 3:
        	  
        	  System.out.print ("Enter name of item to be removed : ");
        	  String removeItemName = scan.next();
        	  
              cart1.removeFromCart(removeItemName);
              
              break;
              
          case 4:
        	  
        	  System.out.println(cart1.displayItems()); 
        	  break;
        	  
        	  
          case 5:
        	  
        	  System.out.println(cart1.printBill());
        	  break;
        	  
        	
          case 6:
        	  
              System.out.println("\n" + "Thank You for connecting!");
              System.exit(0);
          }
          
      }
      
    }
    
}