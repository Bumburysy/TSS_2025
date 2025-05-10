<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div><h1>Hello World!</h1></div>
        <div><h1>Nyk Michał IO2</h1></div>
        <div>
            <a href="<c:url value='/actuator' />" > Actuator</a> <br />
            <a href="<c:url value='/actuator/info' />" > Actuator Info</a> <br />
        </div>
        
        Wersja Spring: <c:out value="${springVersion}" /> <br />
        
        Parametry z pliku pom.xml przez application.properties - Wersja JDK: <c:out value="${myjdkversion}" /> <br />
        Parametry z pliku pom.xml przez application.properties - Wersja Spring Boot Starter: <c:out value="${springbootversion}" /> <br />
        
        Parametry z Maven przez application.properties - Nazwa aplikacji: <c:out value="${applicationName}" /> <br />
        Parametry z Maven przez application.properties - Wersja builda: <c:out value="${buildVersion}" /> <br />
        Parametry z Maven przez application.properties - Czas kompilacji: <c:out value="${buildTimestamp}" /> <br />
    </body>
</html>
