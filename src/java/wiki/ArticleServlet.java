package wiki;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
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
        HttpSession session = request.getSession();
        int pageid;
        String searchWord = request.getParameter("keyword");
        String editedAID = request.getParameter("articleID");
        String editorContent = request.getParameter("htmlText");
        String postComment = request.getParameter("comment");
        ArrayList<Comment> commentList = new ArrayList();
        
        // edit
        if (editedAID != null) {
            try {
                int order = Integer.parseInt(request.getParameter("paraID"));
                Connection connectionUrl;
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://127.0.0.1/studentdb";
                connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
                Statement st = connectionUrl.createStatement();
                ResultSet rs = st.executeQuery("select content from sections where article_id = "
                        + editedAID + " AND section_order = " + order + ";");
                while (rs.next()) {
                    session.setAttribute("content", rs.getString("content"));
                    break;
                }
                rs.close();
                ResultSet nameRs = st.executeQuery("select name from articles where id="
                        + editedAID);
                while (nameRs.next()) {
                    session.setAttribute("aName", nameRs.getString("name"));
                    break;
                }
                nameRs.close();
                // edit
                session.setAttribute("aID", editedAID);
                session.setAttribute("sID", order);

                RequestDispatcher dispatcher = request.getRequestDispatcher("../articleeditor.jsp");
                dispatcher.forward(request, response);
                return;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArticleServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // receive editor content
        if (editorContent != null) {
            int aID = Integer.parseInt(request.getParameter("editedArticle"));
            int sID = Integer.parseInt(request.getParameter("editedSection"));
            String aName = request.getParameter("editedArticleName");

            updateSection(aID, sID, editorContent);
            ///////////////////
            searchWord = aName;
        }
        
        if (postComment != null) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            int userid = (Integer) session.getAttribute("userID");
            pageid = (Integer) session.getAttribute("pageid");

            addComment(pageid, postComment, userid, timestamp);
            commentList = showComments(pageid);
            session.setAttribute("comments", commentList);
            postComment = null;

            RequestDispatcher dispatcher = request.getRequestDispatcher("/displayArticle.jsp");
            dispatcher.forward(request, response);

        } else {

            if (searchWord == null || "".equals(searchWord)) {
                response.sendRedirect("/NoodlesWiki/404.jsp");
                return;
            }

            int chk;
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
                session.setAttribute("pageid", pageid);
                String loginchk = (String) session.getAttribute("username");
                session.setAttribute("name", result.getName());
                request.setAttribute("sections", sendSections);
                session.setAttribute("sections", sendSections);

//                ArrayList<Comment> commentList = new ArrayList();
                int userid = 0;
                if (loginchk != null) {
                    userid = (Integer) session.getAttribute("userID");
                    chk = checkBookmarks(userid, pageid);
                    session.setAttribute("bookmark", chk);

                } else {
                    session.setAttribute("bookmark", 0);
                }

                // load the comment before the dispatch
                commentList = showComments(pageid);
                session.setAttribute("comments", commentList);

                // change the icon depends on if the user has book marked the article 
                String crm = request.getParameter("bml");
                if (crm != null) {
                    if (crm.equals("rbm")) {
                        removeBookmark(userid, pageid);
                        chk = 0;
                        session.setAttribute("bookmark", chk);
                    } else if (crm.equals("abm")) {
                        addBookmark(userid, pageid);
                        chk = 1;
                        session.setAttribute("bookmark", chk);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/displayArticle.jsp");
        dispatcher.forward(request, response);
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
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addBookmark(int userid, int articleid) {
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            st.executeUpdate("insert into bookmarks (userid, articleid) values ('" + userid + "','" + articleid + "')");
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList showComments(int articleid) {
        ArrayList<Comment> cal = new ArrayList();
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            ResultSet commentRs = st.executeQuery("select nickname, comment, commentdt from comments inner join users on comments.userid=users.id where articleid = '" + articleid + "' order by commentdt desc");
            while (commentRs.next()) {
                String nickname = commentRs.getString("nickname");
                String comment = commentRs.getString("comment");
                Timestamp timestamp = commentRs.getTimestamp("commentdt");
                Comment c = new Comment(nickname, comment, timestamp);
                cal.add(c);
            }
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cal;
    }

    public void addComment(int articleid, String comment, int userid, Timestamp time) {
        //INSERT into comments(id,articleid,userid,commentdt,comment) values (3,6,5,'2018-05-08 21:17:00', 'Ronald yoyoyo')
        int maxid = 0;
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            Statement st1 = connectionUrl.createStatement();
            ResultSet rs = st.executeQuery("select max(id) as maxcid from comments");
            while (rs.next()) {
                maxid = rs.getInt("maxcid") + 1;
            }
            st.executeUpdate("INSERT into comments(id,articleid,userid,commentdt,comment) values ('" + maxid + "','" + articleid + "','" + userid + "','" + time + "','" + comment + "')");
            connectionUrl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void updateSection(int articleID, int sectionOrder, String content) {
        try {
            Connection connectionUrl;
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/studentdb";
            connectionUrl = DriverManager.getConnection(url, "student", "dbpassword");
            Statement st = connectionUrl.createStatement();
            String q = "UPDATE sections SET content='" + content + "' WHERE article_id="
                    + articleID + " AND section_order=" + sectionOrder + ";";
            //debug
            System.out.println(q);

            st.executeUpdate(q);
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
