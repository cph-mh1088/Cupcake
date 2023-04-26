package dat.backend.control;

import dat.backend.model.entities.Ordre;
import dat.backend.model.entities.Product;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.OrdreFacade;
import dat.backend.model.persistence.ProduktFacade;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ServletToBuypage", value = "/ServletToBuypage")
public class ServletToBuypage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


        boolean ifloggedin = (boolean) session.getAttribute("ifloggedin");

        if (ifloggedin == false) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        request.getRequestDispatcher("buypage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User brugernavn = (User) session.getAttribute("user");
        int currentSaldo = (Integer) session.getAttribute("userSaldo");
        ArrayList<Product> test = (ArrayList<Product>) session.getAttribute("kurvindhold");

        int orderId = 0;
        try {
            orderId = OrdreFacade.createordre(brugernavn.getUsername());
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        try {
            ArrayList<Ordre> ordrelist = OrdreFacade.getOrdrelist();
            session.setAttribute("ordreindhold",ordrelist);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }


        int belob = 0;
        for (Product product : test) {
            belob += product.getPrice();
            ProduktFacade.createProduct(product.getTop(), product.getBottom(), product.getPrice(), orderId, String.valueOf(product.getAmount()));
        }

        if (currentSaldo >= belob) {
            int opdateretSaldo = currentSaldo - belob;
            try {
                UserFacade.updateSaldo(brugernavn.getUsername(), opdateretSaldo);
            } catch (SQLException | DatabaseException sqlException) {
                sqlException.printStackTrace();
            }
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
