package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletCreateUser", value = "/ServletCreateUser")
public class ServletCreateUser extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        String nyBrugernavn;
        String nyPassword;
        String nyRole;

        nyBrugernavn = request.getParameter("brugernavn");
        nyPassword = request.getParameter("kodeord");
        nyRole = request.getParameter("rolle");
        session.setAttribute("brugernavn", nyBrugernavn);
        session.setAttribute("kodeord", nyPassword);
        session.setAttribute("rolle", nyRole);

        try {
            UserFacade.createUser(nyBrugernavn, nyPassword, nyRole, connectionPool);

            response.sendRedirect("index");


        } catch (DatabaseException e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
