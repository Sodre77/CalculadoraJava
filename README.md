# Calculadora Java com JUnit 5

Projeto simples em Java desenvolvido para praticar:

- implementacao de uma calculadora com as quatro operacoes basicas;
- testes automatizados com JUnit 5;
- uso de Git e GitHub com branch, commit e merge;
- organizacao de um fluxo de entrega sem Maven.

## Funcionalidades

- `somar(int a, int b)`
- `subtrair(int a, int b)`
- `multiplicar(int a, int b)`
- `dividir(double a, double b)`

A divisao trata tentativa de divisao por zero com `ArithmeticException`.

## Estrutura do projeto

- `src/main/java/br/edu/projeto/calculadora/Calculadora.java`
- `src/main/java/br/edu/projeto/calculadora/App.java`
- `src/test/java/br/edu/projeto/calculadora/CalculadoraTest.java`
- `src/test/java/br/edu/projeto/calculadora/CalculadoraFuncionalTest.java`
- `lib/`
- `out/`

## Dependencia de testes

Como este projeto pode ser executado sem Maven, o JUnit 5 precisa ser baixado manualmente.

Arquivo esperado em `lib/`:

- `junit-platform-console-standalone-1.10.2.jar`

## Como compilar

Compilar as classes principais:

```powershell
javac -d out\main src\main\java\br\edu\projeto\calculadora\*.java
```

Compilar os testes:

```powershell
javac -cp ".\lib\junit-platform-console-standalone-1.10.2.jar;out\main" -d out\test src\test\java\br\edu\projeto\calculadora\*.java
```

## Como executar

Executar a aplicacao de exemplo:

```powershell
java -cp out\main br.edu.projeto.calculadora.App
```

Executar os testes:

```powershell
java -jar .\lib\junit-platform-console-standalone-1.10.2.jar --class-path "out\main;out\test" --scan-class-path
```

## Testes implementados

### Unitarios

- soma com numeros positivos, negativos e zero;
- subtracao com numeros positivos, negativos e zero;
- multiplicacao com numeros positivos, negativos e zero;
- divisao normal e divisao por zero.

### Funcionais

- fluxo completo usando varias operacoes em sequencia.

## Git e GitHub

Para atender a atividade, o projeto deve mostrar:

1. criacao de conta no GitHub;
2. criacao de um repositorio;
3. criacao de branch;
4. commits do projeto;
5. merge entre branches;
6. clone de um repositorio publico externo.

## Observacao

Os arquivos de teste foram validados localmente com sucesso usando o JUnit 5 standalone.
