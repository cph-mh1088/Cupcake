package dat.backend.model.persistence;

import dat.backend.model.entities.Ordre;
import dat.backend.model.exceptions.DatabaseException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.SQLException;
import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrdreMapperTest {

    private ConnectionPool connectionPool;

@BeforeAll
void setup() throws SQLException {
    this.connectionPool = new ConnectionPool();
    connectionPool.getConnection();
}

    @Test
    void ordreliste() throws DatabaseException {

        ArrayList<Ordre> ordreliste = OrdreMapper.ordreliste(connectionPool);

        System.out.println(ordreliste.get(0).getBrugernavn());
    }

    @Test
    void createorder() throws DatabaseException {

        int id = OrdreMapper.createOrdre(connectionPool,"Malde");
        System.out.println("orderid is:"+id);
    }


}