# IES_97484

**Guião para o Lab1**

**Nome:** Pedro Miguel Afonso de Pina Monteiro <br>
**Nmec:** 97484 <br>
**email:** pmapm@ua.pt

Foi criado um repositório no github, que será usado para submeter os guiões práticos ao longo do semestre:
[https://github.com/pedromonteiro01/IES_97484](https://github.com/pedromonteiro01/IES_97484) <br>
Para uma melhor organização, será criado um ficheiro README.md para cada exercício que estará na pasta correspondente.

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

Criar um projeto Maven novo:
```
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```