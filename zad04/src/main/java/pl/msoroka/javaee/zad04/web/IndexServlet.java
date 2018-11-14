package pl.msoroka.javaee.zad04.web;

import pl.msoroka.javaee.zad04.service.StorageService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class IndexServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StorageService ssRodo = (StorageService) getServletContext().getAttribute("rodo_service");

        if(ssRodo.getRodoStatus()) {
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