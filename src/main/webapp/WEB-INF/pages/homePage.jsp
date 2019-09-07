<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta  http-equiv="Content-Type" content=“multipart/form-data; charset=utf-8”">
    <title>上传文件</title>
    <script src="/js/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            defaultOption();
            $("#type").change(function () {
                $(".position").empty();
                var dType = $(this).children("option:selected").val();
                ajax(dType);
            })
        })
        
        function defaultOption() {
            var dType = $("#type").children("option:selected").val();
            ajax(dType);
        }
        
        function ajax(dType) {
            $.ajax({
                url:"/dictionary/getOption",
                type:"post",
                dataType:"json",
                data:{"dType":dType},
                success:function (data) {
                    $.each(data,function (i,item) {
                        $(".position").append("<option>"+item.describes+"</option>")
                    })
                },
                error:function (error) {
                    alert("error111:"+error);
                }
            })
        }
        function clickButton(obj) {
            $('.'+obj).click();
        }

        function getObjectURL(file) {
            var reader = new FileReader();
            var file = $(".file")[0].files[0];
            reader.readAsDataURL(file);
            reader.onload = function (e) {
                $(".imgShow").attr("src",this.result);
            }
            //sendPicture();

           /*
            var url = null ;
            if (window.createObjectURL != undefined) { // basic
                url = window.createObjectURL(file) ;
           }else if (window.URL != undefined) { // mozilla(firefox)
                try{
                    url = window.URL.createObjectURL(file) ;
                }catch (e){

                }
           }else if (window.webkitURL != undefined) { // webkit or chrome
                url = window.webkitURL.createObjectURL(file) ;
            }
            alert(url);
            $("#imgShow").attr("src",url);*/
        }
        /*function sendPicture() {
            var form = $("#form")[0];
            var formData = new FormData(form);
            var file = $("#file")[0].files[0];
            formData.append("sendImg",file);
            console.log(formData);
            $.ajax({
                url:"/commodity/sendPicture",
                type:"post",
                dataType:"json",
                processData:false,
                contentType:false,
                data:formData,
                success:function (result) {
                    alert(result)
                }
            })
        }*/
        //修改时方法
        $(document).ready(function(){
            var blob = $("#blob").val();
            if(blob == null || blob == undefined || blob == ""){

            }else {
                blobToDataUrl(blob,toShowPicture())
            }
        })
        function blobToDataUrl(obj, callback){
            var fileReader = new FileReader();
            fileReader.readAsDataURL(obj);
            fileReader.onload = function (e){
                callback(e.target.result);
            };
        }
        function toShowPicture(dataUrl) {
            $(".imgShow").attr("src",dataUrl);
        }
    </script>
</head>
<body>
    <c:if test="${empty requestScope.commodities}">
        <h2>发布商品</h2>
        <form  enctype="multipart/form-data" action="/commodity/add" method="post" accept-charset="utf-8">
            <input type="text" id ="sender" style="display: none" name="sender" value="${sessionScope.account.id}">
            <p>类型：</p>
            <select id="type" name="cType">
                <option class="numberCode" value="1">电脑</option>
                <option class="numberCode" value="2">手机</option>
            </select>
            <p>品牌：</p>
            <select class="position">
                <option>--请选择--</option>
            </select>
            <p>名称：</p>
            <input type="text" name="cName">
            <p>价格：</p>
            <input type="text" name="price">
            <p>图片：</p>
            <input type="file"  name="sendImg" class="file" style="display: none" onchange="getObjectURL(this)">
            <button type="button" onclick="clickButton('file')">选择图片</button>
            <img class="imgShow" width="100px" height="100px">
            <input type="submit" value="上传">
        </form>
    </c:if>

    <button><a href="/commodity/alert">修改商品</a></button>
    <c:if test="${!empty requestScope.commodities}">
        <h2>修改商品</h2>
        <c:forEach items="${requestScope.commodities}" var="result">
            <form enctype="multipart/form-data" action="/commodity/submitAlert" method="post" accept-charset="utf-8">
                <p>名称：</p>
                <input type="text" name="cName" value="${result.cName}">
                <p>价格：</p>
                <input type="text" name="price" value="${result.price}">
                <p>图片：</p>
                <input type="file"  name="sendImg"  class="file" style="display: none" onchange="getObjectURL(this)">
                <input style="display:none" id="blob" value="${result.image}">
                <button  type="button" onclick="clickButton('file')">选择图片</button>
                <img  class="imgShow" width="100px" height="100px">
                <input type="submit" value="修改">
            </form>

        </c:forEach>
    </c:if>

</div>

</body>
</html>
