package pl.msoroka.javaee.zad03.web;

import com.sun.org.apache.xpath.internal.operations.Bool;
import pl.msoroka.javaee.zad03.domain.Plane;
import pl.msoroka.javaee.zad03.service.StorageService;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/all-planes")
public class AllPlanesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");

        List<Plane> allPlanes = ss.getAllPlanes();

        out.append("<html><body><h2>All Planes:</h2>");

        for (Plane plane: allPlanes) {
            out.append("<p>id: " + plane.getId() + "</p>");
            out.append("<p>Producer: " + plane.getProducer() + "</p>");
            out.append("<p>Production date: " + plane.getProductionDate() + "</p>");
            out.append("<p>Combustion: " + plane.getCombustion() + "</p>");
            out.append("<p>Price: " + plane.getPrice() + "</p>");
            out.append("<p>Quantity: " + plane.getQuantity() + "</p>");
            out.append("<p>Vip Status: " + plane.isVipStatus() + "</p><br>");
        }

        out.append("</body></html>");
        out.close();
    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("storage_service", new StorageService());
    }
}
