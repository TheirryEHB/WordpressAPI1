
import com.afrozaar.wordpress.wpapi.v2.Wordpress;
import com.afrozaar.wordpress.wpapi.v2.config.ClientConfig;
import com.afrozaar.wordpress.wpapi.v2.config.ClientFactory;
import com.afrozaar.wordpress.wpapi.v2.model.User;


public class Main {



    public static void main(String[] args) {

        Wordpress client = getWordpressClient();
        Observer1 ob1 = new Observer1(client);

        /*List<User> usersList = users.getUsers();
        System.out.println(usersList.get(0).getName());
        System.out.println(usersList.get(0).getUrl());*/
    }

    /**
     * Aanmaken van worpress client
     *
     * @return
     *      | @code{Wordpress}
     */
    public static Wordpress getWordpressClient(){
        String baseUrl = "http://10.3.56.3:420/wp-json";
        String username = "frontend";
        String password = "0iQb%7Ksiiv1)FI2i)";
        boolean debug = false;

        return ClientFactory.fromConfig(ClientConfig.of(baseUrl, username, password, debug, true));
    }

/*
 *  Volledige url voor json gebruikers
 *  http://10.3.56.3:420/wp-json/wp/v2/users
 */


}
