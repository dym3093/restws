<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="<c:url value="/script/jquery2.0.3/jquery-2.0.3.js"/>"></script>
</head>
<body>
<br/><br/><br/>
用户姓名：<input type="text" id="username" />
用户密码：<input type="text" id="password" />
用户性别：<input type="text" id="gender"/>
<input type="button" value="推送用户信息" id="pushUser" />

<br/><br/><br/>
新闻标题：<input type="text" id="title" />
新闻内容：<input type="text" id="content" />
新闻路径：<input type="text" id="url" />
新闻作者：<input type="text" id="author" />
<input type="button" value="推送新闻信息" id="pushNews" />


<br/><br/><br/>
客户姓名：<input type="text" id="name" />
客户地址：<input type="text" id="address" />
客户手机：<input type="text" id="mobile" />
<input type="button" value="推送客户信息" id="pushClient" />

<script type="text/javascript">
    $(function () {
    });

    $("#pushUser").click(function(){
        var data = {
            username : $("#username").val(),
            password : $("#password").val(),
            sex      : $("#gender").val()
        };
        ajaxDo("/push/user",data);
    });
    $("#pushNews").click(function(){
        var data = {
            title    : $("#title").val(),
            content  : $("#content").val(),
            author   : $("#author").val(),
            url      : $("#url").val()
        };
        ajaxDo("/push/news",data);
    });
    $("#pushClient").click(function(){
        var data = {
            name     : $("#name").val(),
            address  : $("#address").val(),
            mobile   : $("#mobile").val()
        };
        ajaxDo("/push/client",data);
    });

    function ajaxDo(url,data){
        $.ajax({
            url: url,
            type: "post",
            dataType: "json",
            data: data,
            success:function(result){
                if(result.success){
                    var obj = JSON.stringify(result.data);
                    alert(obj);
                }else{
                    alert(result.message);
                }
            }
        });
    }

</script>

</body>
</html>