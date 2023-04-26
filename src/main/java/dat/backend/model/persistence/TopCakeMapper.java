package dat.backend.model.persistence;

import dat.backend.model.entities.TopCake;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TopCakeMapper {

    static ArrayList<TopCake> toppingList(ConnectionPool connectionPool) throws DatabaseException {
        String sql = "SELECT * FROM top";
        ArrayList<TopCake> toppinglist = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement pre = connection.prepareStatement(sql)) {
                ResultSet rs = pre.executeQuery(); //Laver resultset baseret på ordre fra databasen

                while (rs.next()) {
                    TopCake topCake = new TopCake(null, 0); //Laver et ordre objekt.

                    //Sætter ordre til at passe med ordre fra databasen.
                    topCake.setNavn(rs.getString(1));
                    topCake.setPris(rs.getInt(2));

                    toppinglist.add(topCake); //Adder ordre til ArrayList.
                }
            } catch (SQLException ex) {
                throw new DatabaseException(ex, "Something with the sql or the java syntax is wrong");
            }

        } catch (SQLException e) {
            throw new DatabaseException(e, "Error logging in. Something went wrong with the database");
        }

        return toppinglist;
    }
}
