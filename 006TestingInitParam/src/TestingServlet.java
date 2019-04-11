import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class TestingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.print("<h2>"+"Testing init param"+"</h2>");

        Enumeration en=getServletConfig().getInitParameterNames();
        while (en.hasMoreElements()){
            out.println("param : "+en.nextElement()+"<br>");
        }

        out.println("<br>");
        out.println(getServletConfig().getInitParameter("mail")+"<br>");
        out.println(getServletConfig().getInitParameter("number")+"<br>");
    }
}
