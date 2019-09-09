<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta  http-equiv="Content-Type" content=“multipart/form-data; charset=utf-8”">
    <title>上传文件</title>
    <script src="/js/jquery-1.10.2.min.js" type="text/javascript"></script>
    <jsp:include   page="pageBase.jsp" flush="true"/>
    <base href="${pageContext.request.contextPath}/">
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
      /*  $(document).ready(function(){
            var file = $("#blob").val();
            var reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = function (e) {
                $(".imgShow").attr("src",this.result);
            }
           /!* alert(blob);
            console.log(blob);
            if(blob == null || blob == undefined || blob == ""){

            }else {
                blobToDataUrl(blob,toShowPicture())
            }*!/
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

        function byteToBlob(arr) {
            if(typeof arr === 'string') {
                return arr;
            }
            var str = '',
                _arr = arr;
            for(var i = 0; i < _arr.length; i++) {
                var one = _arr[i].toString(2),
                    v = one.match(/^1+?(?=0)/);
                if(v && one.length == 8) {
                    var bytesLength = v[0].length;
                    var store = _arr[i].toString(2).slice(7 - bytesLength);
                    for(var st = 1; st < bytesLength; st++) {
                        store += _arr[st + i].toString(2).slice(2);
                    }
                    str += String.fromCharCode(parseInt(store, 2));
                    i += bytesLength - 1;
                } else {
                    str += String.fromCharCode(_arr[i]);
                }
            }
            var blob = new Blob([str], {
                type: 'text/plain'
            });
            return blob;
        }*/
      
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
        h2{
            text-align:center;
            vertical-align:middle;
            padding:4px;
        }
        #headFont{
            width: 100%;
            height: 80px;
        }
        #typeFont{
            float: left;
            padding-left: 6%;
            margin: 20px;
        }
        #signFont{
            float: right;
            padding-right: 6%;
            margin: 20px;
        }
        #inputBody{
            width: 100%;
            height: 50px;
            margin: 0 20px 0 20px;
            padding-left: 6%;
        }
        #priceInput{
            margin-top: 20px;
        }
        #imgFoot{
            width: 100%;
            height: 50px;
            margin: 60px 20px 0 20px;
            padding-left: 6%;
        }
        #submit{
            width: 100%;
            height: 50px;
            margin: 60px 20px 0 20px;
            padding-left: 6%;
        }
        #imgShow{

        }
        #selectImg{
            margin-left: 6%;
        }
        #alertDiv{
            margin: 20px;
        }
        #alertImgHead{
            float: left;
            margin-left: 2%;
            width: 40%;
        }
        #alertInputBody{
            float: right;
            margin-right: 2%;
            width: 50%;
        }
        #alertNameInput{

        }
        #alertPriceInput{

        }
        #alertButtonFoot{
            width: 100%;
            float: left;
            margin-left: 2%;
            margin-top: 2%;
            margin-bottom: 3%;
        }
        #alertSelectImg{

        }
        #alertSubmit{
            margin-left: 5%;
        }
    </style>
</head>
<body>
<div id="div">
    <c:if test="${empty requestScope.commodityViews}">
        <h2>发布商品</h2>
        <form  enctype="multipart/form-data" action="/commodity/add" method="post" accept-charset="utf-8">
            <input type="text" id ="sender" style="display: none" name="sender" value="${sessionScope.account.id}">
            <div id="headFont">
                <div id="typeFont">
                    <span>类型：</span>
                    <select id="type" name="cType">
                        <option class="numberCode" value="1">电脑</option>
                        <option class="numberCode" value="2">手机</option>
                    </select>
                </div>
                <div id="signFont">
                    <span>品牌：</span>
                    <select class="position" name="signDescribes">
                        <option>--请选择--</option>
                    </select>
                </div>
            </div>

            <div id="inputBody">
                <div id="nameInput">
                    <span>名称：</span>
                    <input type="text" name="cName"><br>
                </div>
                <div id="priceInput">
                    <span>价格：</span>
                    <input type="text" name="price">
                </div>
            </div>

            <div id="imgFoot">
                <span>图片：</span>
                <img id="imgShow" width="100px" height="100px">
                <input type="file"  name="sendImg" class="file" style="display: none" onchange="getObjectURL(this)">
                <button type="button" id="selectImg" onclick="clickButton('file')">选择图片</button>

            </div>
            <input id="state" value="${sessionScope.account.state}">
            <input type="submit" id="submit" value="上传">
        </form>
    </c:if>

    <c:if test="${!empty requestScope.commodityViews}">
        <h2>修改商品</h2>
        <c:forEach items="${requestScope.commodityViews}" var="result">

            <div id="alertDiv">
                <form enctype="multipart/form-data" action="/commodity/submitAlert" method="post" accept-charset="utf-8">

                    <div id="alertImgHead">
                        <p>图片：</p>
                        <img  src="/commodity/showPicture?cId=${result.cId}"  class="imgShow" width="100px" height="100px">
                    </div>

                    <div id="alertInputBody">
                        <div id="alertNameInput">
                            <input type="text" name="cId" style="display: none" value="${result}">
                            <p>名称：</p>
                            <input type="text" name="cName" value="${result.cName}">
                        </div>
                        <div id="alertPriceInput">
                            <p>价格：</p>
                            <input type="text" name="price" value="${result.price}">
                        </div>
                    </div>

                    <div id="alertButtonFoot">
                        <input type="file"  name="sendImg"  class="file" style="display: none" onchange="getObjectURL(this)">
                        <button  type="button" id="alertSelectImg" onclick="clickButton('file')">选择图片</button>
                        <input type="submit" id="alertSubmit" value="提交修改">
                    </div>

                </form>
            </div>

        </c:forEach>
    </c:if>

</div>

</body>
</html>
