# Projeto QA API Automation

Este é um projeto de automação de testes para QA API usando Java, Cucumber e TestNG.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em seu sistema:

- Java 21
- Maven 3.9.6

## Configuração do Projeto

1. Clone este repositório em sua máquina local:

   ```bash
   git clone https://github.com/Fjulio2018/API-Rest-Assured-Testing
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd API-Rest-Assured-Testing-main\API-Rest-Assured-Testing-main

   ```

3. Build do Projeto com Maven:

   ```bash
   mvn clean install
   ```

## Executando os Testes

Para executar os testes, utilize o seguinte comando Maven:

```bash
mvn test -Dtest=CucumberRunner
```

Isso iniciará a execução dos testes usando o runner Cucumber.

## Estrutura do Projeto

- **src/test/java**: Contém os arquivos Java para implementação dos testes.
- **src/test/resources**: Contém os arquivos de recursos para os testes, como features Cucumber e arquivos de configuração.
- **target**: Diretório onde os resultados do build serão armazenados.

## Dependências Principais

    TestNG:
        Nome: TestNG
        Versão: 7.7.1

    Cucumber:
        Nome: Cucumber Java
        Versão: 7.11.1
        Nome: Cucumber TestNG
        Versão: 7.11.1

    RestAssured:
        Nome: RestAssured
        Versão: 5.3.0

    Hamcrest:
        Nome: Hamcrest Core
        Versão: 1.3

    JSON Schema Validator:
        Nome: JSON Schema Validator (RestAssured)
        Versão: 5.3.0

    Lombok:
        Nome: Lombok
        Versão: 1.18.28

    AssertJ:
        Nome: AssertJ Core
        Versão: 3.24.2

    Owner:
        Nome: Owner
        Versão: 1.0.12

    Cucumber PicoContainer:
        Nome: Cucumber PicoContainer
        Versão: 7.12.1

    Allure:
        Nome: Allure RestAssured
        Versão: 2.22.1
        Nome: Allure TestNG
        Versão: 2.18.1

    JSON Simple:
        Nome: JSON Simple
        Versão: 1.1.1

    Everit JSON Schema:
        Nome: Everit JSON Schema
        Versão: 1.5.1

## Relatórios

Os relatórios de execução podem ser encontrados no diretório `target/surefire-reports` após a execução dos testes.

## Notas Adicionais


