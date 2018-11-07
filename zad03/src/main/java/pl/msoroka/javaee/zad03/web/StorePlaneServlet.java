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

@WebServlet(urlPatterns = "/store-plane")
public class StorePlaneServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		StorageService ss = (StorageService) getServletContext().getAttribute("storage_service");

		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

		String producer = request.getParameter("producer");
		Date productionDate = null;
		try {
			productionDate = formatter.parse(request.getParameter("productionDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double combustion = Double.parseDouble(request.getParameter("combustion"));
		boolean vipStatus = Boolean.parseBoolean(request.getParameter("vipStatus"));
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		int id = ss.getId();


		Plane newPlane = new Plane(id, producer, productionDate, combustion, vipStatus, price, quantity);

		ss.add(newPlane);

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
