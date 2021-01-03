package main.java.conn;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author NINE. LIU
 * @Date 2020/10/7 15:16
 * @Version 1.0
 */
public class DBConnection {

    private static Connection  connection = null;
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_LOCATION= "jdbc:mysql://";


    private static final String DATABASE_URL2 ="192.168.43.80:3306/trade_system";
    private static final String user2 = "root";
    private static final String password2= "1234";

    private static final String DATABASE_URL ="localhost:3306/trade_system";
    private static final String user = "root";
    private static final String password = "9981";

    private static final String DATABASE_URL3 ="localhost:3306/trade_system";
    private static final String user3 = "root";
    private static final String password3 = "9981";


    public DBConnection()
    {
        try
        {
            Class.forName(JDBC_DRIVER);
            connection= DriverManager.getConnection(DATABASE_LOCATION+DATABASE_URL,user,password);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            System.out.println("main database connection fail");
            try {
                connection= DriverManager.getConnection(DATABASE_LOCATION+DATABASE_URL2,user2,password2);
            } catch (SQLException ex) {
                try {
                    connection= DriverManager.getConnection(DATABASE_LOCATION+DATABASE_URL3,user3,password3);
                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

    }



    public void closeConnection()
    {
        if(connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        ;
    }

    public Connection getConnection()
    {
        return connection;
    }

}
