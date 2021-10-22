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