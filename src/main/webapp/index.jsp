<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<body>
<script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
<script>
    $(function () {
        //提交非空验证
        $("#from").submit(function () {
            var account=$("#account").val()
            var password=$("#password").val()
            if(account==""){
                $(".checkAccount").css("display","block");
                return false;
            }
            if(password==""){
                $(".checkPassword").css("display","block");
                return false;
            }
            return true;
        })
        //验证
        $("#account").change(function () {
            checkSameAccount();
        })
    })
    //账户重复验证方法
    function checkSameAccount() {
        var account = $("#account").val();
        var existAccount = $(".existAccount");
        var url = "/account/checkSameAccount";
        var args = {"account":account};
        $.post(url,args,function (data) {
            if(data == "yes"){
                existAccount.css("display","block")
                $("#form").submit(function () {
                    return false;
                })
            }else {
                existAccount.css("display","none");
                $("#form").submit(function () {
                    return true;
                })
            }
        })
    }
</script>
<table>
    <form action="/account/register" id="form" method="post">
        <tr>
            <td><p>注册</p></td>
        </tr>
        <tr>
            <td><input type="text" name="account" id="account" placeholder="账户"><br></td>
        </tr>
        <tr>
            <td>
                <span style="display:none" class="existAccount">账户已经存在</span>
                <span style="display:none" class="checkAccount">账户不能为空</span>
            </td>
        </tr>
        <tr>
            <td><input type="password" name="password" id="password" placeholder="密码"><br></td>
        </tr>
        <tr>
            <td>
                <span style="display:none" class="checkPassword">密码不能为空</span>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </form>
    <tr>
        <td><p>已有账户<a href="login.jsp">登录</a></p></td>
    </tr>
</table>

</body>
</html>
