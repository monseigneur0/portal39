<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>게시물 목록</title>
    <%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
</head>
<body>
<h1>게시물 목록</h1>
<table>
    <thead>
    <tr>
        <td>제목</td>
        <td>관서</td>
        <td>부서</td>
        <td>날짜</td>
        <td>내용</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="row" items="${data}">
        <tr>
            <td>
                <a href="/boardlink/${row.board}/${row.uid}"> ${row.sub} </a>
            </td>
            <td>${row.zone}</td>
            <td>${row.place}</td>
            <td><fmt:formatNumber type="number" maxFractionDigits="3" value="${row.signdate}" /></td>
            <td>${row.con}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script type="text/javascript">
    function linkPage(pageNo){
        location.href = window.location.pathname +"?pageNo="+pageNo;
    }
</script>
<ui:pagination paginationInfo = "${paginationInfo}"
               type="text"
               jsFunction="linkPage"/>
<p>	<br/>
    <a href="/boardlink">목록으로</a>
    <a href="/boardlink/write">게시물 생성하기</a>
</p>
</body>
</html>