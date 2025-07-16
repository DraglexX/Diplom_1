# Stellar Burgers unit-tests

Набор юнит-тестов для приложения **Stellar Burgers**. Мы покрываем тестами основные модели и бизнес-логику бургеров, используя JUnit 4, Mockito и Jacoco.

## Описание

Версия Java 11.

В проекте используется библиотека:

- JUnit 4
- Jacoco
- Mockito

## Структура проекта
```bash
pom.xml
README.md
.gitignore
src
|-- main
|   |-- java
|   |   |-- org
|   |   |   |-- example
|   |   |   |   |-- Bun.java
|   |   |   |   |-- Burger.java
|   |   |   |   |-- Database.java
|   |   |   |   |-- Ingredient.java
|   |   |   |   |-- IngredientType.java
|   |   |   |   |-- Praktikum.java
|-- test
|   |-- java
|   |   |-- BunParamTest.java
|   |   |-- BurgerModifyTest.java
|   |   |-- BurgerPriceParamTest.java
|   |   |-- BurgerReceiptExactTest.java
|   |   |-- IngredientParamTest.java
|   |   |-- IngredientTypeTest.java
```

## Выполненные задачи
Написаны тесты для классов `Bun`, `Burger`, `Ingredient`, `IngredientType`, процент которых составляет не менее 70%.