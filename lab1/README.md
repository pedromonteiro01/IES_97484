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

O que faz o Maven?
- Constrói facilmente um projeto
- É possível adicionar *jars* e outras dependências facilmente com a ajuda do maven
- Fornece informação acerca do rpojeto (logs, documentação, lista de dependências)
- Usando Maven pode-se facilmente integrar o projeto com um *source control system*, por exemplo, o *git*.

| Nome do diretório | Propósito | 
| :---: | :---: | 
| Project Home | Contém o pom.xml e todos os subdiretórios. | 
| src/main/java | Contém o código-fonte Java entregável para o projeto. |
| src/test/java | Contém as classes de teste para o projeto. |

Criar um projeto Maven novo:
```
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```