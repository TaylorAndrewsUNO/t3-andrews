import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.SocialMediaOut;
import util.UtilDB;
import java.time.LocalDateTime;

/**
 * Servlet implementation class MyServletOutputAndrews
 */
@WebServlet("/SocialInputAndrews")
public class SocialInputAndrews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocialInputAndrews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("userName");
		String post = request.getParameter("post");
		String time = java.time.LocalDateTime.now().toString();
		
		UtilDB.createPost(name, post, time);
		
		retrieveDisplayData(response.getWriter());
	}
	
	void retrieveDisplayData(PrintWriter out) {
        String title = "Database Result";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
              "transitional//en\">\n"; //
        out.println(docType + //
              "<html>\n" + //
              "<head><title>" + title + "</title></head>\n" + //
              "<body bgcolor=\"#f0f0f0\">\n" + //
              "<h1 align=\"center\">" + title + "</h1>\n");
        out.println("Post added!");
        out.println("<a href=social_out.html>Go back to search!</a> <br>");
        out.println("</body></html>");
     }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
