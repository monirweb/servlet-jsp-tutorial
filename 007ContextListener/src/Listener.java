import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext scx=servletContextEvent.getServletContext();
        String dogBreed=scx.getInitParameter("breed");
        Dog d=new Dog(dogBreed);
        scx.setAttribute("dog",d);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //nothing is needed here !
    }
}
