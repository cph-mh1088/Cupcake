package dat.backend.model.persistence;

import dat.backend.model.entities.Product;
import dat.backend.model.exceptions.DatabaseException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProduktFacadeTest {

    @Test
    void createProduct() throws DatabaseException {

        int id = ProduktFacade.createProduct("jordbær","chokolade",20,50,"3");
        System.out.println(id);
    }

    @Test
    void findProduct() {
        ArrayList<Product>products = ProduktFacade.findProduct(50);
        System.out.println(products);
    }

    @Test
    void deleteAllProductsWithOrderId() {
        ProduktFacade.deleteAllProductsWithOrderId(50);
    }

    @Test
    void deleteProductWithProductId() {
        ProduktFacade.deleteProductWithProductId(3);
    }
}