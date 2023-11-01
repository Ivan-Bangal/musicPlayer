<p align="center">
  <a href="" rel="noopener">
 <img width=200px height=200px src="https://i.imgur.com/6wj0hh6.jpg" alt="Project logo"></a>
</p>

<h3 align="center">Music Sharing PlatForm</h3>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![GitHub Issues](https://img.shields.io/github/issues/kylelobo/The-Documentation-Compendium.svg)](https://github.com/kylelobo/The-Documentation-Compendium/issues)
[![GitHub Pull Requests](https://img.shields.io/github/issues-pr/kylelobo/The-Documentation-Compendium.svg)](https://github.com/kylelobo/The-Documentation-Compendium/pulls)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

</div>

---

<p align="center"> 
    <br> 
</p>

## 📝 Table of Contents

- [About](#about)
- [Getting Started](#getting_started)
- [Deployment](#deployment)
- [Usage](#usage)
- [Built Using](#built_using)
- [TODO](../TODO.md)
- [Contributing](../CONTRIBUTING.md)
- [Authors](#authors)
- [Acknowledgments](#acknowledgement)

## 🧐 About <a name = "about"></a>

A ideia geral desta aplicação seria de compartilhar musicas e poder popularizar os musicos que ainda não tem uma grande audiencia

"Mas Ivan não existe Soundcloud para isso?" R: Sim, mas quando entras na SoundCloud, para poderes encontrar musica Moçambicana é muito dificil, quando o utilizador vai a SoundCloud
Normalmente sabe o quer.

## 🏁 Getting Started <a name = "getting_started"></a>

O necessário para ter esta aplicação a correr são:

### Prerequisites

Java 11-21 (Não defini no POM uma versão especifica de Java, mas como já faço uso do Optional tem quer ser no minimo 11)
Maven (Para quem quiser usar o Graddle, pode usar mas não esqueça de converter o pom.xml, para o graddle)
IntelliJ, Eclipse ou VS Code (Não se atrevam de usar o NetBeans....😂😂)

### Installing

A step by step series of examples that tell you how to get a development env running.

Say what the step will be

apos o clone do Repo execute os comandos:

mvn clean install (Vai precisar de Internet para baixar os pacotes,[Lembrar que o Maven instala os pacotes na pasta C:\Users\[Seu user]\.m2] by default)
........................... e acabou👌
Os problemas vão surgir se não tem o Java instalado ou por causa de Internet

"Ivan, isto não tem base de dados?"R: Tem, esta app como está em desenvolvimento só tem o H2 como base de dados configurado e isto não precisa instalar, dai que pensei que seria ideal para aprender e ensinar quem deseja entrar no mundo do Java avançado

## 🔧 Running the tests <a name = "tests"></a>

Os testes no Spring são automatizados, basta criar que ele executa no momento do start

### Break down into end to end tests

O unico teste que está neste Repositorio é o do Load dos contextos
(Explicar isto ia levar muito tempo, recomendo uma lida na documentação do Spring), mas basicamente testa todas configurações presentes na aplicação


## 🎈 Usage <a name="usage"></a>

Para correr o projecto basta executar o comando:
mvn spring-boot:run

## 🚀 Deployment <a name = "deployment"></a>

Não faço a minima ideia de como seria o deployment desta coisa😂😂
Ainda estou a estudar

## ⛏️ Built Using <a name = "built_using"></a>

- [Spring](https://spring.io/projects/spring-boot) - Backend Framework
- [H2](https://www.h2database.com/html/main.html) - Database

## ✍️ Authors <a name = "authors"></a>

- [@Ivan-Bangal](https://github.com/Ivan-Bangal/) - Idea & Initial work


## 🎉 Acknowledgements <a name = "acknowledgement"></a>

