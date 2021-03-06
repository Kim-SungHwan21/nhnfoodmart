package com.nhnacademy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "cartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/plain");
//        resp.setCharacterEncoding("UTF-8");

        String onion = req.getParameter("onionNum");
        String egg = req.getParameter("eggNum");
        String greenOnion = req.getParameter("greenOnionNum");
        String apple = req.getParameter("appleNum");

        int onionNum = onion.isEmpty() ? 0 : Integer.parseInt(onion);
        int eggNum = egg.isEmpty() ? 0 : Integer.parseInt(egg);
        int greenOnionNum = greenOnion.isEmpty() ? 0 : Integer.parseInt(greenOnion);
        int appleNum = apple.isEmpty() ? 0 : Integer.parseInt(apple);

        if ((onionNum > 2 && onionNum < 0) || (eggNum > 5 && eggNum < 0 ) || (greenOnionNum > 10 && greenOnionNum < 0) || (appleNum > 20 && appleNum < 0)) {
            resp.setStatus(417);
            return;
        }

        PrintWriter out = resp.getWriter();
        out.println("양파: " + onionNum + "개, "
            + (onionNum * 1000) + "원");
        out.println("계란: " + eggNum + "판, "
            + (eggNum * 2000) + "원");
        out.println("파: " + greenOnionNum + "개, "
            + (greenOnionNum * 500) + "원");
        out.println("사과: " + appleNum + "개, "
            + (appleNum * 2000) + "원");

        int result = (onionNum * 1000) + (eggNum * 2000) + (greenOnionNum * 500) + (appleNum * 2000);

        out.println("합계: " + result + "원");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

//        int count = (int) getServletContext().getAttribute("counter");
//        getServletContext().setAttribute("counter", ++count);
//        HttpSession session = req.getSession(false);
//        if (Objects.isNull(session)) {
//            resp.sendRedirect("/loginForm.html");
//        } else {
//            PrintWriter out = resp.getWriter();
//            out.println("Login Success");
//            out.println("User: " + session.getAttribute("id"));
//
//            out.println("<a href='/foods'>/foods</a>");
//            out.println("<a href='/logout'>/logout</a>");
//        }
    }
}
