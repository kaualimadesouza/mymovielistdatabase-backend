<h1>MyMovieListDatabase - Backend</h1>

Integração da API do projeto de avaliação de filmes, com objetivo de realizar os comandos CRUD com sucesso.
Tecnologias usadas: <b>Java Spring</b>, <b>PostgreSQL</b> e <b>AWS: EC2 e DBS</b>

[![My Skills](https://skillicons.dev/icons?i=spring,postgres,aws&perline=3)](https://skillicons.dev)

<h2>Modelagem </h2>

<img src="modelagem.png" alt="modelagem" width="600">

<h2>Como Acessar</h2>

Você pode acessar os metodos GET <a href="http://44.195.40.138:8080/movies" target="_blank">aqui</a>

A aplicação frontend está disponivel nestas URLs: <a href="" target="_blank">Site</a> e <a href="https://github.com/kaualimadesouza/mymovielistdatabase-frontend" target="_blank">Repositorio</a>

<h2>Requisitos</h2>

Para rodar esse projeto você precisa ter o Java instalado na sua máquina.

<h2>Instalando o projeto</h2>

- Clone o Projeto
```bash
# Clone o repositório e entre na pasta
$ git clone https://github.com/kaualimadesouza/mymovielistdatabase-backend.git
$ cd mymovielistdatabase-backend
```

- Instale o postgreSQL (caso você não tenha) e crie o database <b>movies</b>.

- Insira o seu database, username e senha de acordo com o seu postgreSQL local.
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/movies # TROQUE O DATABASE COM O NOME DO SEU
spring.datasource.username=postgres # TROQUE O USERNAME COM O NOME DO SEU
spring.datasource.password=password # TROQUE A SENHA COM O NOME DA SUA
```
- na linha "spring.jpa.hibernate.ddl-auto=update" execute pela primeira vez com o valor "create" e depois troca para "update".

## Contato

&nbsp;&middot;&nbsp; Instagram: [@kl.souza1](https://www.instagram.com/kl.souza1/) &nbsp;&middot;&nbsp;
Linkedin [@kaualimadesouza](https://www.linkedin.com/in/kaualimadesouza/) &nbsp;&middot;&nbsp;
