package Shop;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    Operations operations = new Operations();

    public void displayMenu() {
        System.out.println("1. User Menu");
        System.out.println("2. Product Menu");
        System.out.println("3. Cart Menu");
        System.out.println("0. Exit");
    }

    private static void displayUserMenu() {
        System.out.println("1. Add user");
        System.out.println("2. Modify user");
        System.out.println("3. Delete user");
        System.out.println("4. User list order by the number of the products in the cart");
        System.out.println("5. User who bought a specific product");
        System.out.println("0. Go back");
    }

    private static void displayProductMenu() {
        System.out.println("1. Create new product");
        System.out.println("2. Edit product");
        System.out.println("3. Delete product");
        System.out.println("0. Go back");
    }

    private static void displayCartMenu() {
        System.out.println("1. Add a product to cart");
        System.out.println("2. View a user cart ");
        System.out.println("3. View cart with the most products");
        System.out.println("4. Delete user cart");
        System.out.println("0. Go back");
    }

    public void userMenu() throws ClassNotFoundException, SQLException {
        int option;

        do {
            displayUserMenu();
            System.out.print("Select an action -> ");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            if (option >= 0 && option <= 5) {
                switch (option) {
                    case 1: {
                        operations.addUser();
                        break;
                    }

                    case 2: {
                        operations.modifyUsers();
                        break;
                    }

                    case 3: {
                        operations.deleteUser();
                        break;
                    }

                    case 4: {
                        operations.userListOrderedByProductsInCart();
                        break;
                    }

                    case 5: {
                        operations.userWhoBoughtASpecificProduct();
                        break;
                    }
                }
            } else {
                System.out.println("Invalid action");
            }
        } while (option != 0);
    }

    public void productMenu() throws ClassNotFoundException, SQLException {
        int option;

        do {
            displayProductMenu();
            System.out.print("Select an action -> ");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            if (option >= 0 && option <= 3) {
                switch (option) {
                    case 1: {
                        operations.addProduct();
                        break;
                    }

                    case 2: {
                        operations.modifyProduct();
                        break;
                    }

                    case 3: {
                        operations.deleteProduct();
                        break;
                    }

                }
            } else {
                System.out.println("Invalid action");
            }
        } while (option != 0);
    }

    public void cartMenu() throws ClassNotFoundException, SQLException {
        int option;

        do {
            displayCartMenu();
            System.out.print("Select an action -> ");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            if (option >= 0 && option <= 4) {
                switch (option) {
                    case 1: {
                        operations.addProductsToCart();
                        break;
                    }

                    case 2: {
                        operations.viewCart();
                        break;
                    }

                    case 3: {
                        operations.viewCartWitMostProducts();
                        break;
                    }

                    case 4: {
                        operations.deleteUserCart();
                        break;
                    }
                }
            } else {
                System.out.println("Invalid action");
            }
        } while (option != 0);
    }
}
