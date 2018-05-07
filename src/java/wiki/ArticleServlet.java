package wiki;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author btk16xmu
 */
@WebServlet(name = "ArticleServlet", urlPatterns = {"/article/"})
public class ArticleServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String searchWord = request.getParameter("keyword");

        HttpSession session = request.getSession();
        int pageid = 11;

        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            // case insensitive
            ResultSet articleRs = st.executeQuery("select * from articles where LOWER(name) = LOWER('" + searchWord + "');");

            String dbArticle = null;
            int aId = 0;
            double aRate = 3.0;
            Article result = null;

            while (articleRs.next()) {
                dbArticle = articleRs.getString("name");
                aId = articleRs.getInt("id");
                aRate = articleRs.getDouble("rate");
                //TODO
            }
            if (dbArticle != null) {
                Article foundArticle = new Article();
                foundArticle.setName(dbArticle);
                foundArticle.setId(aId);
                foundArticle.setRate(aRate);
                articleRs.close();
                ResultSet sectionRs = st.executeQuery("select * from sections where article_id ='" + aId + "' ORDER BY section_order");
                while (sectionRs.next()) {
                    Section temp = new Section();
                    temp.setTitle(sectionRs.getString("title"));
                    temp.setContent(sectionRs.getString("content"));

                    foundArticle.addSection(temp);
                }
                result = foundArticle;
            }
            if (result == null) {
                ArrayList<String> matches = new ArrayList<>();
                ResultSet similar = st.executeQuery("select * from articles where LOWER(name) LIKE LOWER('" + searchWord + "%');");

                while (similar.next()) {
                    matches.add(similar.getString("name"));
                }

                if (matches.isEmpty()) {
                    response.sendRedirect("/NoodlesWiki/404.jsp");
                    return;
                } else {
                    request.setAttribute("matchList", matches);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/404.jsp");
                    dispatcher.forward(request, response);
                    return;
                }
            }
            connectionUrl.close();

            List<Section> sendSections = result.getSections();

            pageid = result.getId();
            String loginchk = (String) session.getAttribute("username");
            request.setAttribute("name", result.getName());
            request.setAttribute("sections", sendSections);
            if (loginchk != null) {
                int userid = (Integer) session.getAttribute("userID");
                int chk = checkBookmarks(userid, pageid);
                session.setAttribute("bookmark", chk);
                
            } else {
                session.setAttribute("bookmark", 0);
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayArticle.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int userid = (Integer) session.getAttribute("userID");
        removeBookmark(userid, pageid);
        response.sendRedirect("/NoodlesWiki/404.jsp");
//            } else if (searchWord == null || "".equals(searchWord)) {
//                System.out.println("pssseddededededededededededededed");
//                response.sendRedirect("/NoodlesWiki/404.jsp");
//                //return;
//            }

    }

    public int checkBookmarks(int userid, int articleid) {
        int ans = 0;
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            ResultSet articleRs = st.executeQuery("select articleid from bookmarks where userid ='" + userid + "' and articleid ='" + articleid + "'");
            while (articleRs.next()) {
                if (articleRs.getInt("articleid") == articleid) {
                    ans = 1;
                }
            }
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    public void removeBookmark(int userid, int articleid) {
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            st.executeUpdate("delete from bookmarks where userid ='" + userid + "'and articleid ='" + articleid + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ArticleServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ArticleServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
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
