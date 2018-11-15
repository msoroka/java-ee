package pl.msoroka.javaee.kolokwium1.web;

import pl.msoroka.javaee.kolokwium1.domain.Newsletter;
import pl.msoroka.javaee.kolokwium1.service.NewsletterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/sign-newslette")
public class SignNewsLetterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //session context
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();

        Newsletter sNewsletter = null;
        if (session.getAttribute("session_news") == null) {
            String name = request.getParameter("name");
            Date from = new Date(request.getParameter("from"));
            Date to = new Date(request.getParameter("to"));
            String frequency = request.getParameter("frequency");

            String selectedSubjects = "";
            for (String subject : request.getParameterValues("subjects")) {
                selectedSubjects += subject + " ";
            }

            sNewsletter = new Newsletter(name, from, to, frequency, selectedSubjects);
        } else {
            sNewsletter = (Newsletter) session.getAttribute("session_news");
        }



        NewsletterService ns = (NewsletterService)getServletContext().getAttribute("app_news");

        ns.addNewsletter(sNewsletter);

        session.setAttribute("session_counter", sNewsletter);

        response.sendRedirect("kolokwium1/thanks.jsp");
    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("app_news", new NewsletterService());
    }
}