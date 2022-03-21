import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import lombok.val;

@UtilityClass
@Log
public class JdbcConnector {

    @Getter
    private HikariDataSource hickari;

    @SneakyThrows
    public void init() {

       /* Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.
                getConnection("jdbc:mysql://10.3.56.3:5002/frontend"
                        ,"frontend","hH6QbNdqeVxKTM23uW3EvrS7RgdP7CLZ");*/
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://10.3.56.3:5002/frontend");
        config.setUsername("frontend");
        config.setPassword("hH6QbNdqeVxKTM23uW3EvrS7RgdP7CLZ");

        hickari = new HikariDataSource(config);

        createTables();
        log.info("Created DB Connection....");

    }

    @SneakyThrows
    private static void createTables() {
        val stmt = hickari.getConnection().createStatement();
        val sqlCreate = "CREATE TABLE IF NOT EXISTS RegisteredUser "
                + "(id INTEGER not NULL, " +
                " username Varchar(225), "
                + " email Varchar(225))";
        stmt.execute(sqlCreate);
    }
}
