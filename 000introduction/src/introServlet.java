import javafx.stage.Stage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

public class introServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //use url : http://localhost:8081/intro?fname=joe&lname=smith

        /*First method :*/
        resp.setContentType("text/html");
        PrintWriter out= resp.getWriter();
        String fname=req.getParameter("fname");
        String lname=req.getParameter("lname");
        out.println("<h3>Reading query string using -> 'String getParameter(String name)' method</h3>");
        out.println("<div>");
        out.println("<p>fname: "+fname+"</p>");
        out.println("<p>lname: "+lname+"</p>");
        out.println("</div>");
        out.println("<hr>");

        /*second method:*/
        out.println("<h3>Reading query string using -> 'Enumeration getParameterNames()' method</h3>");
        Enumeration<String> paramEnum=req.getParameterNames();
        out.println("<div>");
        while (paramEnum.hasMoreElements()){
            String paramName=paramEnum.nextElement();
            String paramValue=req.getParameter(paramName);
            out.println("<p>"+paramName+" : "+paramValue+"</P>");
        }
        out.println("</div>");
        out.println("<hr>");

        /*third method:*/
        Map<String,String[]> paramMap=req.getParameterMap();
        Set<String> paramNameSet=paramMap.keySet();
        out.println("<h3>Read query string data using 'Map getParameterMap()' method</h3>");
        out.println("<div>");
        for (String paramName : paramNameSet){
            String[] paramValues=paramMap.get(paramName);
            out.println("<p>"+paramName+":");
            for (int i=0;i<paramValues.length;i++){
                out.println(paramValues[i]);
            }
            out.println("</p>");
        }
        out.println("</div>");

    }
}
