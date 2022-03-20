
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnector {

    public static Connection makeConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.
                    getConnection("jdbc:oracle:thin:@10.3.56.3:8002/frontend"
                            ," frontend","hH6QbNdqeVxKTM23uW3EvrS7RgdP7CLZ");
            Statement stmt = con.createStatement();
            createTables(stmt);
            System.out.println("Created DB Connection....");
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void createTables(Statement stmt) throws SQLException{
        String sqlCreate = "CREATE TABLE IF NOT EXIST " + "RegisteredUser"
                + "name Varchar(225)"
                + "email Varchar(225)";
        stmt.execute(sqlCreate);
    }
}
