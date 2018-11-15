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

@WebServlet("/sign-newsletter")
public class SignNewsletterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //session context
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();

        Newsletter sNewsletter = null;
        String name = request.getParameter("name");
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String frequency = request.getParameter("frequency");
        String selectedSubjects = "";
        for (String subject : request.getParameterValues("subjects")) {
            selectedSubjects += subject + " ";
        }

        if (session.getAttribute("sess_news") == null) {
            sNewsletter = new Newsletter(name, from, to, frequency, selectedSubjects);
        } else {
            sNewsletter = (Newsletter) session.getAttribute("sess_news");

            sNewsletter.setName(name);
            sNewsletter.setFrom(from);
            sNewsletter.setTo(to);
            sNewsletter.setFrequency(frequency);
            sNewsletter.setSubjects(selectedSubjects);
        }



        NewsletterService ns = (NewsletterService)getServletContext().getAttribute("app_news");

        ns.addNewsletter(sNewsletter);

        session.setAttribute("sess_news", sNewsletter);

        response.sendRedirect("thanks.jsp");
    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("app_news", new NewsletterService());
    }
}