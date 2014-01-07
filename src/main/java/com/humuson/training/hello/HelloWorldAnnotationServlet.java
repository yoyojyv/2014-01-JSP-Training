package com.humuson.training.hello;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/helloAnnotation")
public class HelloWorldAnnotationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream os = resp.getOutputStream();

        for (int i=0;i<1000;i++) {
            os.print(i);
            os.write(", Hello, World2!!".getBytes("UTF-8"));

            if (i % 100 == 0) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                os.println();
                os.flush();
            }
        }
        os.println("***** end");
        os.close();
    }
}
