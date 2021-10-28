package com.ies.ex1;
 
import com.ies.ex1.MyFirstServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class JettyEx {
    public static void main(String[] args) throws Exception {
         
        Server server = new Server(8680);       
         
        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);
                 
        servletHandler.addServletWithMapping(MyFirstServlet.class, "/");
         
        server.start();
        server.join();
 
    }
}