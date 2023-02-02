<h1>Задание.</h1>
Реализовать уровень model для приложения «Заказы и товары» в рамках разрабатываемого приложения.
Протестировать реализованный код через юнит-тесты. 
Реализовать диаграмму классов полученного приложения.
<h2>Модель</h2>

1.	Товар - содержит:<br>
  -id;<br>
  -наименование товар;<br>
  -артикул (число)
2.	Заказ - содержит:<br>
  -id;<br>
  -id клиента (связь);<br>
  -описание заказа (description);
3.	Расшивка заказ-товар - содержит:<br>
  -id;<br>
  -id товара (связь);<br>
  -id заказа (связь);<br>
  -кол-во единиц товара;
4.	Клиент - содержит:<br>
  -id;<br>
  -имя клиента.

Для каждой сущности интерфейс DAO должен поддерживать базовые операции:
1.  listAll() – получить все объекты
2.  getById(Integer id) – получить объект по id
3.  add(Entity obj) – добавить новую запись
4.  delete(Integer id) – удалить  запись по id
5.  update(Entity obj) – обновить данные записи

<h3>Стек технологий</h3>

[![Typing SVG](https://readme-typing-svg.herokuapp.com?color=%2336BCF7&lines=Spring/Springboot+Thymeleaf+HTML/CSS)](https://git.io/typing-svg)
[![Typing SVG](https://readme-typing-svg.herokuapp.com?color=%2336BCF7&lines=Bootstrap+PostgreSQL+Hibernate)](https://git.io/typing-svg)
