<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.contextPath}/">
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>

    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap-table-master/dist/bootstrap-table.min.css">

    <script src="/js/jquery-1.10.2.min.js"></script>
    <script src="bootstrap/js/Bootstrap/bootstrap.min.js"></script>

    <script src="/bootstrap-table-master/dist/bootstrap-table.min.js"></script>
    <script src="/bootstrap-table-master/dist/locale/bootstrap-table-zh-CN.min.js"></script>

    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="Layout/css/dmaku.css" />
    <script type="text/javascript" src="Layout/js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".div2").click(function(){
                $(this).next("div").slideToggle("slow")
                    .siblings(".div3:visible").slideUp("slow");
            });
        });
    </script>
    <style>
        .left{
            background-color: #9acfea;
        }
        body{
            background-color: white;
            position: relative;
        }
        #div{
            width: 50%;
            align:center;
            margin-top: 100px;
        }
        .nav>li>a {
            position: relative;
            display: block;
            padding: 40px 50px;
        }
        .navbar-brand {
            float: left;
            padding: 40px 20px 20px 20px;
            font-size: 20px;
            line-height: 22px;
            height: 50px;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- 品牌和切换分组，以更好的移动显示 -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">${sessionScope.account.account}</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/account/gotoPage">主页<span class="sr-only">(主页)</span></a></li>
                <li><a href="/account/sendCommodity">发布商品</a></li>
                <li><a href="/account/myCommodity">我发布的</a></li>
                <li><a href="/dictionary/vindicate">属性添加</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">退出</a></li>
            </ul>
        </div>

    </div>
</nav>

<div class="left">
    <div class="div1">
        <div class="left_top"><img src="Layout/images/bbb_01.jpg"><img src="Layout/images/bbb_02.jpg" id="2"><img src="Layout/images/bbb_02.jpg"><img src="Layout/images/bbb_01.jpg"> </div>

        <div class="div2"><div class="zxcp"> </div><a href="/account/sendCommodity">发布商品</a></div>

        <div class="div2"><div class="lmtj"> </div><a href="/account/myCommodity">我发布的</a></div>

        <div class="div2"><div class="lmtj"> </div><a href="/dictionary/vindicate">属性添加</a></div>

    </div>
</div>

</body>
</html>

