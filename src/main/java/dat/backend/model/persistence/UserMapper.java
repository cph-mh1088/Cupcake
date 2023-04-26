package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserMapper {
    static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM bruger WHERE brugernavn = ? AND kodeord = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String role = rs.getString("rolle");

                    user = new User(username, password, role);
                } else {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }

    public static User createUser(String username, String password, String role, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        String sql = "insert into bruger (brugernavn, kodeord, rolle) values (?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, role);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    user = new User(username, password, role);
                } else {
                    throw new DatabaseException("The user with username = " + username + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return user;
    }

    public static void indsætBeløb(int beløb, String brugernavn, ConnectionPool connectionPool) throws DatabaseException {

        // sql statement that takes two paramenters and stores in a String
        String penge = "UPDATE bruger SET saldo = saldo + ? WHERE brugernavn = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(penge)) {

            statement.setInt(1, beløb);
            statement.setString(2, brugernavn);
            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not update account balance for: " + brugernavn);
        }
    }

    public static int watchSaldo(ConnectionPool connectionPool, String username) throws DatabaseException {

        String sql = "SELECT saldo FROM bruger WHERE brugernavn = ?";
        int saldo = 0;

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                saldo = resultSet.getInt("saldo");
            }

        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not retrieve account balance for: " + username);
        }
        return saldo;
    }

    public static void updateSaldo(String brugernavn, int nyBrugerSaldo, ConnectionPool connectionPool) throws DatabaseException {

        String update = "UPDATE bruger SET saldo = ? WHERE brugernavn = ?";

        try (Connection connection = connectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setInt(1, nyBrugerSaldo);
            preparedStatement.setString(2, brugernavn);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new DatabaseException(sqlException, "could not update user saldo" + brugernavn);
        }
    }

}
