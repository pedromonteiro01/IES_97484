package com.ies.ex1;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "MyFirstServlet", urlPatterns = {"/MyFirstServlet"})
public class MyFirstServlet extends HttpServlet {
 
    private static final long serialVersionUID = -1915463532411657451L;
 
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
        //Do some work
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Request Parameters Example</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Request Parameters Example</h3>");

            String firstName = HTMLFilter.filter(request.getParameter("firstname"));
            String lastName = HTMLFilter.filter(request.getParameter("lastname"));

            /*if (firstName != null || lastName != null) {
                out.println("First Name:");
                out.println(" = " + HTMLFilter.filter(firstName) + "<br>");
                out.println("Last Name:");
                out.println(" = " + HTMLFilter.filter(lastName));
            } else {
                out.println("No Parameters, Please enter some");
            }*/
            out.println("<P>");
            out.print("<form action=\"");
            out.print("MyFirstServlet\" ");
            out.println("method=GET>");
            out.println("First Name:");
            out.println("<input type=text size=20 name=firstname>");
            out.println("<br>");
            out.println("Last Name:");
            out.println("<input type=text size=20 name=lastname>");
            out.println("<br>");
            out.println("<br>");

            if (firstName != null && lastName != null)
                out.println("Welcome " + firstName + " " + lastName +"!");

            out.println("<br>");
            out.println("<input type=submit>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }

        catch (NullPointerException e){
            System.err.println(e);
            System.exit(-1);
        }
        finally {
            out.close();
        }
    }
     
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        //Do some other work
    }
}