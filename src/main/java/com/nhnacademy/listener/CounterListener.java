package com.nhnacademy.listener;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
public class CounterListener implements ServletContextListener {
    @SneakyThrows
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

//        String files;
//        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\shkcr\\GitHub\\nhnfoodmart\\nhnfoodmart\\src\\main\\resources\\" + ctx.getInitParameter("counter"))));
//        files = br.readLine();
//        int count = Integer.parseInt(files);

        String counterFileName =
            "C:\\Users\\shkcr\\GitHub\\nhnfoodmart\\nhnfoodmart\\src\\main\\resources\\" + servletContext.getInitParameter("counterFileName");

        String counter; //= null;
        BufferedReader br = new BufferedReader(new FileReader(new File(counterFileName)));
        counter = br.readLine();

        int count = Integer.parseInt(Optional.ofNullable(counter).orElse(String.valueOf(0)));

        servletContext.setAttribute("counter", count);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        int counter = (int) servletContext.getAttribute("counter");

        String counterFileName =
            "C:\\Users\\shkcr\\GitHub\\nhnfoodmart\\nhnfoodmart\\src\\main\\resources\\" + servletContext.getInitParameter("counterFileName");

        try (FileOutputStream fos = new FileOutputStream(
            new File(servletContext.getResource(counterFileName).toURI()));
             DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeInt(counter);
        } catch (URISyntaxException | IOException ex) {
            log.error("", ex);
        }
    }

}