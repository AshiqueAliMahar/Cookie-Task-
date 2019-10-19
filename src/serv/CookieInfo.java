package serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieInfo")
public class CookieInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String fSize,ftitle,fweight,noRcrd;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Cookie[] cookies = request.getCookies();
    	
    	for (Cookie cookie : cookies) {
			if (cookie.getName().equals("fSize")) {
				fSize=cookie.getValue();
			}else if (cookie.getName().equals("Bold")) {
				fweight=cookie.getValue();
			}else if (cookie.getName().equals("Italic")) {
				ftitle=cookie.getValue();
			}else if (cookie.getName().equals("noRcrd")) {
				noRcrd=cookie.getValue();
			}
		}
    	String view=""
    			+ "<h1>Cookie Info</h1>"
    			+ "Font Size:"+fSize
    			+"<br>"
    			+ "Font Weight : "+fweight
    			+"<br>"
    			+ "Font Title :"+ftitle
    			+"<br>"
    			+ "No Of Records :"+noRcrd;
    	response.setContentType("text/html");
    	response.getWriter().print(Preference.MENU+view);
	}

}
