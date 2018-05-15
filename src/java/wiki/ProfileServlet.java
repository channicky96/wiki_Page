package wiki;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author acc16scu
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        int userid = (Integer) session.getAttribute("userID");
        response.setContentType("text/html;charset=UTF-8");

        // Send bookmarked list and articles that a user has edited to userdetail so it can be viewed 
        ArrayList<String> bkmrklist = new ArrayList<>();
        ArrayList<String> myArticles = new ArrayList<>();
        bkmrklist = bookmarkList(userid);
        myArticles = showMyArticles(userid);
        session.setAttribute("bmlist", bkmrklist);
        session.setAttribute("myArticles", myArticles);
        response.sendRedirect("/NoodlesWiki/userdetail.jsp");
    }

    // Function to retrieve a list of bookmarked articles for a user
    public static ArrayList bookmarkList(int userid) {
        ArrayList<String> bkmrklist = new ArrayList<>();
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            ResultSet articleRs = st.executeQuery("select articleid, name from bookmarks INNER JOIN articles ON articles.id = bookmarks.articleid where userid ='" + userid + "'");
            while (articleRs.next()) {
                bkmrklist.add(articleRs.getString("name"));
            }
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bkmrklist;
    }

    // Function to retrieve a list of articles for a user that they have contributed towards
    public ArrayList showMyArticles(int userid) {
        ArrayList<String> myArticles = new ArrayList<>();
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            ResultSet articleRs = st.executeQuery("select name from articles where creator = '" + userid + "'");
            while (articleRs.next()) {
                myArticles.add(articleRs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myArticles;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
