**Guião para o Lab1**

**Nome:** Pedro Miguel Afonso de Pina Monteiro <br>
**Nmec:** 97484 <br>
**email:** pmapm@ua.pt

**Exercício 1.4**

**Introdução ao Docker**
### O que é o docker?
https://www.docker.com/ <br>
Conjunto de serviços que usam virtualização de nível de sistema operacional para entregar software em pacotes chamados *containers*. Os *containers* são isolados uns dos outros e agrupam os seus próprios softwares, bibliotecas e arquivos de configuração.

### O que são imagens? (docker images)
Pode-se entender as imagens como sendo um template (uma classe OOP) que permite iniciar um *container*. Cada imagem é definida por um Dockerfile, um arquivo de configuração que contém todos os comandos que um utilizador precisa executar para modelar a imagem.

Começar por instalar o docker engine, disponível em https://docs.docker.com/engine/install/.
Após a instalação, para uma melhor interação pode-se executar o docker sem ser necessário usar permissões, isto é, sem *sudo* - https://docs.docker.com/engine/install/linux-postinstall/.

Tutorial e Getting Started: https://docs.docker.com/get-started/
Foi seguido o tutorial e os ficheiros encontram-se neste diretório.

Foi instalada também a *Portainer app*, disponível em https://www.portainer.io/, que é uma *web application* e facilita o controlo dos *containers*.

**Alguns comandos docker:**<br>
Ver os *containers* que estão a correr no momento
```
docker ps
```

Criar e começar um *container*
```
docker run
```

Remover um *container*
```
docker rm
```

Ver a lista de imagens
```
docker images
```

Criar uma nova imagem a partir do *dockerfile*
```
docker build
```

Fazer *download* de uma imagem de um repositório
```
docker pull
```

Foi seguida a alternativa proposta no guião. Para isso foi criado um dockerfile, e 2 ficheiros que contém instruções SQL, visto que neste exemplo se correu o postgres
```
docker run --name pg-docker -e POSTGRES_PASSWORD=docker -e POSTGRES_DB=sampledb
-e PGDATA=/tmp -d -p 5433:5432 -v ${PWD}:/var/lib/postgresql/data postgres:11
```

No final do exercício foi seguido o tutorial de *docker compose*, disponível em 
https://docs.docker.com/compose/gettingstarted/ <br>
Este tutorial usa a framework *Flask* e a base de dados NoSQL *Redis* <br>
Está disponível em [`composetest`](https://github.com/pedromonteiro01/IES_97484/blob/main/lab1/lab1_4/composetest)

### O que é o docker compose?
É uma ferramenta que permite definir e correr *multi-container Docker applications*. É usado um ficheiro YAML para configurar os serviços. Depois, com um simples comando é possível criar e começar todos os serviços.

Usar o *docker compose* consiste em 3 processos:
1. Define your app’s environment with a Dockerfile so it can be reproduced anywhere.

2. Define the services that make up your app in docker-compose.yml so they can be run together in an isolated environment.

3. Run docker compose up and the Docker compose command starts and runs your entire app. You can alternatively run docker-compose up using the docker-compose binary. 

Exemplo de um ficheiro *docker-compose.yml*
```yml
version: "3.9"  # optional since v1.27.0
services:
  web:
    build: .
    ports:
      - "5000:5000"
    volumes:
      - .:/code
      - logvolume01:/var/log
    links:
      - redis
  redis:
    image: redis
volumes:
  logvolume01: {}
```