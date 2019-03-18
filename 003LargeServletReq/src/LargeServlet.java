import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LargeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out;

        /*Using Gzip for compressing*/
        if (GzipUtility.isGzipSupported(req)&& !GzipUtility.isGzipDisabled(req)){
            out=GzipUtility.getGzipWriter(resp);
            resp.setHeader("Content-Encoding","gzip");

        }else {
            out=resp.getWriter();
        }

        String dummyText="Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. ";

        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>");
        out.println("Large Servlet request");
        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>");
        out.println("Showing Large Servlet request");
        out.println("</h3>");

        for (int i=0;i<2000;i++){
            out.println(dummyText+"<br>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();

    }
}
