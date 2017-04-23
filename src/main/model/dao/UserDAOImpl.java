package main.model.dao;

import main.model.pojo.Users;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;
import java.util.List;

/**
 * Created by admin on 20.04.2017.
 */
public class UserDAOImpl implements UserDAO {
//    static{
//        PropertyConfigurator.configure("lo4j.properties");
//    }
private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
    private Connection connection;
    // private ConnectionPool connectionPool;

    public static final String SELECT_ALL_USERS = "SELECT * FROM USERS";
    public static final String INSERT_USERS = "INSERT INTO USERS" +
            "(login, password, isblocked) VALUES(?, ?, ?)";
    public static final String UPDATE_USERS = "UPDATE users SET " +
            "login=?, password=? WHERE id=?";
    public static final String DELETE_USER = "DELETE FROM users WHERE id=?";
    public static final String FIND_USER = "SELECT * FROM users WHERE login = ? AND password = ?";

    public UserDAOImpl(Connection connection){//}, ConnectionPool connectionPool) {
        this.connection = connection;
        //this.connectionPool = connectionPool;
    }

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            //Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
            e.printStackTrace();
        }

        return ps;
    }

    public void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
               // Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
                e.printStackTrace();
            }
        }
    }


    public void insertUser(String login, String password) {
        PreparedStatement preparedStatement = getPrepareStatement(INSERT_USERS);
        try {
            //preparedStatement.setLong(1, usersInformation.getId());
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setLong(3, 0);
            preparedStatement.executeUpdate();
            closePrepareStatement(preparedStatement);
        } catch (SQLException e) {
            LOGGER.error("insertUser",e);
            //Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
            e.printStackTrace();
        }
    }

    public List<Users> getAll() {
        return null;
    }

    public void updateUser(Users user) {

    }

    public void deleteUser(Integer id) {
        PreparedStatement preparedStatement = getPrepareStatement(DELETE_USER);
        try {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e){
           // Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
            e.printStackTrace();
        }finally {
            closePrepareStatement(preparedStatement);
        }
    }

    public Users findUserByLoginAndPassword(String login, String password) {
        Users user = null;
        PreparedStatement preparedStatement = getPrepareStatement(FIND_USER);
        try {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = createEntity(resultSet);
            }

            //logger.debug("user " + user);
        } catch (SQLException e) {
            //logger.error(e);
            //Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
            e.printStackTrace();
        }

        return user;
    }

    private Users createEntity(ResultSet resultSet) throws SQLException {
        return new Users(resultSet.getLong("id"),
                resultSet.getString("login"),
                resultSet.getString("password"),
                resultSet.getInt("isblocked"));
    }

    public Users get(Integer id){
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM USERS WHERE id = " + id.toString());
            while (result.next()) {
                Users m = new Users(result.getLong("id"), result.getString("login"),
                        result.getString("password"),result.getInt("isblocked"));
                return m;
            }
        } catch (SQLException e) {
            e.printStackTrace();
           // Logger.getLogger(Exception.class.getName()).log(Level.ERROR, "Catch SQLException", e);
            //IProLogger.LOGGER.error(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
        return null;

    }
}