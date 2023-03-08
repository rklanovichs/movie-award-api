# movie-award

> Desafio técnico TEXO IT.

[![Java Version][java-image]][java-url]
[![Spring Version][spring-image]][spring-url]

Esta aplicação atua na camada API, e possui a responsabilidade de gerir os dados relativos à lista de filmes indicados e 
vencedores da categoria Pior Filme do Golden Raspberry Awards.

## Configuração de Desenvolvimento

### Build

Configurar o Java versão 17, para fazer o build da aplicação deve ser executado o seguinte comando: Execute Maven Goal -> mvn clean install -U.

```sh
mvn clean install -U
```

#### Intellij

Para que essa configuração fique disponível no menu de execução deve ser feito um build (CRTL+F9) do projeto.

No diretório src/main/java/br/com/challenge/texoit/movieaward execute a classe MovieAwardApplication (Run MovieAwardApplication). 
O projeto irá compilar e executará o script sql de configuração inicial para o banco de dados, e será executado automaticamente 
a leitura e importação de toda a lista de filmes contida no arquivo movielist.csv. 
Esse comportamento ocorre também ao executar os testes de integração para garantir a integridade dos dados da lista de filmes.
Dentro do MoviesAwardResource existem 2 endpoints responsáveis por listar todos os filmes da lista, e listar o vencedor
por intervalo mínimo e máximo.


```json
{
  "version": "1.0.0",
  "configurations": [
    {
      "type": "java",
      "name": "Launch Application",
      "request": "launch",
      "cwd": "${workspaceFolder}",
      "console": "internalConsole",
      "mainClass": "br.com.challenge.texoit.movieaward.MovieAwardApplication",
      "projectName": "movie-award",
      "env": { "SPRING_PROFILES_ACTIVE": "local" }
    }
  ]
}
```

<!-- Markdown link & img dfn's -->

[java-image]: https://img.shields.io/badge/Java-V1.17-yellow
[spring-image]: https://img.shields.io/badge/Spring--Boot-V3.0.4.RELEASE-yellow
[java-url]: https://www.oracle.com/java/technologies/javase/8u-relnotes.html
[spring-url]: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-dependencies/1.5.21.RELEASE
