package dat.backend.model.persistence;

import dat.backend.model.entities.Ordre;
import dat.backend.model.exceptions.DatabaseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrdreFacadeTest {
    private ConnectionPool connectionPool;

    @BeforeAll
    void setup() throws SQLException {
        this.connectionPool = new ConnectionPool();
        connectionPool.getConnection();
    }

    @Test
    void getOrdrelist() throws DatabaseException {
        ArrayList<Ordre> ordrelist = OrdreFacade.getOrdrelist();

        System.out.println(ordrelist.get(0).getDato());
    }

    @Test
    void createordre() throws DatabaseException {
        OrdreFacade.createordre("Mikkel");
    }
}