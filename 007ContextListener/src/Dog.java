import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Dog{

//public class Dog implements HttpSessionBindingListener {

    private String breed;

    public Dog(String breed){
        this.breed=breed;
    }

    public String getBreed(){
        return breed;
    }

   /* @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        //I'm in a session means is added to session
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        //I'm not in a session means is removed from session
    }*/
}
