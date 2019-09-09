<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>Title</title>
    <script src="/js/jquery-1.10.2.min.js" type="text/javascript"></script>
    <jsp:include   page="pageBase.jsp" flush="true"/>
    <base href="${pageContext.request.contextPath}/">
    <script>
    var page = $("#page").val();
    var size = $("#size").val();
    var totalNumber =$("#totalNumber").val();
    var currentPage =$("#currentPage").val();
    $(function () {
        if((currentPage -1) == 0 || (currentPage +1) == page){
            $('#beforeButton').attr('disabled',"true");
        }else {
            $('#beforeButton').removeAttr('disabled');
        }
    })
    function beforePage() {
        if((currentPage -1) == 0 || (currentPage +1) == page){
            $('#beforeButton').attr('disabled',"true");
        }else {
            $('#beforeButton').removeAttr('disabled');
        }
    }
    </script>
    <style>
        body{
            background-color: white;
            position: relative;
        }
        #div{
            width: 50%;
            margin-left: auto;
            margin-right: auto;
            margin-top: 100px;
        }
        td,h2{
            text-align:center;
            vertical-align:middle;
            padding:4px;
        }
        #leftTable{
            display:inline;
            width: 100%;
        }
        #rightTable{
            display:inline;
            width: 100%;
        }
        table{
            width: 100%;
        }
    </style>
</head>
<body>
<div id="div">
    <div id="leftTable">
        <h2>用户列表</h2>
        <table border="1px" cellpadding="0px" cellspacing="0px">
            <tr>
                <td>账户</td>
                <td>注册时间</td>
            </tr>
            <c:forEach items="${requestScope.accountList}" var="result">
                <tr>
                    <td>${result.account}</td>
                    <td>${result.createTime}</td>
                </tr>
            </c:forEach>
            <tr></tr>
        </table>
    </div>

    <div id="rightTable">
        <h2>在售商品列表</h2>
        <table border="1px" cellpadding="0px" cellspacing="0px">
            <tr>
                <td>类别</td>
                <td>商品名称</td>
                <td>价格</td>
                <td>发布人</td>
                <td>查看详情</td>
            </tr>
            <c:forEach items="${requestScope.pageBean.beanList}" var="result">
                <tr>
                    <td>${result.cType}</td>
                    <td>${result.cName}</td>
                    <td>${result.price}</td>
                    <td>${result.sender}</td>
                    <td><a href="/commodity/detailed?cId=${result.cId}">查看</a></td>
                </tr>
            </c:forEach>
            <tr></tr>
        </table>

        <span>第${requestScope.pageBean.currentPage}页</span>
        <span>共${requestScope.pageBean.page}页</span>
        <input style="display: none" id ="page" value="${requestScope.pageBean.page}">
        <input style="display: none" id ="currentPage" value="${requestScope.pageBean.currentPage}">
        <button onclick="beforePage()" id="beforeButton"><a href="/account/pageQuery?sign=1&size=${requestScope.pageBean.size}&currentPage=${requestScope.pageBean.currentPage}">上一页</a></button>
        <button onclick="nextPage()" id="nextButton"><a href="/account/pageQuery?sign=2&size=${requestScope.pageBean.size}&currentPage=${requestScope.pageBean.currentPage}">下一页</a></button>
    </div>

</div>
</body>
</html>
