/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
            if (userprofile.equals(nickname)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/userdetail.jsp");
                dispatcher.forward(request, response);
            } else {
                //tmp = other users total rating
                int tmp = sumTotalRating(userprofile);
                System.out.println(tmp + "sum totalt rating");
                //updateTotalRating = setting latest rating from user we are rating as previous sum (temp)
                updateTotalRating(userprofile, tmp);
                //P gets profile of rating
                Profile P = showUserProfile(userprofile);
                //Set "current profile" as P
                session.setAttribute("userprofile", P);
                //Check our current rating of them
                String checkR = checkRating(P.getName(), userid);
                //vote is a new variable of the new rating
                String vote = request.getParameter("vote");
                //Setting current profile's
                session.setAttribute("checkR", checkR);

//                System.out.println("OLD total rating: "+tmp);
//                System.out.println("my prev rating: "+);
//                System.out.println("New upvote: "+newupvote);
//                System.out.println("If new vote==oldvote");
                if (vote != null) {
                    System.out.println("vote" + vote);
                    System.out.println("checkR" + checkR);
                    if (checkR.equals("NR")) {
                        if (vote.equals("up")) {
                            newRate(userprofile, userid, 1);
                        } else if (vote.equals("down")) {
                            newRate(userprofile, userid, -1);
                        }
                    } else if (checkR.equals("POSITIVE") && vote.equals("down")) {
                        System.out.println("POSOTIVE");
                        updatePrevRating(userprofile, userid, -1);
                        session.setAttribute("checkR", "NEGATIVE");

                    } else if (checkR.equals("NEGATIVE") && vote.equals("up")) {
                        System.out.println("NEGATIVE");
                        updatePrevRating(userprofile, userid, 1);
                        session.setAttribute("checkR", "POSITIVE");
                    }
                    tmp = sumTotalRating(userprofile);
                    updateTotalRating(userprofile, tmp);
                }
                session.setAttribute("TotalVote", tmp);
            }
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
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            ResultSet up = st.executeQuery(upQuery);
            while (up.next()) {
                Article test = new Article();
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

    public String checkRating(String usernickname, int raterid) {
        String checkRate = "NR";
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            ResultSet crRs = st.executeQuery("select vote from user_rating where raterid = '" + raterid + "' and editornickname = '" + usernickname + "'");
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

    public void newRate(String usernickname, int raterid, int vote) {
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            st.executeUpdate("insert into user_rating (editornickname, raterid, vote) values ('" + usernickname + "','" + raterid + "','" + vote + "')");

            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePrevRating(String usernickname, int raterid, int vote) {
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            st.executeUpdate("update user_rating set vote = '" + vote + "' where editornickname = '" + usernickname + "' AND raterid = '" + raterid + "'");
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateTotalRating(String usernickname, int totalvote) {
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            st.executeUpdate("update users set rating = '" + totalvote + "' where nickname = '" + usernickname + "'");
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int sumTotalRating(String nickname) {
        int totalRating = 0;
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            ResultSet str = st.executeQuery("select SUM(vote) as totalRate from user_rating where editornickname = '" + nickname + "'");
            while (str.next()) {
                totalRating = str.getInt("totalRate");
            }
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalRating;
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
