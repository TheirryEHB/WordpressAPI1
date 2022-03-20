import com.afrozaar.wordpress.wpapi.v2.Wordpress;
import com.afrozaar.wordpress.wpapi.v2.config.ClientConfig;
import com.afrozaar.wordpress.wpapi.v2.config.ClientFactory;
import com.afrozaar.wordpress.wpapi.v2.model.User;

import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Observer1 implements Observer{

    private ArrayList<User> newUsers = new ArrayList<>();
    Runnable users;

    public Observer1(Wordpress client){

        // Creating a ScheduledThreadPoolExecutor object
        ScheduledThreadPoolExecutor threadPool
                = new ScheduledThreadPoolExecutor(2);

        users = new Users(client);
        ((Users) users).setObserver(this);
        threadPool.scheduleAtFixedRate(users, 0, 5, TimeUnit.SECONDS);

        // Wait for 30 seconds
        /*try {
            Thread.sleep(30000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        threadPool.shutdown();*/
    }

    @Override
    public void getNotice() {
        for ( User u : ((Users) users).getList())
            newUsers.add(u);

        for (User u : newUsers)
            System.out.println(u.getName());
        newUsers.clear();
    }

}
