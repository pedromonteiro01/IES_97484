**Guião para o Lab2**

**Nome:** Pedro Miguel Afonso de Pina Monteiro <br>
**Nmec:** 97484 <br>
**email:** pmapm@ua.pt

**Exercício 2.2**<br>
**Server-side programming with embedded servers**<br>

Neste exercício foi usado um *embedded server* usando o *Jetty Server*.
<br>
Foi seguido o exemplo disponível em https://examples.javacodegeeks.com/enterprise-java/jetty/embedded-jetty-server-example/

```xml
<dependencies>          
            <dependency>
                <groupId>org.eclipse.jetty</groupId>
                <artifactId>jetty-server</artifactId>
                <version>9.2.15.v20160210</version>
            </dependency>
            <dependency>
                <groupId>org.eclipse.jetty</groupId>
                <artifactId>jetty-servlet</artifactId>
                <version>9.2.15.v20160210</version>
            </dependency>
    </dependencies>
```

```java
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
```
