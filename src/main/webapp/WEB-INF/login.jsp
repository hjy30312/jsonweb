
<%@ page  language="java" pageEncoding="utf-8" %>
<%String path = request.getContextPath();%>

<html>
<head>
    <title>Login Page | Amaze UI Example</title>
    <script src="https://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/amazeui/2.7.2/css/amazeui.css" rel="stylesheet">
    <style>
        .header {
            text-align: center;
        }
        .header h1 {
            font-size: 200%;
            color: #333;
            margin-top: 30px;
        }
        .header p {
            font-size: 14px;
        }
    </style>

</head>
<body>

<div class="header">
    <div class="am-g">
        <h1>Web ide</h1>
    </div>
    <hr />
</div>
<div class="am-g">
    <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
        <h3>登录</h3>
        <hr>
        <form action="<%=path%>/User/LoginServlet" method="post" class="am-form" onsubmit="return checkLoginForm()">
            <span style="color: #FF0000;">${msg}</span>
            <br>
            <label for="username">账号:</label>
            <input type="text" name="username" id="username"/>
            <br>
            <label for="password">密码:</label>
            <input type="password" name="password" id="password"/>

            <div class="am-cf">
                <input type="submit"  id="submit" value="登 录"  class="am-btn am-btn-primary am-btn-sm am-fl">
            </div>
        </form>
        <form action="<%=path%>/toregister" method="post" class="am-form">
            <input type="submit"  value ="没有帐号？点击注册">
        </form>
        <hr>
        <p>© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
    </div>
</div>
</body>

<script>
    function checkLoginForm() {
        var username = $('#username').val();
        var password = $('#password').val();
        if(isNull(username) && isNull(password)){
            $('#submit').attr('value','请输入账号和密码!!!').css('background','red');
            return false;
        }
        if(isNull(username)){
            $('#submit').attr('value','请输入账号!!!').css('background','red');
            return false;
        }
        if(isNull(password)){
            $('#submit').attr('value','请输入密码!!!').css('background','red');
            return false;
        }
        else {
            return true;
        }
    }
    //未定义的值和定义未赋值的为undefined
    function isNull(input) {
        if (input == null || input =='' || (typeof(input) == "undefined")) {
            return true;
        } else {
            return false;
        }
    }

</script>
</html>
