package dat.backend.model.persistence;

import dat.backend.model.entities.BottomCake;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.SQLException;
import java.util.ArrayList;

public class BottomCakeFacade {


    public static ArrayList<BottomCake> bottomlist() throws DatabaseException {
        ConnectionPool connectionPool = new ConnectionPool();
        try {
            connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return BottomCakeMapper.bottomList(connectionPool);
    }
}
