**Guião para o Lab2**

**Nome:** Pedro Miguel Afonso de Pina Monteiro <br>
**Nmec:** 97484 <br>
**email:** pmapm@ua.pt

**Exercício 2.4**<br>
**Creating a Web Service (REST API)**<br>

*Java Enterprise* permite criar aplicações complexas e robustas para diferences cenários.<br>
Neste exercício foi criada uma REST API que oferece *quotes* aleatórias de filmes.
| Method | Path | Description |
| :---: | :---: | :---: |
| GET | api/quote | Returns a random quote from a random show/film.
| GET | api/shows | List of all available shows (for which some quote exists).For convenience, a show should have some identifier/code.
| GET | api/quotes?show=<show_id> | Returns a random quote for the specified show/film.

## **Review Questions**
A) <br>
Um servlet container é um componente importante de um servidor web que permite gerar páginas web dinâmicas. É responsável por:
- gerir o ciclo de vida de servlets
- carregar os servlets para memória
- mapear uma URL para um servlet particular
- garantir que quem pede o URL possui os direitos de acesso corretos
- inicializar e invocar métodos dos servlets
- terminar (destruir) os servlets 

B) <br>
Model-View-Controller (MVC) é um padrão de desenho de software usado habitualmente para desenvolver interfaces que dividem a lógica do programa em 3 elementos interconectados. <br>
- Model
    - preocupa-se com o armazenamento, manipulação e geração de dados
    
- View
    - os dados solicitados ao Model são apresentados aqui
    - não se dedica a saber de onde vieram os dados, apenas os apresenta

- Controller
    - componente final que faz o intermédio entre entrada e saída, comanda a View e o Model para serem alterados de forma apropriada conforme o pedido do utilizador
    - o foco central são as ações do utilizador
<br> 

O Controller envia comandos para o Model para atualizar o seu estado (pode também enviar comandos para a view)<br>
O Model armazena dados e notifica as Views e Controllers associados quando há uma mudança de estado. Estas notificações permitem que as Views produzam saídas atualizadas<br>
A View gera uma representação dos dados presentes no Model solicitado, fazendo a exibição dos dados<br>

MVC com o Spring Boot:<br>
The Spring Web MVC framework is designed around a DispatcherServlet that dispatches requests to handlers, with configurable handler mappings and view resolution. The default handler is based on the @Controller and @RequestMapping annotations, offering a wide range of flexible handling methods. <br>
C) <br>
O papel destas *starter dependencies* consiste em reduzir o tempo que se passa a configurar e a gerir todas as diferentes dependências, sendo, então, possível agrupar várias dependências num só nome. <br>
Ex.: org.springframework.boot:spring-boot-starter-data-jpa <br>

D) <br>
- @EnableAutoConfiguration
    - enables Spring Boot to auto-configure the application context. Therefore, it automatically creates and registers beans based on both the included jar files in the classpath and the beans defined by us.
- @ComponentScan
    - tell Spring the packages to scan for annotated components. @ComponentScan also used to specify base packages and base package classes using thebasePackageClasses or basePackages attributes of @ComponentScan.
- @Configuration
    -  indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime

E) <br>
What is a REST API?<br>
A REST API is an application programming interface that conforms to specific architectural constraints, like stateless communication and cacheable data. It is not a protocol or standard. <br>

- Some of Best practices:
    - Accept and respond with JSON: SON is the standard for transferring data. Almost every networked technology can use it. Server-side technologies have libraries that can decode JSON without doing much work.
    - Handle errors gracefully and return standard error codes: To eliminate confusion for API users when an error occurs, we should handle errors gracefully and return HTTP response codes that indicate what kind of error occurred. <br>Ex.: 400 Bad Request – This means that client-side input fails validation.
    - Allow filtering, sorting, and pagination: The databases behind a REST API can get very large. Filtering and pagination both increase performance by reducing the usage of server resources. As more data accumulates in the database, the more important these features become.
    - Maintain good security practices: Most communication between client and server should be private since we often send and receive private information. A SSL certificate isn’t too difficult to load onto a server and the cost is free or very low. 
    - Cache data to improve performance: We can add caching to return data from the local memory cache instead of querying the database to get the data every time we want to retrieve some data that users request. The good thing about caching is that users can get data faster.