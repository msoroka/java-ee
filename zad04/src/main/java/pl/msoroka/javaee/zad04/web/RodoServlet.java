package pl.msoroka.javaee.zad04.web;

import pl.msoroka.javaee.zad04.domain.Plane;
import pl.msoroka.javaee.zad04.domain.User;
import pl.msoroka.javaee.zad04.service.StorageService;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
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
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/rodo-check")
public class RodoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        StorageService ss = (StorageService) getServletContext().getAttribute("rodo_service");

        StringBuffer url = request.getRequestURL();


        String rodo = request.getParameter("rodo");

        ss.setRodoStatus(rodo);

        HttpSession session = request.getSession();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");


        User user = null;
        if (session.getAttribute("user_session") == null) {
            user = new User(firstName, lastName, email);
        } else {
            user = (User) session.getAttribute("user_session");
        }

        session.setAttribute("user_session", user);

        if(ss.getRodoStatus()) {
            response.sendRedirect("/zad04/index.jsp");
        } else {
            response.sendRedirect("/zad04/rodo-form.jsp");
        }
    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("rodo_service", new StorageService());
    }
}
