package dat.backend.model.persistence;

import dat.backend.model.entities.Ordre;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

public class OrdreMapper {

    static ArrayList<Ordre> ordreliste(ConnectionPool connectionPool) throws DatabaseException {
        String sql = "SELECT * FROM ordre";
        ArrayList<Ordre> ordreliste = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement pre = connection.prepareStatement(sql)) {
                ResultSet rs = pre.executeQuery(); //Laver resultset baseret på ordre fra databasen

                while (rs.next()) {
                    Ordre ordre = new Ordre(0, "null", null); //Laver et ordre objekt.

                    //Sætter ordre til at passe med ordre fra databasen.
                    ordre.setOrdreId(rs.getInt(1));
                    ordre.setBrugernavn(rs.getString(2));
                    ordre.setDato(rs.getTimestamp(3));

                    ordreliste.add(ordre); //Adder ordre til ArrayList.
                }
            } catch (SQLException ex) {
                throw new DatabaseException(ex, "Something with the sql or the java syntax is wrong");
            }

        } catch (SQLException e) {
            throw new DatabaseException(e, "Error logging in. Something went wrong with the database");
        }

        return ordreliste;
    }

    static int createOrdre(ConnectionPool connectionPool, String bruger) throws DatabaseException {
        String sql = "INSERT INTO ordre(bruger) VALUES (?)";
        ResultSet generatedKeys = null;
        int id = 0;

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement pre = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ) {

                pre.setString(1, bruger);

                pre.executeUpdate();
                generatedKeys = pre.getGeneratedKeys();
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                    generatedKeys.close();
                }

                if (id == 0) {
                    System.out.println("hell no");
                }


            } catch (SQLException ex) {
                throw new DatabaseException(ex, "Something with the sql or the java syntax is wrong");
            }

        } catch (SQLException | DatabaseException e) {
            throw new DatabaseException(e, "Error logging in. Something went wrong with the database");
        }
        return id;
    }

}
