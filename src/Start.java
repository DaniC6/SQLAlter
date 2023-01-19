import java.sql.*;

public class Start {
    static final String DB_NAME = "newdb";
    static final String URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
    static final String USER = "root";
    static final String PASSWORD = "060891";

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection (URL,USER,PASSWORD );
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE students SET country = ? WHERE first_name = ?")){

            statement.executeUpdate("ALTER TABLE students ADD country VARCHAR(30) NOT NULL");

            setCountry (preparedStatement,"Italy","Daniele");
            setCountry (preparedStatement,"Italy","Gerardo");
            setCountry (preparedStatement,"Germany","Donato");
            setCountry (preparedStatement,"Germany","Arrigo");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public static void setCountry(PreparedStatement preparedStatement, String country, String name) throws SQLException {

        preparedStatement.setString (1,country);
        preparedStatement.setString ( 2,name);
        preparedStatement.executeUpdate();

    }


}
