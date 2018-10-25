package pl.msoroka.javaee.zad03.web;

import com.sun.org.apache.xpath.internal.operations.Bool;
import pl.msoroka.javaee.zad03.domain.Plane;
import pl.msoroka.javaee.zad03.service.StorageService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/all-planes")
public class AllPlanesServlet extends HttpServlet {

	StorageService ss = new StorageService();
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		String producer = request.getParameter("producer");
//		Date productionDate = new Date(request.getParameter("productionDate"));
		Date productionDate = new Date(1996,01,01);
		double combustion = Double.parseDouble(request.getParameter("combustion"));
		boolean vipStatus = Boolean.parseBoolean(request.getParameter("vipStatus"));
		
		Plane newPlane = new Plane(producer, productionDate, combustion, vipStatus);

		ss.add(newPlane);

		List<Plane> allPlanes = ss.getAllPlanes();

		out.append("<html><body><h2>All Planes:</h2>");

		for (Plane plane: allPlanes) {
			out.append("<p>Producer: " + plane.getProducer() + "</p>");
			out.append("<p>Production date: " + plane.getProductionDate() + "</p>");
			out.append("<p>Combustion: " + plane.getCombustion() + "</p>");
			out.append("<p>Vip Status: " + plane.isVipStatus() + "</p><br>");
		}

		out.append("</body></html>");
		out.close();
	}
}
