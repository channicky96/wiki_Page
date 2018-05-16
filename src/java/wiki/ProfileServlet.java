package wiki;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        String userprofile = request.getParameter("userprofile");

        // Send bookmarked list and articles that a user has edited to userdetail so it can be viewed 
        ArrayList<String> bkmrklist = new ArrayList<>();
        ArrayList<String> myArticles = new ArrayList<>();
        bkmrklist = bookmarkList(userid);
        myArticles = showMyArticles(userid);
        session.setAttribute("bmlist", bkmrklist);
        session.setAttribute("myArticles", myArticles);
        String nickname = (String) session.getAttribute("userNickname");
        if (userprofile != null) {
            System.out.println("userprofile:" + userprofile);
            System.out.println("nickname:" + nickname);
            if (userprofile.equals(nickname)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/userdetail.jsp");
                dispatcher.forward(request, response);
            }
            Profile P = showUserProfile(userprofile);
            session.setAttribute("userprofile", P);
            String checkR = checkRating(P.getName(),userid);
            session.setAttribute("checkR", checkR);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/userProfile.jsp");
            dispatcher.forward(request, response);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/userdetail.jsp");
        dispatcher.forward(request, response);
    }

    // Function to retrieve a list of bookmarked articles for a user
    public ArrayList bookmarkList(int userid) {
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
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myArticles;
    }

    public Profile showUserProfile(String nickname) {
        String upQuery = "select users.email, users.rating, articles.name from users inner join articles on users.id=articles.creator where nickname = '" + nickname + "'";
        String upEmail = null;
        int upRate = 0;
        ArrayList<Article> upArticle = new ArrayList<>();
        Article test = new Article();
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            ResultSet up = st.executeQuery(upQuery);
            while (up.next()) {
                upEmail = up.getString("email");
                upRate = up.getInt("rating");
                test.setName(up.getString("name"));
                upArticle.add(test);
            }
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Profile userProfile = new Profile(nickname, upEmail, upRate, upArticle);
        return userProfile;
    }
    
    public String checkRating(String usernickname, int raterid){
        String checkRate = null;
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            ResultSet crRs = st.executeQuery("select vote from user_rating where raterid = '" + raterid + "' and editornickname = '"+usernickname+"'");
            while (crRs.next()) {
                int result = crRs.getInt("vote");
                switch (result) {
                    case 1:
                        checkRate = "POSITIVE";
                        break;
                    case -1:
                        checkRate = "NEGATIVE";
                        break;
                    default:
                        checkRate = "NR";
                        break;
                }
            }
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkRate;
    }
    
    public void rateUser(String usernickname, int raterid, int vote){
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            st.executeUpdate("insert into user_rating (editornickname, raterid, vote) values ('"+usernickname+"','"+raterid+"','"+vote+"')");
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateRating(String usernickname, int raterid, int vote){
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            st.executeUpdate("insert into user_rating (editornickname, raterid, vote) values ('"+usernickname+"','"+raterid+"','"+vote+"')");
            connectionUrl.close();
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
