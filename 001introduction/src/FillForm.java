import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FillForm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String usr=req.getParameter("usr");
        String pass=req.getParameter("pass");
        String gender=req.getParameter("gender");
        String[]hobbies=req.getParameterValues("hobbies");
        String country=req.getParameter("country");
        String[]languages=req.getParameterValues("language");
        resp.setContentType("text/html");

        out.println("<div>");
        out.println("<p> username : "+usr+"</p>");
        out.println("<p> pass : "+pass+"</p>");
        out.println("<p> gender : "+gender+"</p>");
        out.print("<p> hobbies : </p>");
        for (String h:hobbies){
            out.println("<p>"+h+"</p>");
        }
        out.println("<p> country : "+country+"</p>");
        out.print("<p> languages : </p>");
        for (String l:languages){
            out.println("<p>"+l+"</p>");
        }
        out.println("</div>");
    }
}
