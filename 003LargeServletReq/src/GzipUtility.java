import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

public class GzipUtility {

    /*returns true if gzip encoding is supported*/
    public static boolean isGzipSupported(HttpServletRequest request){
        String encoding=request.getHeader("Accept-Encoding");
        return (null!=encoding)&&(encoding.contains("gzip"));
    }

    /*returns true if Gzip is disable*/
    public static boolean isGzipDisabled(HttpServletRequest request){
        String flag=request.getParameter("disableGzip");
        return (flag!=null)&&(!flag.equalsIgnoreCase("false"));
    }

    /*This method encodes httpServlet response and returns printWriter obj*/
    public static PrintWriter getGzipWriter(HttpServletResponse response) throws IOException{
        return (new PrintWriter(new GZIPOutputStream(response.getOutputStream())));
    }


}
