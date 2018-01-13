package DatabaseOperations;

import Shop.Product;
import Shop.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOperations {
    //User methodes
    //add user
    public void addUserOnDatabase(User user) throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "";
        final String USERNAME = "";
        final String PASSWORD = "";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO users (name, password) VALUES (?,?)");
        pSt.setString(1, user.getName());
        pSt.setString(2, user.getPassword());

        // 5. execute a prepared statement
        pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    //update user
    public void updateUsersOnDatabase(String oldName, String newName, String newPassword) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "";
        final String USERNAME = "";
        final String PASSWORD = "";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("UPDATE users SET name=?,password=? WHERE name=?");
        pSt.setString(1, newName);
        pSt.setString(2, newPassword);
        pSt.setString(3, oldName);

        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    //delete user
    public void deleteUserFromDatabase(String name) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "";
        final String USERNAME = "";
        final String PASSWORD = "";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("DELETE FROM users WHERE name=?");
        pSt.setString(1, name);

        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();
        // 6. close the objects
        pSt.close();
        conn.close();
    }

    //lista userilor ordonata dupa numarul de produse din cos
    public List<User> userListOrderByProductsInCart() throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "";
        final String USERNAME = "";
        final String PASSWORD = "";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        // 5. execute a query
        String querry = ("select users.name,  COUNT(cart.id_product) "
                + ("from cart ")
                + ("join products on products.id_products = cart.id_product ")
                + ("join users on users.id_user = cart.id_user ")
                + ("where products.id_products = cart.id_product and users.id_user = cart.id_user ")
                + ("group by users.name ")
                + ("order by COUNT(cart.id_product)"));


        ResultSet rs = st.executeQuery(querry);

        //read

        List<User> userList = new ArrayList();
        while (rs.next()) {
            User u = new User();
            u.setName(rs.getString("name"));
            u.setNrOfProducts(rs.getInt("count"));
            userList.add(u);
        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();

        return userList;
    }

    //userii care au cumparat un anumit produs citit de la tastatura
    public List<User> usersWhoBoughtASpecificProductFromDatabase(String productName) throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "";
        final String USERNAME = "";
        final String PASSWORD = "";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        String querry = ("select users.name, products.name as productname "
                + "from cart  "
                + "join products on products.id_products = cart.id_product "
                + "join users on users.id_user = cart.id_user "
                + "where products.id_products = cart.id_product and users.id_user = cart.id_user and products.name ='" + productName + "'");

        ResultSet rs = st.executeQuery(querry);

        //read

        List<User> userList = new ArrayList();
        while (rs.next()) {
            User u = new User();
            u.setName(rs.getString("name"));
            u.setUserProducts(rs.getString("productname"));
            userList.add(u);
        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();

        return userList;
    }

    //Product
    //add product
    public void addProductOnDatabase(Product product) throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "";
        final String USERNAME = "";
        final String PASSWORD = "";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("INSERT INTO products (name, price) VALUES (?,?)");
        pSt.setString(1, product.getName());
        pSt.setInt(2, product.getPrice());

        // 5. execute a prepared statement
        pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    //update product
    public void updateProductsOnDatabase(String oldName, String newName, int newPrice) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "";
        final String USERNAME = "";
        final String PASSWORD = "";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("UPDATE products SET name=?,price=? WHERE name=?");
        pSt.setString(1, newName);
        pSt.setInt(2, newPrice);
        pSt.setString(3, oldName);

        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    //delete product
    public void deleteProductFromDatabase(String name) throws ClassNotFoundException, SQLException {

        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "";
        final String USERNAME = "";
        final String PASSWORD = "";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        PreparedStatement pSt = conn.prepareStatement("DELETE FROM products WHERE name=?");
        pSt.setString(1, name);

        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();
        // 6. close the objects
        pSt.close();
        conn.close();
    }

    //Cart
    //user care pune in cos produse
    public void addAProductToCartDatabase(String userName, String productName) throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "";
        final String USERNAME = "";
        final String PASSWORD = "";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        String querry = ("insert into cart(id_user, id_product)" +
                "values((select id_user from users where name=?), (select id_products from products where name =?))");


        PreparedStatement pSt = conn.prepareStatement(querry);
        pSt.setString(1, userName);
        pSt.setString(2, productName);

        // 5. execute a prepared statement
        pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }

    //vizualizare cos
    public List<Product> visualizeCartDatabase(String userName) throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "";
        final String USERNAME = "";
        final String PASSWORD = "";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        // 5. execute a query
        String querry = ("select products.name, products.price "
                + "from products "
                + "join cart on products.id_products = cart.id_product "
                + "join users on users.id_user = cart.id_user "
                + "where users.name = '" + userName + "' "
                + "order by products.price");


        ResultSet rs = st.executeQuery(querry);

        //read

        List<Product> userCart = new ArrayList();
        while (rs.next()) {
            Product p = new Product();
            p.setName(rs.getString("name"));
            p.setPrice(rs.getInt("price"));
            userCart.add(p);
        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();

        return userCart;
    }

    public List<User> visualizeCartWithTheMostProducts() throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "";
        final String USERNAME = "";
        final String PASSWORD = "";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        Statement st = conn.createStatement();

        // 5. execute a query
        String querry = ("select users.name,  COUNT(cart.id_product) "
                + "from cart "
                + "join products on products.id_products = cart.id_product "
                + "join users on users.id_user = cart.id_user "
                + "where products.id_products = cart.id_product and users.id_user = cart.id_user "
                + "group by users.name "
                + "order by COUNT(cart.id_product) desc "
                + "limit 1");


        ResultSet rs = st.executeQuery(querry);

        //read

        List<User> userList = new ArrayList();
        while (rs.next()) {
            User u = new User();
            u.setName(rs.getString("name"));
            u.setNrOfProducts(rs.getInt("count"));
            userList.add(u);
        }

        // 7. close the objects
        rs.close();
        st.close();
        conn.close();

        return userList;
    }

    //sa se stearga cosul unui anumit user citit de la tastatura
    public void deleteUserCartFromDatabase(String userName) throws ClassNotFoundException, SQLException {
        // 1. load driver, no longer needed in new versions of JDBC
        Class.forName("org.postgresql.Driver");

        // 2. define connection params to db
        final String URL = "";
        final String USERNAME = "";
        final String PASSWORD = "";

        // 3. obtain a connection
        Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 4. create a query statement
        String querry = ("delete from cart "
                + "using users "
                + "where users.id_user = cart.id_user and users.name =?");

        PreparedStatement pSt = conn.prepareStatement(querry);
        pSt.setString(1, userName);

        // 5. execute a prepared statement
        int rowsUpdated = pSt.executeUpdate();

        // 6. close the objects
        pSt.close();
        conn.close();
    }
}
