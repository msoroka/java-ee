package pl.msoroka.javaee.zad04.web;

import pl.msoroka.javaee.zad04.domain.Plane;
import pl.msoroka.javaee.zad04.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StorageService ssRodo = (StorageService) getServletContext().getAttribute("rodo_service");

        if(!ssRodo.getRodoStatus()) {
            response.sendRedirect("/zad04/rodo-form.jsp");
        }

        //session context
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();

        StorageService ss = null;

        if (session.getAttribute("session_cart") == null) {
            ss = new StorageService();
        } else {
            ss = (StorageService) session.getAttribute("session_cart");
        }

        List<Plane> planesInCart = ss.getCart();

        out.append("<html><body><h2>All Planes in cart:</h2>");

        int total = 0;

        for (Plane plane: planesInCart) {
            out.append("<p>id: " + plane.getId() + "</p>");
            out.append("<p>Producer: " + plane.getProducer() + "</p>");
            out.append("<p>Production date: " + plane.getProductionDate() + "</p>");
            out.append("<p>Combustion: " + plane.getCombustion() + "</p>");
            out.append("<p>Price: " + plane.getPrice() + "</p>");
            out.append("<p>Vip Status: " + plane.isVipStatus() + "</p><br>");

            total += plane.getPrice();
        }

        out.append("Total: $" + total);
        out.append("<form action='purchase'>");
        out.append("<br><input type='checkbox' required='required'> I agree with privacy policy.<br>");
        out.append("<br><a href='all-planes'>Go back to shop</a><br>");
        out.append("<input type='submit' value='Buy'><br></form>");
        out.append("</body></html>");
        out.close();
    }



    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("rodo_service", new StorageService());

    }

}
