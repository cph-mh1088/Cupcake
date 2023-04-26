package dat.backend.model.persistence;

import dat.backend.model.entities.TopCake;
import dat.backend.model.exceptions.DatabaseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.SQLException;
import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TopCakeFacadeTest {
    private ConnectionPool connectionPool;

    @BeforeAll
    void setup() throws SQLException {
        this.connectionPool = new ConnectionPool();
        connectionPool.getConnection();
    }

    @Test
    void topCakeList() throws DatabaseException, SQLException {
        ArrayList<TopCake>list = TopCakeFacade.topCakeList();
        System.out.println(list);
    }
}