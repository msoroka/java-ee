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
import java.util.List;

@WebServlet("/newsletters")
public class AllNewslettersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        NewsletterService ns = (NewsletterService)getServletContext().getAttribute("app_news");

        List<Newsletter> allNewsletters = ns.getAllNewsletters();

        out.append("<html><body><h2>Wszystkie newslettery:</h2>");
        out.append("<p>Tutaj zapisane są wszystkie dodane newslettery, ale w sesji jest tylko jeden</p><br>");

        for (Newsletter newsletter: allNewsletters) {
                out.append("<form action='deleteNewsletter'>");
                out.append("<input type='hidden' name='name' value='" + newsletter.getName() + "'/>");
                out.append("<p>Nick: " + newsletter.getName() + "</p>");
                out.append("<p>Od: " + newsletter.getFrom() + "</p>");
                out.append("<p>Do: " + newsletter.getTo() + "</p>");
                out.append("<p>Czestotliwosc: " + newsletter.getFrequency() + "</p>");
                out.append("<p>Tematy: " + newsletter.getSubjects() + "</p>");
                out.append("<input type='submit' value='Usun' />");
                out.append("</form>");
        }

        out.append("</body></html>");
        out.close();

    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("app_news", new NewsletterService());
    }
}