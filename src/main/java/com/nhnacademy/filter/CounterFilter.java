package com.nhnacademy.filter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter(filterName = "counterFilter", urlPatterns = {"/foods", "/cart"})
public class CounterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

//        String files;
//        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\\\Users\\\\shkcr\\\\GitHub\\\\nhnfoodmart\\\\nhnfoodmart\\\\src\\\\main\\\\resources\\\\counter.dat")));
//        files = br.readLine();

        int count =
            (int) servletRequest.getServletContext().getAttribute("counter");
        filterChain.doFilter(servletRequest, servletResponse);
        servletRequest.getServletContext().setAttribute("counter", ++count);
        log.error(String.valueOf(count));
    }
}
