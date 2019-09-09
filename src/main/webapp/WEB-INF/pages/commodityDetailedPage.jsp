<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta  http-equiv="Content-Type" content=“multipart/form-data; charset=utf-8”">
    <script src="/js/jquery-1.10.2.min.js" type="text/javascript"></script>
    <jsp:include   page="pageBase.jsp" flush="true"/>
    <base href="${pageContext.request.contextPath}/">
</head>
<style>
    body{
        background-color: white;
        position: relative;
    }
    #div{
        idth: 50%;
        margin-left: 25%;
        margin-right: 25%;
        margin-top: 100px;
    }
    h2{
        text-align:center;
        vertical-align:middle;
        padding:4px;
    }
    #image{
        float: left;
        padding-left: 22%;
        margin-top: -10px;
    }
    #imageFont{
        font-size: 25px;
        padding-left: 6%;
    }
    #flont{
        float: right;
        padding-right: 3%;
        margin-left: 2%;
        margin-top: 15px;
    }
    .imgShow{
        width: 200px;
        height: 200px;
    }
    .titleFlont{
        font-size: 20px;
        float: left;
        margin-top: 2px;
    }
    .valueFlot{
        float: right;
        margin-top: 2px;
    }
</style>
<body>
<h2>商品详情</h2>
<div id="div">
    <div id="image">
        <p id="imageFont">图片：</p>
        <img  src="/commodity/showPicture?cId=${requestScope.commodityDetailedMapper.cId}"  class="imgShow" width="100px" height="100px">
    </div>
    <div id="flont">
        <div id="cName">
            <span class="titleFlont">名称:</span>
            <input class="valueFlot" type="text" value="${requestScope.commodityDetailedMapper.cName}"><br>
        </div>
        <div id="cType">
            <span  class="titleFlont">类型:</span>
            <input class="valueFlot"type="text" value="${requestScope.commodityDetailedMapper.cType}"><br>
        </div>
        <div id="price">
            <span  class="titleFlont">价格:</span>
            <input class="valueFlot" type="text" value="${requestScope.commodityDetailedMapper.price}"><br>
        </div>
        <div id="sender">
            <span  class="titleFlont">发布人:</span>
            <input class="valueFlot" type="text" value="${requestScope.commodityDetailedMapper.sender}"><br>
        </div>
        <div id="state">
            <span  class="titleFlont">状态:</span>
            <c:if test="${requestScope.commodityDetailedMapper.state  == 0}">
                <input  class="valueFlot" type="text" value="在售"><br>
            </c:if>
            <c:if test="${requestScope.commodityDetailedMapper.state == 1}">
                <input class="valueFlot" type="text" value="下架"><br>
            </c:if>
        </div>
        <div id="createTime">
            <span  class="titleFlont">创建时间:</span>
            <input class="valueFlot" type="text" value="${requestScope.commodityDetailedMapper.createTime}"><br>
        </div>
        <div id="sign">
            <span  class="titleFlont">${requestScope.commodityDetailedMapper.sign}:</span>
            <input class="valueFlot" type="text" value="${requestScope.commodityDetailedMapper.signDescribes}"><br>
        </div>
    </div>

</div>
</body>
</html>
