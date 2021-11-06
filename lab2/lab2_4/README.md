**Guião para o Lab2**

**Nome:** Pedro Miguel Afonso de Pina Monteiro <br>
**Nmec:** 97484 <br>
**email:** pmapm@ua.pt

**Exercício 2.4**<br>
**Creating a Web Service (REST API)**<br>

*Java Enterprise* permite criar aplicações complexas e robustas para diferences cenários.<br>

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

C) <br>

D) <br>
- @EnableAutoConfiguration
    - enables Spring Boot to auto-configure the application context. Therefore, it automatically creates and registers beans based on both the included jar files in the classpath and the beans defined by us.
- @ComponentScan
    - tell Spring the packages to scan for annotated components. @ComponentScan also used to specify base packages and base package classes using thebasePackageClasses or basePackages attributes of @ComponentScan.
- @Configuration
    -  indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime

E) <br>