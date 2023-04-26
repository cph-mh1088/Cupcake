package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;
import dat.backend.model.persistence.UserMapper;

import javax.servlet.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServletLogincondition", value = "/ServletLogincondition")
public class ServletLogincondition extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        session = request.getSession();
        // adding user object to session scope
        User user = (User) session.getAttribute("user");

        if (user.getRole().equals("admin")) {
            request.getRequestDispatcher("WEB-INF/welcomeAdmin.jsp").forward(request, response);
        } else if (!user.getRole().equals("admin")) {

            request.getRequestDispatcher("WEB-INF/welcomeUser.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        String brugernavn = request.getParameter("brugernavn");
        int beløb = 0;

        try {
            beløb = Integer.parseInt(request.getParameter("belob"));
        } catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
        }
        session.setAttribute("beløb", beløb);
        try {
            UserFacade.indsætBeløb(beløb, brugernavn, connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/welcomeAdmin.jsp").forward(request, response);
    }
}