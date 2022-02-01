package com.training.spring.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/servlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest reqParam,
                         final HttpServletResponse respParam) throws ServletException, IOException {
        respParam.getWriter()
                 .println("Hello world");
        respParam.addHeader("Content-Type",
                            "text/plain");

    }

}
