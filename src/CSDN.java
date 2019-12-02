import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CSDN {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/csdn?useSSL=false",
                "root",
                "123456789"
        );
            try(Statement statement = connection.createStatement()){
                statement.executeUpdate("CREATE  table LOADING(USER_ID VARCHAR (10) NOT NULL, USER_CODE VARCHAR(20) NOT NULL)");
            }

        connection.close();
    }
}
