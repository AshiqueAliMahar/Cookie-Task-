package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class Preference extends HttpServlet {
	private static final long serialVersionUID = 1L;
    final static String MENU=""
    		+ "<a href='CookieInfo'>Cookie Info</a>&nbsp&nbsp"
    		+ "<a href='CookieClass'>Cookie Class</a>&nbsp&nbsp"
    		+ "<a href='Preference'>Preference</a>&nbsp&nbsp";
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String form=""
    			+ "<form method='post'>"
    			+ "Font Size:"
    			+ "<select name='fSize'>"
    			+ "<option value='Large'>Large</option>"
    			+ "<option value='x-Large'>x-Large</option>"
    			+ "<option value='xx-Large'>xx-Large</option>"
    			+ "</select>"
    			+ "<br>"
    			+ "Title Style & Weight:"
    			+ "<select multiple name='tW'>"
    			+ "<option value='Italic'>Italic</option>"
    			+ "<option value='Bold'>Bold</option>"
    			+ "</select>"
    			+ "<br>"
    			+ "Max.Records In Table:"
    			+ "<select name='noRcrd'>"
    			+ "<option value='5'>5</option>"
    			+ "<option value='10'>10</option>"
    			+ "</select>"
    			+ "<br>"
    			+ "<button type='submit' name='save' value='set'>Set</button>"
    			+ "</form>";
    	PrintWriter out = response.getWriter();
    	response.setContentType("text/html");
    	out.print(MENU);
    	out.print(form);
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String set=request.getParameter("save");
		PrintWriter out = response.getWriter();
		if (set!=null) {
			
			String fSize = request.getParameter("fSize");
			String [] tW = request.getParameterValues("tW");
			String noRcrd = request.getParameter("noRcrd");
			
			if (fSize!=null && tW!=null && noRcrd!=null) {
			
				Cookie fSizeCookie=new Cookie("fSize", fSize);
				Cookie noRcrdCookie=new Cookie("noRcrd", noRcrd);
				Cookie titleCookie=new Cookie("Italic", "");;
				Cookie boldCookie=new Cookie("Bold", "");
				for (String tWStr : tW) {
					if (tWStr.equals("Bold")) {
						boldCookie=new Cookie("Bold", tWStr);
					}else if (tWStr.equals("Italic")) {
						titleCookie=new Cookie("Italic", tWStr);
					}
				}
				response.addCookie(fSizeCookie);
				response.addCookie(noRcrdCookie);
				response.addCookie(titleCookie);
				response.addCookie(boldCookie);
				out.print(MENU+"<h1>Cookies Values Assigned Successfully</h1>");
			}else {
				out.print(MENU+"<br>Select All Fields");
				
			}
		}
	}

}
