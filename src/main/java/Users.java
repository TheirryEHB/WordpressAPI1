import com.afrozaar.wordpress.wpapi.v2.Wordpress;
import com.afrozaar.wordpress.wpapi.v2.model.User;

import java.util.ArrayList;
import java.util.List;

public class Users implements Runnable{

    private long existingUsers = 0;
    private final Wordpress client;

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

    ArrayList<User> newUsers = new ArrayList<>();
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

        if ((long) userList.size() > existingUsers){
            for (int i = (int) existingUsers; i < userList.size(); i++)
                newUsers.add(userList.get(i));

            existingUsers = newUsers.size();
            notifyObservers();
        }
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
