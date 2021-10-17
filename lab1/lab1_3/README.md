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