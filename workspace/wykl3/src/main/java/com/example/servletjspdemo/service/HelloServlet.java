package com.example.servletjspdemo.service;

import com.example.servletjspdemo.web.Counter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //session context
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();

        Counter sCounter = null;
        if (session.getAttribute("session_counter") == null) {
            sCounter = new Counter();
        } else {
            sCounter = (Counter) session.getAttribute("session_counter");
        }

        Counter gCounter = (Counter)getServletContext().getAttribute("app_counter");

        sCounter.increment();
        gCounter.increment();

        session.setAttribute("session_counter", sCounter);

        session.setMaxInactiveInterval(5);

        out.println("session id: " + session.getId());
        out.println("session counter: " + sCounter.getValue());
        out.println("app counter: " + gCounter.getValue());
        out.println("expire time: " + session.getMaxInactiveInterval());
    }

    @Override
    public void init() throws ServletException {

        // application context
        getServletContext().setAttribute("app_counter", new Counter());
    }
}
