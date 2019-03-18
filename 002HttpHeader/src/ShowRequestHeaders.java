import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ShowRequestHeaders extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*This program prints http header of request from client*/

        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>");
        out.println("Http Request Headers");
        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>");
        out.println("Showing all request headers");
        out.println("</h3>");

        out.println("<p>Request method is : </p>"+req.getMethod());
        out.println("<p>Request URI is : </p>"+req.getRequestURI());
        out.println("<p>Request protocol is : </p>"+req.getProtocol());

        Enumeration<String> headerNames=req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String hname=headerNames.nextElement();
            out.println("<p><b>"+hname+" : </b>"+req.getHeader(hname)+"</p>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
