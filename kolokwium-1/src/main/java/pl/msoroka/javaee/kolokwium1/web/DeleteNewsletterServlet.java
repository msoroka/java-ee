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
import java.util.Iterator;
import java.util.List;

@WebServlet("/deleteNewsletter")
public class DeleteNewsletterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        NewsletterService ns = (NewsletterService)getServletContext().getAttribute("app_news");

        List<Newsletter> allNewsletters = ns.getAllNewsletters();

        String name = request.getParameter("name");

        for (Iterator<Newsletter> iter = allNewsletters.listIterator(); iter.hasNext(); ) {
            Newsletter a = iter.next();
            if (a.getName().equals(name)) {
                iter.remove();
                out.append("<p>Usunieto z newslettera</p>");
            }
        }

        out.append("<a href='newsletters'>Przenies do wszystkich newsletterow</a>");
        out.append("</body></html>");
        out.close();

    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("app_news", new NewsletterService());
    }
}