<%--
  Created by IntelliJ IDEA.
  User: samu9nai
  Date: 2026. 6. 11.
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>조건물 결과</h3>
    조건 결과 : ${sessionScope.testResult}

    <h3>회원 목록</h3>
    <ul>
        <c:forEach var="m" items="${memberList}">
            <li>${m.name} : ${m.userid}</li>
        </c:forEach>
    </ul>
</body>
</html>
