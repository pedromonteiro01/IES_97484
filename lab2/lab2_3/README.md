**Guião para o Lab2**

**Nome:** Pedro Miguel Afonso de Pina Monteiro <br>
**Nmec:** 97484 <br>
**email:** pmapm@ua.pt

**Exercício 2.3**<br>
**Introduction to web apps with a full-featured framework (Spring Boot)**<br>

Sprint Boot - Getting Started: https://spring.io/projects/spring-boot

#### O que é o **Spring Boot**?
- É uma plataforma de desenvolvimento rápido de aplicações construída sobre a popular ***Spring Framework***.
- Torna mais fácil criar aplicações autónomas baseadas em *Spring* que é apenas necessário correr.
- Não é necessário descarregar ficheiros **.War**.
- Não é necessário gerar código nem requer uma configuração XML

Foi usado o *[`Spring Initializr`](https://start.spring.io/)* para criar um projeto para uma aplicação *web*, sendo adicionada a dependência *Spring Web*.
O *Spring Initializr* possui templates que contém uma coleção de todas as dependências relevantes que são necessárias para começar uma funcionalidade e que irá simplificar toda a configuração do *POM*.

Após o download é possível criar a aplicação usando os comandos:
```
./mvnw clean install
./mvnw spring-boot:run
```

No browser é possível ver uma página de erro produzida pelo Spring Boot, em http://localhost:8080/ <br>
**NOTA:**  ter em atenção se as portas não estão já a ser usadas!<br>
Para alterar a porta em uso, no ficheiro **application.properties** deve ser adicionado:
```
server.port=9000
```

Em *Spring* os pedidos HTTP são tratados por um **controller**. <br>
O controller é identificado através da anotação **@Controller**. <br>

```java
@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

}
```
No exemplo acima **GreetingController** trata dos pedidos GET para **/greeting** devolvendo o nome de uma **View**, neste caso Greeting. <br>
Uma View é responsável por renderizar o conteúdo HTML. <br>
A anotação **@GetMapping** assegura que o pedido GET para /greeting é mapeado para o método greeting(). <br>
**@RequestParam** atribui o valor da *string* **name** para o parametro **name** do método greeting(). <br>
O valor do parametro name é adicionado ao objeto **Model**. <br>
Neste exemplo foi usado o *Thymeleaf*, que é uma *view technology*, para se conseguir obter a renderização do HTML. <br>
*Thymeleaf* analisa o template *greeting.html* e avalia a expressão **th:text** para renderizar o valor do parametro **${name}** que foi definido no controller.

```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head> 
    <title>Getting Started: Serving Web Content</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <p th:text="'Hello, ' + ${name} + '!'" />
</body>
</html>
```
**Note:** The implementation of Spring MVC relies on the Servlets engine, however, you do notneed to “see”them. The abstraction layers available will provide the developer with more convenient, higher-level interfaces. 

No fim foi extendido o projeto para criar um **REST endpoint** que ouve pedidos HTTP e responde com um resultado **JSON**. <br>

Building a RESTFul Web Service: https://spring.io/guides/gs/rest-service/

Em vez de um @Controller, agora foi usado um **@RestController**
```java
@RestController
public class GreetingControllerJson {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/ex3-json")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
```