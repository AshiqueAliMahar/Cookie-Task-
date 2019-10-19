package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringJoiner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieClass")
public class CookieClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private final String [] COOKIEMETHODS= {
    		"clone","equals","getClass","getDomain",
    		"GetComment","getMaxAge","getName",
    		"getPath","getvalue","putValue"};
    public CookieClass() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setValues(request, response);		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String show=Preference.MENU
				+ "<h1>Cookie Class Methods</h1>";
		out.print("<html>"
				+ "<head>"
				+ "<style>"
				+ "p{"
				+ "	font-weight:"+CookieInfo.fweight+";"
						+ "font-style:"+CookieInfo.ftitle+";"
								+ "font-size:"+CookieInfo.fSize+";"
				+ "}"
				+ "</style>"
				+ "</head>"
				+ "<body>"
				+ show
				+ showMethodsHTML()
				+ "</body>");
	}
	private void setValues(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("fSize")) {
				CookieInfo.fSize=cookie.getValue();
				if (CookieInfo.fSize.equals("Large")) {
					CookieInfo.fSize="12px";
				}else if (CookieInfo.fSize.equals("x-Large")) {
					CookieInfo.fSize="20px";
				}else {
					CookieInfo.fSize="30px";
				}
			}else if (cookie.getName().equals("Bold")) {
				CookieInfo.fweight=cookie.getValue();
			}else if (cookie.getName().equals("Italic")) {
				CookieInfo.ftitle=cookie.getValue();
			}else if (cookie.getName().equals("noRcrd")) {
				CookieInfo.noRcrd=cookie.getValue();
			}
		}
	}
	private String showMethodsHTML() {
		String methodView="<p>";
		for (int i=0;i<Integer.parseInt(CookieInfo.noRcrd);i++) {
			methodView+=COOKIEMETHODS[i]+",<br>";
		}
		methodView+="</p>";
		return methodView;
	}

}
