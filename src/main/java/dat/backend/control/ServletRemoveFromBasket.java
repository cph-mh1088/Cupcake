package dat.backend.control;

import dat.backend.model.entities.Product;
import dat.backend.model.persistence.ProduktFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet(name = "ServletRemoveFromBasket", value = "/ServletRemoveFromBasket")
public class ServletRemoveFromBasket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String order = request.getParameter("order");
        ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("kurvindhold");

        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.toString().equals(order)) {
                iterator.remove();
                break; // Exit the loop after removing the item
            }
        }

        session.setAttribute("kurvindhold", products);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
