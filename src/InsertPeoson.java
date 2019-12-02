import java.sql.*;

public class InsertPeoson {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/smms?useSSL=false",
                "root",
                "123456789"
        );
        try(Statement statement = connection.createStatement()){
            statement.executeUpdate("INSERT INTO CLASSES(NAME) VALUES ('XiangRiKuiBan')");
        }
        int classld;
        try(Statement statement = connection.createStatement()){
            try(ResultSet resultSet = statement.executeQuery(
                    "SELECT id from classes where name = 'XiangRiKuiBan'"
            )){
                resultSet.next();
                classld = resultSet.getInt(1);
            }
        }
        try(Statement statement = connection.createStatement()){
            String sql = "Insert into students(sn,class_id,name)"+
                    " Values('112',  "+classld+", 'labixiaoxin'),"+
                    " ('113', "+ classld + ", 'maoidou'),"
                    + " ('114', " + classld + ", 'sunwukong')";
            System.out.println(sql);
            statement.executeUpdate(sql);
        }
        connection.close();
    }
}
