package dat.backend.control;

import dat.backend.model.entities.Product;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.OrdreFacade;
import dat.backend.model.persistence.ProduktFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletBuy", value = "/ServletBuy")
public class ServletBuy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user"); //Henter user ned
        int orderId = 0;
        boolean ifloggedin = (boolean) session.getAttribute("ifloggedin");

        if (ifloggedin == false) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        try {
            orderId = OrdreFacade.createordre(user.getUsername()); //Laver et ordre id til user
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        ArrayList<Product> currentBasket = new ArrayList<>(); // Laver ArrayList til at holde på nuværende kurv.

        currentBasket = (ArrayList<Product>) session.getAttribute("kurvindhold"); //Så har den alle produkter i kurven

        for (Product product : currentBasket) {
            ProduktFacade.createProduct(product.getTop(), product.getBottom(), product.getPrice(), orderId, String.valueOf(product.getAmount()));
        }


        request.getRequestDispatcher("index").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
