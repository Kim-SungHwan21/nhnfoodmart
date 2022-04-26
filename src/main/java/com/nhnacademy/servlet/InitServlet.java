package com.nhnacademy.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        Food 양파 = new Food(config.getServletContext().getInitParameter("양파"));
        Food 계란 = new Food(config.getServletContext().getInitParameter("계란"));
        Food 파 =  new Food(config.getServletContext().getInitParameter("파"));
        Food 사과 = new Food(config.getServletContext().getInitParameter("사과"));
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.sendRedirect("/foods");
    }
}