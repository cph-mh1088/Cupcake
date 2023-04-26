package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.SQLException;

public class UserFacade {
    public static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.login(username, password, connectionPool);
    }

    public static User createUser(String username, String password, String role, ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.createUser(username, password, role, connectionPool);
    }

    public static void indsætBeløb(int beløb, String brugernavn, ConnectionPool connectionPool) throws DatabaseException {
        UserMapper.indsætBeløb(beløb, brugernavn, connectionPool);
    }

    public static int watchSaldo(String username) {
        ConnectionPool connectionPool = new ConnectionPool();
        int saldo = 0;
        try {
            connectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            saldo = UserMapper.watchSaldo(connectionPool, username);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        return saldo;
    }

    public static void updateSaldo(String brugernavn, int nyBrugerSaldo) throws SQLException, DatabaseException {
        ConnectionPool connectionPool = new ConnectionPool();
        try {
            connectionPool.getConnection();
        } catch (SQLException sqlException) {
            throw new DatabaseException(sqlException, "could not update user saldo" + brugernavn);
        }
        try {
            UserMapper.updateSaldo(brugernavn, nyBrugerSaldo, connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
