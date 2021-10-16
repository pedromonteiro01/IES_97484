# IES_97484

**Guião para o Lab1**

**Nome:** Pedro Miguel Afonso de Pina Monteiro <br>
**Nmec:** 97484 <br>
**email:** pmapm@ua.pt

**Notas** <br>
O que é o Maven?
- O Maven é um gestor de dependências que permite criar projetos com alguma facilidade, baseado no conceito de *Project object model* (POM).
- Usa, então, um ficheiro XML (POM) para descrever o projeto de software, sendo construído as suas dependências sobre módulos e componentes externas, a ordem de compilação, diretórios e plug-ins necessários.
- Baixa bibliotecas Java e seus plug-ins dinamicamente de um ou mais repositórios.
- Ferramentas similares ao Maven:
    - ant
    - gradle
    - kotlin

| Nome do diretório | Propósito | 
| :---: | :---: | 
| Project Home | Contém o pom.xml e todos os subdiretórios. | 
| src/main/java | Contém o código-fonte Java entregável para o projeto. |
| src/test/java | Contém as classes de teste para o projeto. |

*archetype:*  um padrão ou modelo original do qual todas as outras coisas do mesmo tipo são feitas. Modelo genérico de uma componente no sistema. <br>
*groupId:* identifica de forma única o projeto entre todos os projetos. Deve seguir as normas de nomes para os pacotes utilizadas em java, o que significa que começa por um *domain name* invertido que é controlado pelo utilizador. Por exemplo, com.mycompany.app, org.apache.maven, etc.<br>
*artifactId:* nome do jar sem versão<br>


Criar um projeto Maven novo:
```
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```