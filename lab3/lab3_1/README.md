**Guião para o Lab3**

**Nome:** Pedro Miguel Afonso de Pina Monteiro <br>
**Nmec:** 97484 <br>
**email:** pmapm@ua.pt

**Exercício 3.1**<br>
**Accessing databases in SpringBoot**<br>

### O que é o Java Persistence API (JPA)?
Introdução à JPA: https://www.infoworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html
- JPA não é uma ferramenta ou *framework*. Em vez disso, define um conjunto de conceitos que podem ser implementados por qualquer ferramenta ou *framework*.
- JPA foi originalmente planeado para o uso de base de dados relacionais, sendo que atualmente algumas implementações de JPA foram estendidas para o uso de base de dados NoSQL.

### Criar uma aplicação Spring Boot CRUD utilizando o Thymeleaf

Foi seguido o tutorial disponível em: https://www.baeldung.com/spring-boot-crud-thymeleaf

É necessário definir as dependências certas no ficheiro pom.xml
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.4.0</version>
</parent>
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
    </dependency>
</dependencies>
```
- Camada de Domínio:
    - Foi criada a classe User: por simplicidade esta camada tem apenas uma classe responsável por modelar as entidades User
    ```java
    @Entity
    public class User {
    
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        
        @NotBlank(message = "Name is mandatory")
        private String name;
        
        @NotBlank(message = "Email is mandatory")
        private String email;

        // standard constructors / setters / getters / toString
    }
    ```
- Camada de Repositório:
    - O *Spring Data JPA* permite criar repositórios *JPA-based*. Esta camada de abstração permite acesso à camada de persistência sem ser necessário desenvolver implementações do zero.Para ser possível utilizar as funcionalidades CRUD nos objetos User, tudo o que é preciso é extender a interface *CrudRepository*
    ```java
    @Repository
    public interface UserRepository extends CrudRepository<User, Long> {}
    ```

- Camada de Controlo
    - A classe de controlo vai satisfazer pedidos HTTP Get e POST e mapeá-los para uma chamada ao *UserRepository*. Esta classe tem como base o modelo Spring MVC. O método *showSignUpForm()* vai mostrar um formulário de signup, enquanto que o método *addUser()* adiciona um novo utilizador à base de dados após a validação.

    ```java
    @Controller
    public class UserController {
        
        @GetMapping("/signup")
        public String showSignUpForm(User user) {
            return "add-user";
        }
        
        @PostMapping("/adduser")
        public String addUser(@Valid User user, BindingResult result, Model model) {
            if (result.hasErrors()) {
                return "add-user";
            }
            
            userRepository.save(user);
            return "redirect:/index";
        }

        @GetMapping("/index")
        public String showUserList(Model model) {
            model.addAttribute("users", userRepository.findAll());
            return "index";
        }

        @GetMapping("/edit/{id}")
        public String showUpdateForm(@PathVariable("id") long id, Model model) {
            User user = userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
            
            model.addAttribute("user", user);
            return "update-user";
        }

        // additional CRUD methods
    }
    ```
- Camada de Visão 
    - Na pasta *src/main/resources/templates* é necessário criar templates HTML para ser possível mostrar os fomulários e renderizar a lista das entidades *User*. Foii usado Thymeleaf como mecanismo de template para analisar os ficheiros.
    ```html
    <form action="#" th:action="@{/adduser}" th:object="${user}" method="post">
        <label for="name">Name</label>
        <input type="text" th:field="*{name}" id="name" placeholder="Name">
        <span th:if="${#fields.hasErrors('name')}" th:errors="*{name}"></span>
        <label for="email">Email</label>
        <input type="text" th:field="*{email}" id="email" placeholder="Email">
        <span th:if="${#fields.hasErrors('email')}" th:errors="*{email}"></span>
        <input type="submit" value="Add User">   
    </form>
    ```

- Correr a Aplicação
    ```java
    @SpringBootApplication
    public class Application {

        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }
    }
    ```

Foi criado um projeto *Maven* utilizando o [spring inititializr](https://start.spring.io/) onde foram adicionadas as seguintes dependências:
-  Spring Web
- Thymeleaf
- Spring Data JPA
- H2 database
- Validation

### Questions
- The “UserController” class gets an instance of “userRepository” through its constructor; how is this new repository instantiated?
    - O novo repositório é instanciado automaticamente pelo *SpringBoot Bean Autoconfiguration* após a anotação *Autowired* tentar obter o *Bean* para o *UserRepository*  
    ```java
    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    ```
- List the methods invoked in the “userRepository” object by the “UserController”. Where are these methods defined?
    - A anotação *@Repository* é a interface importante em todo este processo, sendo que é esta que fornece uma camada de abstração. A interface *CRUDRepository* é quem fornece as funcionalidades CRUD. Esta interface implementa, então, as operações CRUD básicas como save, delete, count, findAll, ...
    ```java
    public interface UserRepository extends CrudRepository<User, Long> {}
    ```
- Where is the databeing saved?
    - Os dados estão a ser guardados em memória, sendo que após a aplicação ser terminada os dados vão ser perdidos.
- Where is the rule for the "not empty" email address defined?
    - Através da anotação *@NotBlank* importada de javax.validation.constraints
    ```java
    import javax.validation.constraints.NotBlank;

    (...)

    @NotBlank(message = "Email is mandatory")
    private String email;
    ```

Organização das pastas e ficheiros:
```
+- com
    +- example     
        +- myapplication
            +- MyApplication.java
            |
            +- controllers
            |   +- Controller.java
            |
            +- entities
            |   +- User.java
            |
            +- repositories
                +- UserRepository.java
        +- resources
            +- static
            |
            +- templates
                +- index.html
            |
            application.properties
```