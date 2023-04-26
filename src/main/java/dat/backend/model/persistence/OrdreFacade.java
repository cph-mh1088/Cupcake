package dat.backend.model.persistence;

import dat.backend.model.entities.Ordre;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrdreFacade {

    public static ArrayList<Ordre> getOrdrelist() throws DatabaseException {
        ConnectionPool connectionPool = new ConnectionPool();
        try {
            connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return OrdreMapper.ordreliste(connectionPool);
    }

    public static int createordre(String bruger) throws DatabaseException {
        ConnectionPool connectionPool = new ConnectionPool();
        try {
            connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return OrdreMapper.createOrdre(connectionPool, bruger);

    }


}
