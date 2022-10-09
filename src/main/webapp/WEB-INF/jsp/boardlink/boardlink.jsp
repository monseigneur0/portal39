<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>게시판 목록</title>
</head>
<body>
<h1>게시판 목록</h1>
<table>
    <thead>
    <tr>
        <td>게시판 명</td>
        <td>게시판 id</td>
        <td>게시판 타입</td>
        <td>게시판 code</td>
        <td>부서</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${data}">
        <tr>
            <td>
                <a href="/boardlink/${row.code}">
                        ${row.name}
                </a>
            </td>
            <td>${row.uid}</td>
            <td>${row.type}</td>
            <td>${row.code}</td>
            <td>${row.owner}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>