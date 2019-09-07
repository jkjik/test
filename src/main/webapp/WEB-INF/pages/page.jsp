<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/9/7
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>Title</title>
    <script src="/js/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script>

    function beforePage() {

    }
    function nextPage() {

    }
    </script>
</head>
<body>

    <p>第${page.newPage}页</p>
    <p onclick="beforePage()">上一页</p>
    <p onclick="nextPage()">下一页</p>
</body>
</html>
