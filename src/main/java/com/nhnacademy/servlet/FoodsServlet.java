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
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "foodServlet", urlPatterns = "/foods")
public class FoodsServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");
//        int count = (int) getServletContext().getAttribute("counter");
//        getServletContext().setAttribute("counter", ++count);

        int onionNum = Integer.parseInt(getServletContext().getInitParameter("양파"));
        int eggNum = Integer.parseInt(getServletContext().getInitParameter("계란"));
        int greenOnionNum = Integer.parseInt(getServletContext().getInitParameter("파"));
        int appleNum = Integer.parseInt(getServletContext().getInitParameter("사과"));

        getServletContext().setAttribute("양파", onionNum);
        getServletContext().setAttribute("계란", eggNum);
        getServletContext().setAttribute("파", greenOnionNum);
        getServletContext().setAttribute("사과", appleNum);

        PrintWriter out = resp.getWriter();
        out.println("양파(1000원): " + onionNum + "개" + "<br>");
        out.println("계란(2000원): " + eggNum + "판" + "<br>");
        out.println("파(500원): " + greenOnionNum + "개" + "<br>");
        out.println("사과(2000원): " + appleNum + "개" + "<br>");
        out.println("장바구니에 상품을 담아주세요." + "<br>");

        out.println("<!DOCTYPE html>" +
                        "<html lang=\"en\">" +
                        "<head>" +
                        "<meta charset=\"UTF-8\">" +
                        "<title>basket</title>" +
                        "</head>" +
                        "<body>" +
                            "<form method=\"post\" action=\"/cart\">" +
                            "<br>" +
                            "<input type=\"number\" name=\"onionNum\"/> 양파" +
                            "<br><br>" +
                            "<input type=\"number\" name=\"eggNum\"/> 계란" +
                            "<br><br>" +
                            "<input type=\"number\" name=\"greenOnionNum\"/> 파" +
                            "<br><br>" +
                            "<input type=\"number\" name=\"appleNum\"/> 사과" +
                            "<br><br>" +
                            "<input type=\"submit\">" +
                            "</form>" +
                            "</body>" +
                            "</html>");

//        resp.sendRedirect("/login");

//        HttpSession session = req.getSession(false);
//        if (Objects.isNull(session)) {
//            resp.sendRedirect("/loginForm.html");
//        } else {
//            out.println("Login Success");
//            out.println("User: " + session.getAttribute("id"));
//
//            out.println("<a href='/foods'>/foods</a>");
//            out.println("<a href='/logout'>/logout</a>");
//        }
    }
}
