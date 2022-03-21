import com.afrozaar.wordpress.wpapi.v2.Wordpress;
import com.afrozaar.wordpress.wpapi.v2.model.User;
import lombok.SneakyThrows;
import lombok.val;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Users implements Runnable{

    private long existingUsers = 0;
    private final Wordpress client;
    private final ArrayList<User> newUsers = new ArrayList<>();
    private ArrayList<User> toRegisterUsers = new ArrayList<>();

    public Users(Wordpress client){
        this.client = client;
    }

    /**
     * Gets a list of all the users
     *
     * @return
     *  | @code{List<User>}
     */
    public List<User> getUsers(){ return this.client.getUsers(); }

    @SneakyThrows
    private void getExistingUsers() {

        val stmt = JdbcConnector.getHickari().getConnection().createStatement();
        val st = "SELECT * FROM RegisteredUser";
        val rs = stmt.executeQuery(st);

//        List<User> usersInWordp

        while (rs.next()){
            existingUsers ++;

        }

    }

    /**
     * Get a list of all the new users since last time checked.
     *
     * @pre
     *  | userList!==null
     * @post
     *  |
     * @param userList
     *
     *
     */
    public void getNewUsers(List<User> userList){

        /*if ((long) userList.size() > existingUsers){
            newUsers.clear();

            int existIndex = 0;
            if (existingUsers > 0)
                existIndex = (int)existingUsers;

            for (int i = (int)existingUsers; i < userList.size(); i++)
                newUsers.add(userList.get(i));

            existingUsers += newUsers.size();

            notifyObservers();
        }*/
    }

    private ArrayList<Observer> observers = new ArrayList();
    public void setObserver(Observer ob){
        observers.add(ob);
    }
    private void notifyObservers(){
        for(Observer ob : observers)
            ob.getNotice();
    }
    public ArrayList<User> getList(){
        return newUsers;
    }


    ////****////
    @Override
    public void run() {
        getNewUsers(getUsers());
    }
}
