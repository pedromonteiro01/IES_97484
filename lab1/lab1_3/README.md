**Guião para o Lab1**

**Nome:** Pedro Miguel Afonso de Pina Monteiro <br>
**Nmec:** 97484 <br>
**email:** pmapm@ua.pt

**Exercício 1.3**

**Introdução ao *git***<br>
Lista de alguns dos comandos mais habituais com o *git*<br><br>
**Criar novo repositório**

	git init

**Verificar estado dos arquivos/diretórios**

	git status

**Adicionar um arquivo em específico**

	git add meu_arquivo.txt

 **Adicionar um diretório em específico**

	git add meu_diretorio

**Adicionar todos os arquivos/diretórios**
	
	git add .	
	
**Adicionar um arquivo que esta listado no .gitignore (geral ou do repositório)**
	
	git add -f arquivo_no_gitignore.txt
	
**Commit de um arquivo**
	
	git commit meu_arquivo.txt

**Commit de vários arquivos**

	git commit meu_arquivo.txt meu_outro_arquivo.txt
	
**Commit com mensagem**

	git commit meuarquivo.txt -m "minha mensagem de commit"

**Remover arquivo**

	git rm meu_arquivo.txt

**Remover diretório**

	git rm -r diretorio

**Exibir histórico**
	
	git log
	
**Exibir histórico com diff das duas últimas alterações**

	git log -p -2
	
**Exibir resumo do histórico (hash completa, autor, data, comentário e qtde de alterações (+/-))**

	git log --stat


**Exemplo ilustrativo**
```
cd project_folder # move to the root of the working folder to be imported
git init # initialize a local git repo in this folder
git remote add origin <REMOTE_URL> #must adapt the url for your repo
git add. # mark all existing changes in this root to be commited
git commit -m "Initial project setup for exercise 1_3" #create the
commit snapshot locally
git push -u origin main #uploads the local commit to the shared repo
```

**Adicionar ficheiro .gitignore** <br>
Este ficheiro é colocado na raíz do repositório e serve para ignorar todos os ficheiros que não são importantes, ou seja, ficheiros que não vão ser *commited*

Neste exercício foi simulada a existência de outro colaborador, para isso foi criada uma nova pasta com o nome 'location2', noutro diretório do computador.
```
|
`-- Desktop
    	   `--location2
	|-- IES
		|--IES_97484
		            `--location1
```

```
git clone git@github.com:pedromonteiro01/IES_97484.git
```
O comando acima foi usado para obter os ficheiros no novo local. <br>
Nesta nova localização foi criado, então, um logger, sendo as operações executadas escritas no terminal e num ficheiro, 'logs.log'. <br>
Foi usada a biblioteca auxiliar **Log4j2**

Links usados para criar os ficheiros: 
- https://www.baeldung.com/java-logging-intro
- https://howtodoinjava.com/log4j2/log4j2-xml-configuration-example/


Exemplo do ficheiro
```xml
<Configuration status="info">
    <Appenders>
        <Console name="sout" target="SYSTEM_OUT">
            <PatternLayout pattern="[%p] %d{HH:mm:ss} %m%n \n"/>
        </Console>
        <File name="file" fileName="logs.log" append="true">
            <PatternLayout pattern="[%p] %d{HH:mm:ss} %m%n \n">
            </PatternLayout>
        </File>
    </Appenders>
    <Loggers>
        <Root level="info">
            <AppenderRef ref="sout"/>
            <AppenderRef ref="file"/>
        </Root>
    </Loggers>
</Configuration>
```

Para dar commit a partir desta nova localização (simulando, então, a existência de mais do que um colaborador para o projeto) foram usados os comandos descritos no início.

Para que seja possível ver todas as mensagens enviadas em cada commit pode ser usado o comando seguinte
```
git log --reverse --oneline  
```
Serão listadas todas as mensagens, de todos os colaboradores do projeto.