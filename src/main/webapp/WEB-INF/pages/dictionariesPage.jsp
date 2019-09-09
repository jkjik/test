<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>字典表</h2>
<table>
    <tr>
        <td>类型</td>
        <td>数字编码</td>
        <td>编码解读</td>
        <td>描述</td>
    </tr>
    <c:forEach items="${requestScope.dictionaryViewList}" var="result">
        <tr>
            <td>${result.dType}</td>
            <td>${result.numberCode}</td>
            <td>${result.codeDescribes}</td>
            <td>${result.describes}</td>
        </tr>
    </c:forEach>
</table>
<a href="/dictionary/add">添加属性</a>
</body>
</html>
