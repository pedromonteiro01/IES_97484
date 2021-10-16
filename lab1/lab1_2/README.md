**Guião para o Lab1**

**Nome:** Pedro Miguel Afonso de Pina Monteiro <br>
**Nmec:** 97484 <br>
**email:** pmapm@ua.pt

**Exercício 1.2**

Um ciclo de vida de construção é composto por fases.
Cada um desses ciclos de vida de construção é definido por uma lista diferente de fases de construção, em que uma fase de construção representa um estágio do ciclo de vida.

| Fase | Descrição | 
| :---: | :--- | 
| validate | validate the project is correct and all necessary information is available | 
| compile | compile the source code of the project |
| test | test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed |
| package | take the compiled code and package it in its distributable format, such as a JAR | 
| verify | run any checks on results of integration tests to ensure quality criteria are met |
| install | install the package into the local repository, for use as a dependency in other projects locally |
| deploy | done in the build environment, copies the final package to the remote repository for sharing with other developers and projects |
<br>

**Usual Command Line Commands**
```
mvn verify
```
Este comando executa cada fase do ciclo de vida (*validate*, *compile*, *package*, etc) antes de ser executado *verify*. É apenas necessário chamar a última fase a ser executada, neste caso *verify*.

Num ambiente de construção pode-se o usar o seguinte comando para construir e implementar de forma limpa *artifacts* no repositório. <br>
O mesmo comando pode ser executado num ambiente com vários módulos, pois o *clean* executa por todos os sub-projetos.
```
mvn clean deploy
```

A fase de construção tem vários *Plugin Goals*
Uma fase de construção é responsável por uma etapa específica no ciclo de vida da construção, a maneira pela qual realiza essas responsabilidades pode variar. E isso é feito declarando os *Plugin Goals* associados a essas fases de construção.

O que é um *plugin goal*?
- Representa uma tarefa específica que contribui para a construção e administração de um projeto. Pode ser atribuído a 0 ou mais fases de construção.
Por exemplo:
```
mvn clean dependency:copy-dependencies package
```
Neste caso, a fase de *clean* seria executada em primeiro (sendo todas as fases anteriores a si executadas), e só depois *dependency:copy-dependencies*. No final seria executada a fase *package*.

Uma fase de construção pode ter 0 ou mais *goals*, sendo que se não tiver nenhum, essa fase não vai ser executada, mas se tiver 1 ou mais vão ser todos executados.

Certas fases não são normalmente chamadas através da linha de comandos, sendo exemplo disso todas aquelas precedidas por *pre-*\*, *post-*\* ou *process\**.

**Plugins**
Uma outra maneira de adicionar *goals* às fases de construção é adicionar *plugins* ao projeto.<br>
Plugins are artifacts that provide goals to Maven. <br>
Um *plugin* pode ter um ou mais *goals* em que cada *goal* representa a capacidade desse *plugin*.

Exemplo de um *Plugin*:
```xml
...
 <plugin>
   <groupId>org.codehaus.modello</groupId>
   <artifactId>modello-maven-plugin</artifactId>
   <version>1.8.1</version>
   <executions>
     <execution>
       <configuration>
         <models>
           <model>src/main/mdo/maven.mdo</model>
         </models>
         <version>4.0.0</version>
       </configuration>
       <goals>
         <goal>java</goal>
       </goals>
     </execution>
   </executions>
 </plugin>
...
```

Lifecycle references: https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html#lifecycle-reference

**Maven in 5 minutes**
```
mvn --version
```
Ver a versão Maven instalada

Criar um projeto
```
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

É criado um diretório com o mesmo nome do *artifactId*
```
cd my-app
```

Estrutura do Projeto
```
my-app
|-- pom.xml
`-- src
    |-- main
    |   `-- java
    |       `-- com
    |           `-- mycompany
    |               `-- app
    |                   `-- App.java
    `-- test
        `-- java
            `-- com
                `-- mycompany
                    `-- app
                        `-- AppTest.java
```

**The POM**<br>
O ficheiro **pom.xml** é o ficheiro principal de configuração de um projeto Maven. É neste ficheiro que está a maior parte da informação necessária para a criação de um projeto.

Um exemplo de um ficheiro pom.xml: [`my-app/pom.xml`](https://github.com/pedromonteiro01/IES_97484/blob/main/lab1/lab1_2/my-app/pom.xml)

**Build the Project**
Ao correr o comando,
```
mvn package
```
No final será apresentado:
```
 ...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.953 s
[INFO] Finished at: 2019-11-24T13:05:10+01:00
[INFO] ------------------------------------------------------------------------
```
Ao contrário do primeiro comando (*archetype:generate*), este é apenas uma palavra, *package*. Para além de ser um *goal*, é também um fase, pelo que também serão executadas todas as fases anteriores.

**Run and Test**
```
java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App
```

**Projetos Maven**<br>
*archetype:*  um padrão ou modelo original do qual todas as outras coisas do mesmo tipo são feitas. Modelo genérico de uma componente no sistema. <br>
*groupId:* identifica de forma única o projeto entre todos os projetos. Deve seguir as normas de nomes para os pacotes utilizadas em java, o que significa que começa por um *domain name* invertido que é controlado pelo utilizador. Por exemplo, com.mycompany.app, org.apache.maven, etc.<br>
*artifactId:* nome do jar sem versão<br>

Foi criado um projeto Maven com o nome *my-app*
- groupId: com.mycompany.app
- artifactId: my-app
- version: 1.0-SNAPSHOT

Disponível em [`my-app`](https://github.com/pedromonteiro01/IES_97484/blob/main/lab1/lab1_2/my-app) 