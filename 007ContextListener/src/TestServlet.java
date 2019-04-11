import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/serve.do")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<h3>"+":Testing context attribute set by listener:"+"</h3>");
        Dog dog= (Dog) getServletContext().getAttribute("dog");
        out.println("<h3>"+"Dog's breed is "+ dog.getBreed()+"</h3>");
    }
}
