
import com.afrozaar.wordpress.wpapi.v2.Wordpress;
import com.afrozaar.wordpress.wpapi.v2.config.ClientConfig;
import com.afrozaar.wordpress.wpapi.v2.config.ClientFactory;
import com.afrozaar.wordpress.wpapi.v2.model.User;

//JDBC
import java.sql.Connection;

//RabbitMQ
import com.rabbitmq.client.ConnectionFactory;
//import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) {

        Wordpress client = getWordpressClient();


        JdbcConnector.init();


        /*ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");*/

       /* try(Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }*/

        Observer1 ob1 = new Observer1(client);


    }

    /**
     * Aanmaken van worpress client
     *
     * @return
     *      | @code{Wordpress}
     */
    //frontendAPI
    //Sp8RmBz2a4pG(H0n&70!Bqc0
    public static Wordpress getWordpressClient(){
        String baseUrl = "http://10.3.56.3/wp-json/";
        String username = "frontendAPI";
        String password = "Sp8RmBz2a4pG(H0n&70!Bqc0";
        boolean debug = true;

        return ClientFactory.fromConfig(ClientConfig.of(baseUrl, username, password, false, debug));
    }


/*
 *  Volledige url voor json gebruikers
 *  http://10.3.56.3/wp-json/wp/v2/users
 */


}
