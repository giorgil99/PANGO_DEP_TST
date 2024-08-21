package ge.gl.pango.db;

import ge.gl.pango.db.model.AddUser;
import ge.gl.pango.db.model.GetUser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

// Takes data from sql sever

public class DataFromSQL {

    public void initializeDb() {
        try {
            Statement statement = ServerConnector.getConnection().createStatement();
            String createTable = "CREATE TABLE IF NOT EXISTS users(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(256) NOT NULL, job VARCHAR(256) NOT NULL)";

            statement.execute(createTable);
        } catch (Exception ex) {

        }
    }

    public void addUser(AddUser user) {
        try {
            String insertUser = "INSERT INTO users (name,job) VALUES (?,?)";
            PreparedStatement statement = ServerConnector.getConnection().prepareStatement(insertUser);
            statement.setString(1, user.getName());
            statement.setString(2, user.getJob());
            statement.executeUpdate();
        } catch (Exception e) {

        }
    }

    public GetUser getUser(int id) {
        try {
            String queryUser = "SELECT * FROM users WHERE ID = ?";
            PreparedStatement statement = ServerConnector.getConnection().prepareStatement(queryUser);
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return new GetUser(rs.getInt("ID"), rs.getString("NAME"), rs.getString("JOB"));
                }
            }
        } catch (Exception ex) {

        }

        return null;
    }

    public GetUser getUserWithName(String name) {
        try {
            String queryUser = "SELECT * FROM users WHERE name = ?";
            PreparedStatement statement = ServerConnector.getConnection().prepareStatement(queryUser);
            statement.setString(1, name);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return new GetUser(rs.getInt("ID"), rs.getString("NAME"), rs.getString("JOB"));
                }
            }
        } catch (Exception ex) {

        }

        return null;
    }

    public void updateUser(String name, String newName) {
        try {
            String insertUser = "UPDATE  users set name = ? where name = ?";
            PreparedStatement statement = ServerConnector.getConnection().prepareStatement(insertUser);
            statement.setString(1, newName);
            statement.setString(2, name);
            statement.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void deleteUser(String name) {
        try {
            String insertUser = "DELETE  from users where name = ?";
            PreparedStatement statement = ServerConnector.getConnection().prepareStatement(insertUser);
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void cleanupDb() {
        try {
            Statement statement = ServerConnector.getConnection().createStatement();
            String dropDbQuery = "DROP ALL OBJECTS";
            statement.execute(dropDbQuery);
        } catch (Exception ex) {

        }
    }

    public boolean checkUSerWithName(String name) {
        try {
            String queryUser = "SELECT * FROM users WHERE name = ?";
            PreparedStatement statement = ServerConnector.getConnection().prepareStatement(queryUser);
            statement.setString(1, name);
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next();
            }
        } catch (Exception ex) {

        }

        return false;
    }

}
