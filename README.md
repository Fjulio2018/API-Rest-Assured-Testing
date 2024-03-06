# Projeto QA API Automation

Este é um projeto de automação de testes para QA API usando Java, Cucumber e TestNG.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em seu sistema:

- Java 21
- Maven 3.9.6

## Configuração do Projeto

1. Clone este repositório em sua máquina local:

   ```bash
   git clone https://seu-repositorio-git/qa-api-automation.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd qa-api-automation
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

- Java 21
- Maven 3.9.6
- TestNG 7.7.1
- Cucumber 7.11.1
- Rest Assured 5.3.0
- ...

## Relatórios

Os relatórios de execução podem ser encontrados no diretório `target/surefire-reports` após a execução dos testes.

## Notas Adicionais

- Certifique-se de ajustar as versões das dependências conforme necessário no arquivo `pom.xml`.
- Personalize este README conforme necessário para incluir informações específicas do seu projeto.
