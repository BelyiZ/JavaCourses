Для решения данной задачи необходимо использовать Java Reflection API.
По своей сути Reflection API - это набор инструментов для разработчика, 
который помогает исследовать данные о программе во время ее выполнения в обход принципа инкапсуляции.

Имеется класс User, который должен мапится в базу данных(при этом база должна собираться автоматически во время выполнения программы).
Чтобы БД смогла собрать корректно таблицу с нужными столбцами, данную информацию ей нужно предоставить.

Необходимо написать метод, который будет возвращать заполненый объект UserTableMetadata.

1) Требования для создания класса UserTableMetadata:
	а) публичный класс
	б) имеет 2 поля: tableName - String(название таблицы), 
			 fieldWithType - Map<String, String>(название колонки и соответствующий ему тип).
	в) поля должны быть с модификатором private, при этом должны иметь соответствующие getter/setter методы.

2) Класс User уже реализован и находится по пути com/homework/reflection/api/model/User.java
	а) все поля класса являются строго приватными(private).
	б) класс не содержит в себе никаких getter/setter методов.
	Важно: дописывать классу дополнительный функционал нельзя!

Задача: получить из класса User в режиме Runtime в обход инкапсуляции название класса, 
    а так же названия полей и соответствующий им тип данных.
	Используя полученную информацию, собрать объект userTableMetadata и вернуть его в методе.

	1) Получить название класса, переформатировать его с camelCase на snake_case(User -> user) - он будет выступать в роли tableName.
	2) Получить названия всех полей, переформатировать их с camelCase на snake_case(userName -> user_name).
	3) Получить тип данных раннее полученных полей и составить Map<String, String>, где ключ = название поля, value = тип данных - данная мапа будет выступать в роли fieldWithType.
	4) Инициализированный объект класса UserTableMetadata нужно вернуть в методе getUserTableMetadata() класса ReflectionApiMetadataService .

Тесты запускаются из класса ReflectionApiServiceTest по пути 'test/java/com/homework/reflection/api/service'.