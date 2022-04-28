package com.nhnacademy.initializer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import lombok.SneakyThrows;

@HandlesTypes({
    javax.servlet.http.HttpServlet.class,
    javax.servlet.Filter.class,
    javax.servlet.ServletContextListener.class,
    javax.servlet.http.HttpSessionListener.class
})
public class WebAppInitializer implements ServletContainerInitializer {
    @SneakyThrows
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        ctx.setInitParameter("양파", "2");
        ctx.setInitParameter("계란", "5");
        ctx.setInitParameter("파", "10");
        ctx.setInitParameter("사과", "20");
        ctx.setInitParameter("counterFileName", "counter.dat");
        ctx.setInitParameter("counter", "0");
//        String files;
//        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\shkcr\\GitHub\\nhnfoodmart\\nhnfoodmart\\src\\main\\resources\\" + ctx.getInitParameter("counter"))));
//        files = br.readLine();
//        int count = Integer.parseInt(files);
//        ctx.setInitParameter("counter", String.valueOf(count));
        //ctx.setAttribute("counter", count);

    }
}