**Guião para o Lab1**

**Nome:** Pedro Miguel Afonso de Pina Monteiro <br>
**Nmec:** 97484 <br>
**email:** pmapm@ua.pt

**Exercício 1.5**

Foram criados 2 projetos maven para a resolução deste exercício. 
o projeto ipmaclient_api contém os dados da API, ou seja, contém os ficheiros responsáveis por obterem as temperaturas das cidades.
O projeto weatherforecastbycity contém uma main simples, disponível em [`main`](https://github.com/pedromonteiro01/IES_97484/blob/main/lab1/lab1_5/weatherforecastbycity/src/main/java/com/weatherforecast/App.java), onde é chamada a função criada no primeiro projeto, que recebe como parametro o argumento da linha de comandos (args[0]).

Para a resolução deste exercício foi necessária a comunicação entre 2 projetos mavens. Para isso os ficheiros pom.xml foram alterados, bem como também foram usados alguns comandos.

Alterações em ipmaclient_api/pom.xml (para além das dependências necessárias)
```xml
<plugin>
    <artifactId>maven-assembly-plugin</artifactId>
    <configuration>
        <archive>
            <manifest>
                <mainClass>fully.qualified.MainClass</mainClass>
            </manifest>
        </archive>
        <descriptorRefs>
            <descriptorRef>jar-with-dependencies</descriptorRef>
        </descriptorRefs>
    </configuration>
</plugin>
```

Alterações em weatherforecastbycity/pom.xml
```xml
    <dependency>
      <groupId>com.ipmaapiclient</groupId>
      <artifactId>ipmaclient_api</artifactId>
      <version>1.1</version>
   </dependency>

  <repositories>
    <repository>
        <id>my-local-repo</id>
        <url>file://${basedir}/lib</url>
    </repository>
  </repositories>
```

**Comandos utilizados**
Instalar projeto maven localmente
```
mvn clean install -U
```

Compilar uma dependência de cada vez
```
mvn compile assembly:single
```

Criar um jar com as dependências em ipmaclient_api
```
mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=/home/pedro/Desktop/IES/IES_97484/lab1/lab1_5/ipmaclient_api/target/ipmaclient_api-1.1-jar-with-dependencies.jar -DgroupId=com.ipmaapiclient   -DartifactId=ipmaclient_api -Dversion=1.1 -Dpackaging=jar -DlocalRepositoryPath=lib
```

Correr um programa (dentro do projeto weatherforecastbycity)
```
mvn exec:java -Dexec.mainClass="com.weatherforecastbycity.App" -Dexec.args="Aveiro"
```

## **Review questions**
A) <br>
-As principais fases de um projeto maven são:
    - validate: validate the project is correct and all necessary information is available
    - compile: compile the source code of the project
    - test: test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
    - package: take the compiled code and package it in its distributable format, such as a JAR
    - verify: run any checks on results of integration tests to ensure quality criteria are met
    - install: install the package into the local repository, for use as a dependency in other projects locally
    - deploy: done in the build environment, copies the final package to the remote repository for sharing with other developers and projects

B) <br>
Sim, o maven é uma *build automation tool* usada principalmente para projetos Java, sendo que pode ser usada com qualquer outro tipo de linguagem (C#, Ruby, etc). É uma ferramente que permite gerir projetos, que se baseia no POM (*Project Object Model*). Pode ser usado para gerir e para correr projetos, tornando todo o processo mais fácil. Podem ser facilmente usados diferentes plugins e diferentes dependências de acordo com o nosso projeto.

C) <br>
Começar por obter o código presente no repositório, isto é, fazer clone do repositório.
```
git clone <REPOSITORY_URL>
```
Entrar no diretório correto
```
cd project_folder
```
Adicionar os ficheiros alterados (será usado "." que significa todos os ficheiros)
```
git add .
```
Escrever a mensagem de commit
```
 git commit -m "This is a commit message!"
```
Enviar os ficheiros para o repositório
```
git push -u origin main
```

D) <br>
Na minha opinião as mensagens de *commit* são importantes em todos os trabalhos, especialmente nos trabalhos de equipa para garantir uma boa comunicação, ou seja, todos os membros estarem em sintonia, isto é,  saberem o que já foi feito, evitando pensar em algo que já foi implementado. Uma boa mensagem deve encaminhar para aquilo que é preciso ser feito.

Fonte: https://www.freecodecamp.org/news/writing-good-commit-messages-a-practical-guide/ <br>
Dicas/Regras para uma boa mensagem de *commit*:
1. Deve-se especificar o tipo de commit
    - feat: adicionar uma nova feature
    - fix: corrigir um erro
    - style: mudanças relacionadas com o estilo da aplicação
    - refactor: refazer uma secção específica da app
    - test: tudo relacionado com testes
    - docs: tudo relacionado com documentação
2. Separar o assunto do corpo da mensagem com uma linha em branco
3. A mensagem não deve conter erros relacionados com espaços em branco 
4. Remover marcas de pontuação desnecessárias
5. Não terminar a linha do assunto com um ponto final
6. Usar maiúscula na primeira letra do assunto e em cada parágrafo
7. Usar o modo imperativo
8. Usar o corpo da mensagem para explicar as mundanças e o porquê
9. Não assumir que quem revê o código sabe a priori qual o problema, deve-se adicionar
10. Não pensar que o código é auto-explicativo
11. Seguir a convenção usada pela equipa

E) <br>
É importante porque se usarmos sempre o mesmo *container* a  cada vez que é executado *docker stop/start* é necessário reiniciar. Caso se use *docker run* vai ser criado um novo *container* vazio, ou seja, vão ser perdidos dados. É então necessário criar volumes com espaço suficiente para *database production* e garantir que há uma boa estratégia de backup, evitando assim que haja dados que são perdidos. 