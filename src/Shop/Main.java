package Shop;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        int option;

        do {
            menu.displayMenu();
            System.out.print("Option -> ");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();

            if (option >= 0 && option <= 3) {
                switch (option) {
                    case 1: {
                        try {
                            menu.userMenu();

                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }

                    case 2: {
                        try {
                            menu.productMenu();

                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }

                    case 3: {
                        try {
                            menu.cartMenu();

                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
            } else {
                System.out.println("Invalid Option");
            }
        } while (option != 0);
    }
}

