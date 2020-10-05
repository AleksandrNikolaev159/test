# ***Stack используемых технологий:***
-----------------------------------
- Spring Boot
- Spring Data
- Spring MVC
- PostgreSQL
- Hibernate ORM
- JPA
- Maven
***
# ***Приложение использует базу данных PostgreSql перед сборкой исходника необходимо:***
-----------------------------------
### 1. ввести свои настройки бд в файле: \src\main\resources\application.properties 

Connection url for the database "postgres" spring.datasource.url=jdbc:postgresql://localhost:5432/postgres

Username and password spring.datasource.username=”username” spring.datasource.password=”password”

### 2. Сборка проекта
В консоли для сборки исходника необходимо ввести команду start build.bat

### 3. Запуск приложения 
В консоли для запуска приложения необходимо ввести команду start start.bat

# ***Инструкция по работе с контроллером через http запросы:***
-----------------------------------
Используйте Postman или другие сервисы для работы с Http запросами.
***

# ***Работа с контроллером:***
-----------------------------------
### Вывести все записи из таблицы 
GET запрос : http://localhost:8080/statistics
### Вывести запись из таблицы по параметру
Фильтр срабатывает на следующие параметры:
```
id       (id устройства)      http://localhost:8080/statistics?id=1
type     (тип устройства)     http://localhost:8080/statistics?type=print
user      (пользователь)      http://localhost:8080/statistics?user=user1
device     (устройство)       http://localhost:8080/statistics?device=device1
amount    (кол-во страниц)    http://localhost:8080/statistics?amount=12
timeTo    (с такой-то даты)   http://localhost:8080/statistics?timeTo=6.10.2020
timeFrom  (по такую-то дату)  http://localhost:8080/statistics?timeFrom=1.10.2020
 ```
Так же возможны комбинации параметров для более точной выборки:
```
http://localhost:8080/statistics?type=print&user=user1
http://localhost:8080/statistics?type=print&timeTo=6.10.2020
http://localhost:8080/statistics?type=print&timeTo=6.10.2020&device=device1

```
### Добавить запись в таблицу 
POST запрос : http://localhost:8080/jobs
 ***
Пример XML : 
```
<jobs>
    <job id="4">
<type>print</type>
<user>user1</user>
<device>device1</device>
<amount>10</amount>
    </job>
    <job id="5">
<type>scan</type>
<user>user1</user>
<device>device1</device>
<amount>12</amount>
    </job>
    <job id="6">
<type>fax</type>
<user>user2</user>
<device>device1</device>
<amount>5</amount>
    </job>
</jobs>
```

 ***


