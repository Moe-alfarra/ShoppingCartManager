package domain;

/**
 * This is the domain class ItemToPurchase that consists of 4 private variables, default and non-default constructors, getters &
 * setters and public toString. It creates an ItemToPurchase object, and it has 2 domain methods.
 */
public class ItemToPurchase {

    // Define local variables for the ItemToPurchase class

    private String itemName; // Creates a private String called itemName
    private double itemPrice; // Creates a private double called itemPrice
    private int itemQuantity; // Creates a private int called itemQuantity
    private String itemDescription; // Creates a private String called itemDescription


    // Define default and non-default constructor for the ItemToPurchase class

    public ItemToPurchase(String itemName, double itemPrice, int itemQuantity, String itemDescription) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemDescription = itemDescription;
    }

    public ItemToPurchase()
    {
        this.itemName = "";
        this.itemPrice = 0.00;
        this.itemQuantity = 0;
        this.itemDescription = "";
    }


    // Define Getters & Setters for the ItemToPurchase Class
    public String getItemName() {return itemName;}
    public double getItemPrice() {return itemPrice;}
    public int getItemQuantity() {return itemQuantity;}
    public String getItemDescription() {return itemDescription;}


    public void setItemName(String itemName) {this.itemName = itemName;}
    public void setItemPrice(double itemPrice) {this.itemPrice = itemPrice;}
    public void setItemQuantity(int itemQuantity) {this.itemQuantity = itemQuantity;}
    public void setItemDescription(String itemDescription) {this.itemDescription = itemDescription;}


    // Define public toString
    @Override
    public String toString() {
        return "ItemToPurchase{" +
                "itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemQuantity=" + itemQuantity +
                ", itemDescription='" + itemDescription + '\'' +
                '}';
    }


    //Add 2 methods from UML diagram here:

    /**
     * This is the printItemCost() method which prints the item's cost which is the itemQuantity multiplied by the itemPrice
     */
    public void printItemCost() {
        double subtotal; // Creates a double variable called subtotal
        subtotal = itemQuantity * itemPrice; // Calculates the subtotal of the item which is the itemQuantity multiplied by the itemPrice
        System.out.println(itemName + " " + itemQuantity + " @ $" + itemPrice + " = $" + subtotal); // Program prints to the user the itemName, itemQuantity, itemPrice and subtotal
    }

    /**
     * This is the printItemDescription() method which prints the item's description
     */
    public void printItemDescription() {
        System.out.println(itemName + ": " + itemDescription + "."); // Program prints to the user the itemName and itemDescription
    }

}
