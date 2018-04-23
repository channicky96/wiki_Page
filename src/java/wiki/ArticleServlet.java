package wiki;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author placy
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
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Section test = new Section();
        test.setTitle("each");
        test.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                + "Sed id dui ac ex eleifend malesuada. Suspendisse ut metus enim. Cras pretium purus nulla. Suspendisse blandit, nulla id tincidunt dignissim, orci justo commodo enim, ut luctus tortor urna et nisl. Praesent non ante ac arcu pellentesque congue et non nisi. Cras vel eros dapibus, finibus ipsum at, lobortis massa. Mauris elementum lobortis nibh sit amet tempus. Vivamus ac tincidunt arcu. Curabitur vehicula tincidunt metus. Pellentesque in iaculis orci, in rhoncus ante. Maecenas at dolor id felis finibus suscipit sed condimentum turpis. Nam dui lorem, vestibulum et felis quis, laoreet maximus tellus. Maecenas et lorem enim. Nullam iaculis augue in ligula ultrices tempus. Donec pulvinar id nisi a consequat. Nunc faucibus condimentum massa."
                + "<br/>Donec finibus pellentesque augue");
        
        Article testArticle = new Article();
        testArticle.setName("Sandbox");
        testArticle.addSection(test);
        testArticle.addSection(test);
        
        List<Section> sendSections = testArticle.getSections();
        
        request.setAttribute("name", testArticle.getName());
        request.setAttribute("sections", sendSections);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/sandbox.jsp");
        dispatcher.forward(request, response);
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
