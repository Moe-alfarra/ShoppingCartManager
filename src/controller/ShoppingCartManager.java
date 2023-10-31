package controller;
import domain.ItemToPurchase;
import domain.ShoppingCart;
import java.util.Scanner; // Command used to import Scanner

/**
 * @author 6368950
 * Title: ShoppingCartManager
 * Semester: Fall 2022 - COP 2210
 * Professor:Cristy Charters
 * UTA: Christian
 * Description:
 * This is the ShoppingCartManager program which asks for the customer's information like name and today's date then runs the main menu
 * where the user can choose from a variety of options like to add an item to the shopping cart, remove item, modify the quantity of an item,
 * print items' description, print total and finaly quit after the user is done.
 */

public class ShoppingCartManager {


    /**
     * This is the main method that is used to run the program
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in); // Defines the scanner object
        String customerName; // Creates a String variable called customerName
        String todaysDate; // Creates a String variable called todaysDate
        char menuChoice = ' '; // Creates a char variable called menuChoice

        System.out.println("Enter Customer's Name:"); // Asks the user to enter the customer's name
        customerName = scnr.nextLine(); // Gets the input from the user and assigns it to the customerName variable

        System.out.println("Enter Today's Date:"); // Asks the user to enter today's date
        todaysDate = scnr.nextLine(); // Gets the input from the user and assigns it to the todaysDate variable

        System.out.println("\nCustomer Name: " + customerName); // Prints the customer name to the user
        System.out.println("Today's Date: " + todaysDate); // Prints today's date to the user
        System.out.println(""); // Prints a new empty line

        ShoppingCart myCart = new ShoppingCart(customerName, todaysDate); // Creates a ShoppingCart object called myCart

        printMenu(); // Calls the printMenu method

        // While loop that keeps the program running until the user enter q to quit the program
        while(menuChoice != 'q') {
            System.out.println("Choose an option:"); // Asks the user to choose an option from the menu
            menuChoice = scnr.next().charAt(0); // Programs gets the input and assigns it to menuChoice
            executeMenu(menuChoice, myCart, scnr); // Calls the executeMenu method which will run the options of the main menu
            printMenu(); // After the executeMenu method runs the program calls the printMenu method which will print the menu for the user to choose another option
        }
        System.out.println("Thanks for shopping with us.  Please come again."); // When the user quits the program will print this and end
    }


    /**
     * This is the printMenu() method that prints the menu of the program for the user and the details of each menu option
     * The method returns nothing and receives no parameters
     */
    public static void printMenu() {
        // Program prints the menu to the user with the title and the options and how to choose each menu option

        System.out.println("MENU");
        System.out.println("a - Add item to cart");
        System.out.println("d - Remove item from cart");
        System.out.println("c - Change item quantity");
        System.out.println("i - Output items' descriptions");
        System.out.println("o - Output shopping cart");
        System.out.println( "q - Quit");
        System.out.println("");
    }

    /**
     * This is the executeMenu() method that receives three parameters the char option which the letter the user inputs to be
     * redirected to this specific menu, the ShoppingCart object theCart which contains the customer's name and today's date and
     *  the scanner object
     * @param option char
     * @param theCart ShoppingCart
     * @param scnr Scanner
     */
    public static void executeMenu(char option, ShoppingCart theCart, Scanner scnr) {
        String productName; // Creates a String variable called productName
        String productDescription; // Creates a String variable called productDescription
        double productPrice = 0; // Creates and initializes a double variable called productPrice to 0
        int productQuantity = 0; // Creates and initializes an int variable called productQuantity to 0

        // Switch statement that checks the option of the user and based on the letter the user chooses it runs the menu associated with that letter
        switch (option) {
            case 'a': // If the option was letter 'a' the program will run the add an item menu option and will ask the user for the details of the item
                scnr.nextLine();
                System.out.println("ADD ITEM TO CART"); // Prints the title of the add item menu
                System.out.println("Enter the item name:"); // Program asks the user for the item's name
                productName = scnr.nextLine(); // Program gets the input from the user and assigns it to the productName variable

                System.out.println("Enter the item description:"); // Program asks the user for the item's description
                productDescription = scnr.nextLine(); // Program gets the input from the user and assigns it to the productDescription variable

                System.out.println("Enter the item price:"); // Program asks the user for the item's price
                productPrice= scnr.nextDouble(); // Program gets the input from the user and assigns it to the productPrice variable

                System.out.println("Enter the item quantity:"); // Program asks the user for the item's quantity
                productQuantity = scnr.nextInt(); // Program gets the input from the user and assigns it to the productQuantity variable

                ItemToPurchase newItem = new ItemToPurchase(productName, productPrice, productQuantity, productDescription); // Creates an ItemToPurchase object called newItem
                theCart.addItem(newItem); // Calls the addItem method from the ShoppingCart domain class using the object theCart which will add the ItemToPurchase object ot the arraylist

                System.out.println(""); // Prints a new empty line
                break;

            case 'd': // If the option was letter 'd' the program will run the remove an item from the menu option which will ask for the item's name that the user wants to remove
                scnr.nextLine();

                System.out.println("REMOVE ITEM FROM CART"); // Prints the title of the remove item menu
                System.out.println("Enter name of item to remove:"); // Asks for the item's name that the user wants to remove
                productName = scnr.nextLine(); // Program gets the input from the user and assigns it to the productName variable

                theCart.removeItem(productName); // Calls the removeItem method from the ShoppingCart domain class using the object theCart which will remove the ItemToPurchase object ot the arraylist
                System.out.println(""); // Prints a new empty line
                break;

            case 'c': // If the option was letter 'c' the program will run the change item quantity menu option which will allow the user to change the quantity of a specific item
                scnr.nextLine();

                System.out.println("CHANGE ITEM QUANTITY"); // Prints the title of the change item quantity menu
                System.out.println("Enter the item name:"); // Asks for the item's name that the user wants to change quantity for
                productName = scnr.nextLine(); // Program gets the input from the user and assigns it to the productName variable

                System.out.println("Enter the new quantity:"); // Asks the user for the new quantity
                productQuantity = scnr.nextInt(); // Program gets the input from the user and assigns it to the productQuantity variable

                ItemToPurchase modItem = new ItemToPurchase(); // Creates a modified ItemToPurchase object called modItem
                modItem.setItemName(productName); // Sets the object's itemName to the itemName entered by the user
                modItem.setItemQuantity(productQuantity); // Sets the object's itemQuantity to the itemQuantity entered by the user

                theCart.modifyItem(modItem); // Calls the modifyItem method in the domain class and passes modItem as the parameter
                System.out.println(""); // Prints a new empty line
                break;

            case 'i': // If the option was letter 'i' the program will run the output items' description menu option which will call the printDescriptions() method
                System.out.println("OUTPUT ITEMS' DESCRIPTIONS"); // Prints the title of the menu option
                theCart.printDescriptions(); // Calls the printDescriptions() method which will print the description of all the items in the cart
                System.out.println(""); // Prints a new empty line
                break;

            case 'o': // If the option was letter 'o' the program will run the output shopping cart menu option which will call the printTotal method
                System.out.println("OUTPUT SHOPPING CART"); // Prints the title of the menu option
                theCart.printTotal(); // Calls the printTotal() method
                System.out.println(""); // Prints a new empty line
                break;
        }

    }



}