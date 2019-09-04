<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
    <script>
        $(function () {
            //提交非空验证
            $("#from").submit(function () {
                var account=$("#account").val()
                var password=$("#password").val()
                if(account==""){
                    $(".isNullAccount").css("display","block");
                    return false;
                }
                if(password==""){
                    $(".isNullPass").css("display","block");
                    return false;
                }
                return true;
            })
        })
    </script>
</head>
<body>
<table>
    <form action="/account/login" method="post">
        <tr>
            <td><p>登录</p></td>
        </tr>
        <tr>
            <td><input type="text" name="account" id="account" placeholder="账 户："></td>
        </tr>
        <tr>
            <td>
                <span style="display:none" class="isNullAccount">账户不能为空</span>
            </td>
        </tr>
        <tr>
            <td>
                <input type="password" name="password" id="password" placeholder="密码">
            </td>
        </tr>
        <tr>
            <td>
                <span style="display:none" class="isNullPass">密码不能为空</span>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
        </tr>
    </form>
</table>
</body>
</html>
