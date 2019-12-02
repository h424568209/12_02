import java.sql.*;

public class JDBC_Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1 注册JDBC
        Class.forName("com.mysql.jdbc.Driver");
        //2 通过DriverManager 获取数据库链接
        Connection connection = DriverManager.getConnection(
                //smms为数据库的名字，必须为自己数据库含有的数据库名称
            "jdbc:mysql://localhost:3306/smms?useSSL=false",
                //用户名称
                "root",
                //密码
                "123456789"
        );
        //增删改操作  rows返回的是修改的行数
        Statement s = connection.createStatement();
        int rows = s.executeUpdate("INSERT into classes(name) values ('60#C++')");
        System.out.println(rows);
        s.close();

        Statement statement = connection.createStatement();
        // 查询使用executeQuery
         ResultSet resultSet = statement.executeQuery("SELECT * from classes ");
        while(resultSet.next()){
            String tablename = resultSet.getString(1);
            System.out.println(tablename);
        }
        statement.close();
    }
}
