package dat.backend.model.persistence;

import dat.backend.model.entities.Product;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProduktFacade {

    public static int createProduct(String top, String bottom, int price, int orderid, String amount) {
        ConnectionPool connectionPool = new ConnectionPool();
        int id = 0;
        try {
            connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        id = ProductMapper.createProduct(connectionPool, top, bottom, price, orderid, amount);
        return id;
    }

    public static ArrayList<Product> findProduct(int orderId) {
        ConnectionPool connectionPool = new ConnectionPool();
        ArrayList<Product> products = new ArrayList<>();

        try {
            connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            products = ProductMapper.findProduct(connectionPool, orderId);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        return products;
    }

    public static void deleteAllProductsWithOrderId(int orderId) {
        ConnectionPool connectionPool = new ConnectionPool();
        try {
            connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ProductMapper.deleteAllProductsWithOrderId(connectionPool, orderId);
    }

    public static void deleteProductWithProductId(int productId) {
        ConnectionPool connectionPool = new ConnectionPool();
        try {
            connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ProductMapper.deleteProductWithProductId(connectionPool, productId);
    }


}
