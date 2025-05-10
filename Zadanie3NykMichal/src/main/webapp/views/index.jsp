<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Zadanie 3</h1>
        <h2>Nyk Michał</h2>
        <h2>Dane z wbudowanego zapytania @Repository</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nazwa</th>
                    <th>Kod</th>
                    <th>Populacja</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cities}" var="city">
                    <tr>
                        <td>${city.id}</td>
                        <td>${city.name}</td>
                        <td>${city.pincode}</td>
                        <td>${city.population}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h2>Dane z zapytania na podstawie nazwy metody findAllByOrderByNameAsc</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nazwa</th>
                    <th>Kod</th>
                    <th>Populacja</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${citiesOrderAsc}" var="city">
                    <tr>
                        <td>${city.id}</td>
                        <td>${city.name}</td>
                        <td>${city.pincode}</td>
                        <td>${city.population}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h2>Dane z zapytania JPQL</h2>
        <table>
            <thead>
                <tr>
                    <th>Wielkosc</th>
                    <th>Liczba miast</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cityReport}" var="cityReport">
                    <tr>
                        <td>${cityReport.citySize}</td>
                        <td>${cityReport.cityCount}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h2>Dane z zapytania Native Query</h2>
        <table>
            <thead>
                <tr>
                    <th>Wielkosc</th>
                    <th>Liczba miast</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cityReport2}" var="cityReport2">
                    <tr>
                        <td>${cityReport2.citySize}</td>
                        <td>${cityReport2.cityCount}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h2>Licznik zapytan: ${counterValue}</h2>
    </body>
</html>
