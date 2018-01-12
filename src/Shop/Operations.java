package Shop;

import DatabaseOperations.DatabaseOperations;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Operations {
    Scanner scanner = new Scanner(System.in);
    DatabaseOperations databaseOperations = new DatabaseOperations();

    //User methodes
    public void addUser() throws ClassNotFoundException, SQLException {
        System.out.println("Enter username and password");

        System.out.print("Username = ");
        String name = scanner.next();

        System.out.print("Password = ");
        String password = scanner.next();

        User u = new User(name, password);
        databaseOperations.addUserOnDatabase(u);
    }

    public void modifyUsers() throws ClassNotFoundException, SQLException {
        System.out.print("Change the following name ");
        String oldName = scanner.next();

        System.out.print("New name = ");
        String newName = scanner.next();

        System.out.print("New Password = ");
        String newPassword = scanner.next();

        databaseOperations.updateUsersOnDatabase(oldName, newName, newPassword);
    }

    public void deleteUser() throws ClassNotFoundException, SQLException {
        System.out.print("Enter a name to delete ");
        String name = scanner.next();
        databaseOperations.deleteUserFromDatabase(name);
    }

    public void userWhoBoughtASpecificProduct() throws ClassNotFoundException, SQLException {
        System.out.print("Enter a product to see who username bought it ");
        String productName = scanner.next();
        List<User> userList = databaseOperations.usersWhoBoughtASpecificProductFromDatabase(productName);

        for (int i = 0; i < userList.size(); i++) {
            System.out.print(userList.get(i).getName() + " ");
            System.out.println(userList.get(i).getUserProducts());
        }
    }

    //Product methodes
    public void addProduct() throws ClassNotFoundException, SQLException {
        System.out.println("Add product");

        System.out.print("Product name = ");
        String name = scanner.next();

        System.out.print("Product price = ");
        int price = scanner.nextInt();

        Product p = new Product(name, price);
        databaseOperations.addProductOnDatabase(p);
    }

    public void modifyProduct() throws ClassNotFoundException, SQLException {
        System.out.print("Change product ");
        String oldName = scanner.next();

        System.out.print("New name = ");
        String newName = scanner.next();

        System.out.print("New Password = ");
        int newPrice = scanner.nextInt();

        databaseOperations.updateProductsOnDatabase(oldName, newName, newPrice);
    }

    public void deleteProduct() throws ClassNotFoundException, SQLException {
        System.out.print("Product to delete ");
        String name = scanner.next();
        databaseOperations.deleteProductFromDatabase(name);
    }

    public void userListOrderedByProductsInCart() throws ClassNotFoundException, SQLException {
        List<User> userList = databaseOperations.userListOrderByProductsInCart();

        for (int i = 0; i < userList.size(); i++) {
            System.out.print(userList.get(i).getName() + " ");
            System.out.println(userList.get(i).getNrOfProducts() + " products");
        }
    }

    //Cart methodes
    public void addProductsToCart() throws ClassNotFoundException, SQLException {
        System.out.println("Add product to Cart");

        System.out.print("Username = ");
        String userName = scanner.next();

        System.out.print("Product = ");
        String productName = scanner.next();

        databaseOperations.addAProductToCartDatabase(userName, productName);
    }

    public void viewCart() throws ClassNotFoundException, SQLException {
        System.out.print("Visualize user cart ");
        String userName = scanner.next();
        List<Product> userCart = databaseOperations.visualizeCartDatabase(userName);

        for (int i = 0; i < userCart.size(); i++) {
            System.out.print(userCart.get(i).getName() + " ");
            System.out.println(userCart.get(i).getPrice() + " lei");
        }
    }

    public void deleteUserCart() throws ClassNotFoundException, SQLException {
        System.out.println("Delete the user cart");
        System.out.print("Username = ");
        String userName = scanner.next();
        databaseOperations.deleteUserCartFromDatabase(userName);

    }

    public void viewCartWitMostProducts() throws ClassNotFoundException, SQLException {
        List<User> userCart = databaseOperations.visualizeCartWithTheMostProducts();

        for (int i = 0; i < userCart.size(); i++) {
            String userName = userCart.get(i).getName();
            List<Product> productList = databaseOperations.visualizeCartDatabase(userName);
            System.out.println("User: " + userName);
            System.out.println("Products: ");

            for (int x = 0; x < productList.size(); x++) {
                System.out.print(productList.get(x).getName() + " ");
                System.out.println(productList.get(x).getPrice() + " lei");
            }
        }
    }
}
