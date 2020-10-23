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

/**
 * Servlet implementation class MyServletOutputAndrews
 */
@WebServlet("/MyServletOutputAndrews")
public class MyServletOutputAndrews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServletOutputAndrews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String keyword = request.getParameter("keyword");
		// TODO Auto-generated method stub
		retrieveDisplayData(response.getWriter(), keyword);
	}
	
	void retrieveDisplayData(PrintWriter out, String keyword) {
        String title = "Database Result";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
              "transitional//en\">\n"; //
        out.println(docType + //
              "<html>\n" + //
              "<head><title>" + title + "</title></head>\n" + //
              "<body bgcolor=\"#f0f0f0\">\n" + //
              "<h1 align=\"center\">" + title + "</h1>\n");
        out.println("<ul>");
        List<SocialMediaOut> listPosts = UtilDB.listPosts(keyword);
        for (SocialMediaOut post : listPosts) {
           System.out.println("[DBG] " + post.getId() + ", " //
                 + post.getName() + ", " //
                 + post.getPost() + ", " //
                 + post.getTime());

           out.println("<li>" + post.getName() + ": " + post.getPost() + "<br>at " + post.getTime() + "<br>");
        }
        out.println("</ul>");
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
