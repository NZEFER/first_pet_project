<!DOCTYPE html>
<html>
<head>
    <title>SHOP</title>
</head>
<body>
<h1>SHOP | <a href = "/login">Войти</a></h1><hr>
<form action = "/logout" method = "post">
    <input type = "hidden" name = "_csrf" value = ${_csrf.token}>
    <input type = "submit" value = "выйти"/>
</form>
<h4>Список товаров</h4>
<form action = "/" method = "get">
    Поиск по названию товара <input type = "text" name = "title"><br>
    <input type = "submit" value = "поиск"/>
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
    <#else>
    <h3>Товаров нет</h3>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Название объявления: <input type="text" name="title"/><br><br>
    Описание объявления: <input type="text" name="description"/><br><br>
    Цена: <input type="number" name="price"/><br><br>
    Город: <input type="text" name="city"/><br><br>
    Автор: <input type="text" name="Author"/><br><br>
    Первая фотография: <input type="file" name="file1"/><br><br>
    Вторая фотография: <input type="file" name="file2"/><br><br>
    Третья фотография: <input type="file" name="file3"/><br><br>

    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>