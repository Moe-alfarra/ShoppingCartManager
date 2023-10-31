package domain;
import java.net.BindException;
import java.util.ArrayList; // Command used to import ArrayList

/**
 * This is the domain class ShoppingCart that consists of 3 private variables, default and non-default constructor, getters & setters
 * and public toString. It is used to create a ShoppingCart object, and it has 8 domain methods.
 */
public class ShoppingCart {

    // Define local variables for the ItemToPurchase class

    private String customerName; // Creates a private String called customerName
    private String currentDate; // Creates a private String called currentDate
    private ArrayList<ItemToPurchase> cartItems; // Creates a private ArrayList of ItemToPurchase type called cartItems


    // Define default and non-default constructor for the ItemToPurchase class

    public ShoppingCart() {
        this.customerName = "none";
        this.currentDate = "January 1, 2022";
        this.cartItems = new ArrayList<ItemToPurchase>();
    }

    public ShoppingCart(String customerName, String currentDate) {
        this.customerName = customerName;
        this.currentDate = currentDate;
        this.cartItems = new ArrayList<ItemToPurchase>();
    }


    // Define Getters & Setters for the ItemToPurchase Class

    public String getCustomerName() {return customerName;}
    public String getCurrentDate() {return currentDate;}
    public ArrayList<ItemToPurchase> getCartItems() {return cartItems;}


    public void setCustomerName(String customerName) {this.customerName = customerName;}
    public void setCurrentDate(String currentDate) {this.currentDate = currentDate;}
    public void setCartItems(ArrayList<ItemToPurchase> cartItems) {this.cartItems = cartItems;}


    // Define public toString
    @Override
    public String toString() {
        return "ShoppingCart{" +
                "customerName='" + customerName + '\'' +
                ", currentDate='" + currentDate + '\'' +
                ", cartItems=" + cartItems +
                '}';
    }


    // Methods for the domain class


    /**
     * This is the addItem() method that receives the ItemToPurchase object anItem as a parameter and adds it to the cartItem Arraylist
     * @param anItem ItemToPurchase
     */
    public void addItem(ItemToPurchase anItem) {
        cartItems.add(anItem); // Adds the object anItem to the cartItem Arraylist
    }

    /**
     * This is the removeItem() method that receives the String itemName as a parameter, and it checks if the itemName entered by the user
     * exists in the ArrayList to remove the object with that itemName
     * @param itemName String
     */
    public void removeItem(String itemName) {
        boolean found = false; // Creates and initializes a boolean variable called found
        int index = 0; // Creates and initializes an int variable called index

        // For-loop that loops through the Arraylist cartItem
        for (int i = 0; i < cartItems.size(); i++) {
            // If-statement that checks if the itemName at position i is equal to the itemName the user wants to remove
            if (cartItems.get(i).getItemName().equalsIgnoreCase(itemName)) {
                index = i;
                cartItems.remove(index); // Removes the object at the index position if the itemName matches
                found = true;
            }
        }
        // If the user is informed that no such item exists in the Arraylist
        if (found == false) {
            System.out.println("Item not found in cart. Nothing removed."); // Program prints to the user that the item doesn't exist if the itemName doesn't match
        }
    }

    /**
     * This is the modifyItem() method which receives the ItemToPurchase object anItem, and it modifies the quantity of the
     * item the user wants to edit
     * @param anItem ItemToPurchase
     */
    public void modifyItem(ItemToPurchase anItem) {
        boolean modify = false; // Creates and initializes a boolean variable called modify
        // For-loop that loops through the Arraylist cartItem
        for (int i = 0; i < cartItems.size(); i++) {
            // If the itemName entered by the user exists and matches an itemName inside the Arraylist then the itemQuantity is set to the new amount entered by the user
            if (cartItems.get(i).getItemName().equalsIgnoreCase(anItem.getItemName())) {
                cartItems.get(i).setItemQuantity(anItem.getItemQuantity()); // Sets the itemQuantity to the new number entered by the user
                modify = true;
            }
        }
        // If the itemName doesn't exist the user is informed that nothing is modified
        if (modify == false) {
            System.out.println("Item not found in cart. Nothing modified."); // Program prints to the user that nothing is modified
        }
    }

    /**
     * This is the getNumItemsInCart() method which gets the total quantity of the items in the cartItem Arraylist and returns the totalQuantity
     * @return totalQuantity
     */
    public int getNumItemsInCart() {
        int totalQuantity = 0; // Creates and initializes an int variable called totalQuantity

        // For-loop that loops through the Arraylist cartItem
        for (int i = 0; i < cartItems.size(); i++) {
            totalQuantity += cartItems.get(i).getItemQuantity(); // Adds the quantity of each item at position i to the totalQuantity
        }
        return totalQuantity; // Returns the totalQuantity variable
    }

    /**
     * This is the getCostOfCart() method which gets the total cost of the items in the cartItem Arraylist and returns the totalCost
     * @return totalCost
     */
    public double getCostOfCart() {
        double totalCost = 0; // Creates and initializes a double variable called totalCost

        // For-loop that loops through the Arraylist cartItem
        for (int i =0; i < cartItems.size(); i++) {
            totalCost += cartItems.get(i).getItemPrice() * cartItems.get(i).getItemQuantity(); // Adds the price of each item at position i to the totalCost
        }
        return totalCost; // Returns the totalCost variable
    }

    /**
     * This is the printTotal() method that prints the information of the customer's cart which include his name, date, number of items,
     * cost of each item and the total cost of all the items
     */
    public void printTotal() {
        System.out.println(customerName + "'s Shopping Cart - " + currentDate + "\nNumber of Items: " + getNumItemsInCart()); // Program prints to the user customer's name, today's date and number of items in cart
        System.out.println(""); // Prints a new empty line

        // For-loop that loops through the Arraylist cartItem
        for (int i = 0; i < cartItems.size(); i++) {
            cartItems.get(i).printItemCost(); // Calls the printItemCost method which prints the details of the item and subtotal
            //total += cartItems.get(i).getItemPrice() * cartItems.get(i).getItemQuantity(); // Adds the subtotal of each item to the total
        }
        if (getNumItemsInCart() == 0) {
            System.out.println("SHOPPING CART IS EMPTY");
        }

        System.out.printf("\nTotal: $%.2f", getCostOfCart()); // Program prints to the user the total of all the items in cart
        System.out.println(""); // Prints a new empty line
    }

    /**
     * This is the printDescriptions() method that prints the description of each item in the shopping cart
     */
    public void printDescriptions() {
        System.out.println(customerName + "'s Shopping Cart - " + currentDate + "\nItem Descriptions\n"); // Program prints to the user the customer's name, today's date and the title

        // For-loop that loops through the Arraylist cartItem
        for (int i =0; i < cartItems.size(); i++) {
            //System.out.println(cartItems.get(i).getItemName() + ": " + cartItems.get(i).getItemDescription());
            cartItems.get(i).printItemDescription(); // Calls the printItemDescription method which will print the item's description at position i in the cartItem arraylist
        }
    }
}
