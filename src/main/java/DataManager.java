import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.requery.sql.EntityDataStore;
import io.requery.sql.SchemaModifier;
import io.requery.sql.TableCreationMode;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import lombok.val;
import tables.AbstractUser;

@UtilityClass
@Log
public class DataManager {

    @Getter
    private HikariDataSource hickari;

    @Getter
    private EntityDataStore<AbstractUser> usersStore;

    @SneakyThrows
    public void init() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://10.3.56.3:5002/frontend");
        config.setUsername("frontend");
        config.setPassword("hH6QbNdqeVxKTM23uW3EvrS7RgdP7CLZ");

        hickari = new HikariDataSource(config);
        usersStore = new EntityDataStore<>(hickari, Models.DEFAULT);
        new SchemaModifier(hickari, Models.DEFAULT).createTables(TableCreationMode.CREATE_NOT_EXISTS);

        createTables();
        log.info("Created DB Connection....");

    }

    @SneakyThrows
    private static void createTables() {
        /*val stmt = hickari.getConnection().createStatement();
        val sqlCreate = "CREATE TABLE IF NOT EXISTS RegisteredUser "
                + "(id INTEGER not NULL, " +
                " username Varchar(225), "
                + " email Varchar(225))";
        stmt.execute(sqlCreate);*/
    }
}
