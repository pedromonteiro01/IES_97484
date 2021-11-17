**Guião para o Lab3**

**Nome:** Pedro Miguel Afonso de Pina Monteiro <br>
**Nmec:** 97484 <br>
**email:** pmapm@ua.pt

**Exercício 3.2**<br>
**Multilayer applications: exposingdata with RESTinterface**<br>
Para a realização deste exercício é necessária uma instância do MySQL server, e para isso foi usado docker.
Pode-se criar usando o comando:
```
docker run --name mysql5 -e MYSQL_ROOT_PASSWORD=secret1-e MYSQL_DATABASE=demo-e MYSQL_USER=demo-e MYSQL_PASSWORD=secret2-p 33060:3306-d mysql/mysql-server:5.7
```
Pode ser também usado docker-compose (que foi a escolha):
```yml
version: '3.1'

services:
  db:
    image: mysql
    command: --default-authentication-plugin=mysql_native_password
    restart: always
    environment:
        MYSQL_ROOT_PASSWORD: secret1
        MYSQL_DATABASE: demo
        MYSQL_USER: demo
        MYSQL_PASSWORD: secret2
    ports:
        - "9906:3306"

  phpmyadmin:
    image: phpmyadmin/phpmyadmin
    ports:
        - '8081:80'
    restart: always
    environment:
        PMA_HOST: db
    depends_on:
        - db
```
De notar que no docker-compose foi instanciado o MySQL server e também o phpMyAdmin, este apenas para uma visualização melhor e mais fácil da base de dados.

De seguida foi criado um projeto *Maven*, seguindo o tutorial disponível em https://www.javaguides.net/2018/09/spring-boot-2-jpa-mysql-crud-example.html.

Foram criados, então, os seguintes ficheiros:
- pom.xml
    - Com as seguintes dependências:
    - Spring Web
    - Spring Data JPA
    - MySQL driver
    - DevTools
    - Validation

- Employee.java (model folder)
- EmployeeRepository.java (repository folder)
- EmployeeController.java (controller folder)
- ErrorDetails.java (exception folder)
- GlobalExceptionHandler.java (exception folder)
- ResourceNotFoundException.java (exception folder)

Para ser possível correr a aplicação e a base de dados é necessário adicionar as propriedades de conexão no ficheiro application.properties, disponível dentro da pasta resources.
```
# MySQLspring.datasource.url=jdbc:mysql://127.0.0.1:33060/demo
spring.datasource.username=demo
spring.datasource.password=secret2
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect

# Strategy to auto updatethe schemas  (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update
```

Para testar a aplicação foram realizados pedidos POST utilizando o *Postman*, com o seguinte formato:
```
{
    "firstName":"Pedro",
    "lastName":"Monteiro",
    "emailId":"pmapm@ua.pt"
}
```
Após a execução deste pedido é possível verificar no browser que foi adicionado um novo *employee*, http://localhost:8080/api/v1/employees.

Foi adicionado também um novo método para efetuar a pesquisa de um *employee* por email, sendo este método extendido de *CRUDRepository*.
```java
public Employee findByEmailId(@Param("emailId") String emailId);
```
Para uma filtragem por *employee* foi criado um novo url no controller, através da anotação @GetMapping:
```java
@GetMapping("/employees?email={email}")
public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable(value = "email") String employeeEmail)
        throws ResourceNotFoundException {
    Employee employee = employeeRepository.findByEmailId(employeeEmail);
    return ResponseEntity.ok().body(employee);
}
```