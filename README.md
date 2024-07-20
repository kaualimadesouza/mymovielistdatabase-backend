[JAVASCRIPT__BADGE]: https://img.shields.io/badge/Javascript-000?style=for-the-badge&logo=javascript
[TYPESCRIPT__BADGE]: https://img.shields.io/badge/typescript-D4FAFF?style=for-the-badge&logo=typescript
[EXPRESS__BADGE]: https://img.shields.io/badge/express-005CFE?style=for-the-badge&logo=express
[VUE__BADGE]: https://img.shields.io/badge/VueJS-fff?style=for-the-badge&logo=vue
[NEST__BADGE]: https://img.shields.io/badge/nest-7026b9?style=for-the-badge&logo=nest
[GRAPHQL__BADGE]: https://img.shields.io/badge/GraphQL-e10098?style=for-the-badge&logo=graphql
[JAVA_BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING_BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[MONGO_BADGE]:https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white
[AWS_BADGE]:https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white


<h1 align="center" style="font-weight: bold;">MyMovieListDatabase - Backend 💻</h1>

<p align="center">
 <a href="#about">Sobre</a> • 
  <a href="#prerequisites">Pré Requisitos</a> •
 <a href="#routes">API Endpoints</a> •
 <a href="#contato">Contato</a>
</p>

<h2 id="about">Sobre o Projeto</h2>

Aplicação backend desenvolvida com Java e Spring Framework, que oferece todas as operações CRUD (GET, POST, DELETE). Esta API autoral se conecta a um banco de dados PostgreSQL para armazenar dados dos filmes. Este README fornece instruções para instalar e executar a aplicação localmente, mas ela também está disponível em um EC2 da AWS no link abaixo.

EC2: [http://44.195.40.138:8080/{endpoint}](http://44.195.40.138:8080/movies)

[Website on Vercel](https://mymovielistdatabase-frontend-7r9wxqdks-kauas-projects-6ea027af.vercel.app/)

[Frontend Repository](https://github.com/kaualimadesouza/mymovielistdatabase-backend.git)

<h3>Tecnologias</h3>

![java][JAVA_BADGE]
![spring][SPRING_BADGE]
![aws][AWS_BADGE]


<h3 id="prerequisites">Pré Requisitos</h3>

Você deve ter o Java 17 ou superior instalado em sua máquina e o git para clonar o repositório.

- [Java](https://www.java.com/pt-BR/download/ie_manual.jsp?locale=pt_BR)
- [Git](https://git-scm.com/downloads)

<h3>Cloning</h3>

Primeiro Clone o repositorio

```bash
git clone https://github.com/kaualimadesouza/mymovielistdatabase-backend.git
```

<h3>Variáveis de ambiente</h2>

Importe o projeto para a sua IDE (Eclipse, Intelij ou VSCode) e altere o seu application.properties de acordo com sua senha e usuario do banco de dados

```yaml
spring.datasource.url=jdbc:postgresql://localhost:5432/movies
spring.datasource.username=postgres
spring.datasource.password=password
```

Após isso, instale as dependências do projeto clicando no 'package':

![image](https://github.com/user-attachments/assets/71b32a57-e709-46ac-ac78-e280e6fa4dd7)

Com todas essas alterações concluídas, já é possivel iniciar o projeto com sucesso.

<h2 id="routes">API Endpoints</h2>

​
| Rota               | Descrição                                          
|----------------------|-----------------------------------------------------
| <kbd>GET /movies</kbd>     | Retorna todos os filmes registrados
| <kbd>GET /movies/search/{titleToSeach}/{page}/{size}</kbd>     | Retorna todos os filmes cujo título esteja próximo da variável titleToSearch. A resposta é paginada conforme o tamanho especificado, que é definido na URL.
| <kbd>POST /movies</kbd>     | Insere um filme no banco de dados a partir de um arquivo JSON enviado no corpo da requisição.
| <kbd>POST /movies/all</kbd>     | Insere uma lista de filmes no banco de dados
| <kbd>DELETE /movies/{movieid}</kbd>     | Deleta um filme com base no seu 'id'.
| <kbd>UPDATE /movies/{movieid}</kbd>     | Altera um filme com base no seu ID, utilizando as informações fornecidas no corpo da requisição.

<h3>GET /movies</h3>

**RESPONSE**
```json
[
  {
    "id": "4a6c9b5c-fc72-4316-af92-e7ba97fe49a8",
    "title": "The Dark Knight",
    "description": "When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.",
    "imgURL": "https://a.ltrbxd.com/resized/sm/upload/78/y5/zg/ej/oefdD26aey8GPdx7Rm45PNncJdU-0-1000-0-1500-crop.jpg?v=2d0ce4be25",
    "genre": "Action, Crime, Drama",
    "rating": 9,
    "movieYear": 2008,
    "imdbId": "tt0468569"
	}
]
```

<h3>GET /movies/search/fight/0/1</h3>

**RESPONSE**
```json
[
  {
    "id": "b882973c-bece-4199-9531-0fe630d54f3b",
    "title": "Fight Club",
    "description": "An insomniac and a soap salesman channel male aggression into underground \"fight clubs\" spreading nationwide. An eccentric disrupts their plan, leading to chaos.",
    "imgURL": "https://a.ltrbxd.com/resized/film-poster/5/1/5/6/8/51568-fight-club-0-1000-0-1500-crop.jpg?v=768b32dfa4",
    "genre": "Drama",
    "rating": 8,
    "movieYear": 1999,
    "imdbId": "tt0137523"
  }
]
```

<h3>POST /movies</h3>

**REQUEST**
```json
{
    "title": "The Godfather Part II",
    "description": "The early life and career of Vito Corleone in 1920s New York is portrayed while his son, Michael, expands and tightens his grip on the family crime syndicate.",
    "imgURL": "https://a.ltrbxd.com/resized/film-poster/5/1/8/1/6/51816-the-godfather-part-ii-0-1000-0-1500-crop.jpg?v=6a49853f25",
    "genre": "Crime, Drama",
    "rating": 9.0,
    "movieYear": 1974,
    "imdbId": "tt0071562"
}
```

**RESPONSE**
```json
{
    "id": "42f4a85e-4d4b-4641-9521-d8a9099dd82f"
    "title": "The Godfather Part II",
    "description": "The early life and career of Vito Corleone in 1920s New York is portrayed while his son, Michael, expands and tightens his grip on the family crime syndicate.",
    "imgURL": "https://a.ltrbxd.com/resized/film-poster/5/1/8/1/6/51816-the-godfather-part-ii-0-1000-0-1500-crop.jpg?v=6a49853f25",
    "genre": "Crime, Drama",
    "rating": 9.0,
    "movieYear": 1974,
    "imdbId": "tt0071562"
}
```

<h3>POST /movies/all</h3>

**REQUEST**
```json
[
  {
    "title": "Fight Club",
    "description": "An insomniac and a soap salesman channel male aggression into underground \"fight clubs\" spreading nationwide. An eccentric disrupts their plan, leading to chaos.",
    "imgURL": "https://a.ltrbxd.com/resized/film-poster/5/1/5/6/8/51568-fight-club-0-1000-0-1500-crop.jpg?v=768b32dfa4",
    "genre": "Drama",
    "rating": 8,
    "movieYear": 1999,
    "imdbId": "tt0137523"
  }
]
```

**RESPONSE**
```
  Inserido com sucesso
```

<h2 id="contato">Contato</h2>

Linkedin [@kaualimadesouza](https://www.linkedin.com/in/kaualimadesouza/) &nbsp;&middot;&nbsp;
