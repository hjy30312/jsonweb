
<%@ page  language="java" pageEncoding="utf-8" %>
<html>
<head>
    <script src="https://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.css" rel="stylesheet">
    <script>
        $(document).on('dblclick','.qqq',function () {
            alert("123");
        });
    </script>
    <!--字符串拼接模板-->
    <script>
        var format = function (str, data) {
            var html = '';
            if (data instanceof Array) {
                for (var i = 0, len = data.length; i < len; i++) {
                    html += arguments.callee(str, data[i]);
                }
                return html;
            } else {
                return str.replace(/{#(\w+)#}/g, function (match, key) {
                    return typeof data === 'string' ? data : (typeof data[key] === 'undefined' ? '' : data[key]);
                });
            }
        };


    </script>
    <!--加入购物车-->
    <script>
        function InsetShoppingCart(id,value) {
            $.ajax({
                url:"/User/InsertShoppingCartServlet?id=" + id + "&value=" + value,
                type: "post",
                success:function () {
                    alert("添加成功！");
                },
                error:function () {
                    alert("添加失败！");
                }
            });
            CartContent();
        }
    </script>
    <!--修改密码-->
    <script>
        function UpdatePassword(id) {
            var oldPassword = $("#oldPassword")[0].value;
            var newPassword = $("#newPassword1")[0].value;
            var renewPassword = $("#newPassword2")[0].value;
            $("#oldPassword")[0]="";
            $("#newPassword1")[0]="";
            $("#newPassword2")[0]="";
            if(!(newPassword === renewPassword)) {
                alert("前后密码不一致！");
            } else {
                $.ajax({
                    url:"/User/UserUpdateServlet?newPassword=" + newPassword +"&oldPassword=" + oldPassword,
                    type: "post",
                    success:function () {
                        alert("修改成功！");
                    },
                    error:function () {
                        alert("修改失败！");
                    }
                });
            }
        }
    </script>
    <!--付款-->
    <script>
        function Payment(commodity_id,value) {
            $.ajax({
                url:"/User/PaymentServlet?commodity_id=" + commodity_id +"&value=" + value,
                type: "post",
                success:function () {
                    alert("付款成功！");
                },
                error:function () {
                    alert("付款失败！");
                }
            });

        }
    </script>
    <!--通过购物车id删除购物车-->
    <script>
        function DeleteCart(id) {

            $.ajax({
                url:"/User/DeleteCartServlet?id=" + id,
                type: "post",
                success:function () {
                    alert("删除成功！");
                },
                error:function () {
                    alert("删除失败！");
                }
            });
            CartContent();
        }
    </script>
    <!--显示购物车内容-->
    <script>
        function CartContent() {
            $.ajax({
                url: "/cartList",
                type: "post",
                dataType: "json",
                success: function (result) {
                    var json = eval(result);
                    $("#rightcontent").empty();

                    var html = "<tr>"
                        + "<td><span class='qqq' id='cartid' >{#id#}</span></td>"
                        + "<td id='commodity_id'>{#commodity_id#}</td>"
                        + "<td id='value'>{#value#}</td>"
                        + "<td>"
                        + "<button class='btn btn-default' type='button' onclick='Payment({#commodity_id#},{#value#})' >付款</button>"
                        + "<button class='btn btn-default' type='button' onclick='DeleteCart({#id#})' >删除</button>"
                        + "</td>"
                        + "</tr>";
                    var element = format(html, json);
                    $("#rightcontent").append(element);
                }
            })
        }
    </script>

    <!--拼接商品列表头部-->
    <script type="text/javascript">
        $(function () {
            $("#CommodityList").click(function () {
                $.ajax({
                    url: "/CommodityHead",
                    type: "post",
                    dataType: "json",
                    success: function (result) {
                        $("#lefthead").empty();
                        var json = eval(result);

                        var html = "<tr>"
                            +   "<td><span class=\"qqq\">{#id#}</span></td>"
                            +   "<td>{#name#}</td>"
                            +   "<td>{#value#}</td>"
                            +   "<td>{#manufacturer#}</td>"
                            +   "<td>{#describe#}</td>"
                            +   "<td>{#functions#}</td>"
                            +   "</tr>";
                        var element = format(html, json);
                        $("#lefthead").append(element);
                    }
                });
            });
        });
    </script>
    <!--拼接商品列表内容-->
    <script type="text/javascript">
        $(function () {
            $("#CommodityList").click(function () {
                //发送ajax
                $.ajax({
                    url: "/commodityList",
                    type: "post",
                    dataType: "json",
                    success: function (result) {
                        var json = eval(result);
                        $("#leftcontent").empty();

                        var html = "<tr>"
                            + "<td><span class='qqq'>{#id#}</span></td>"
                            + "<td>{#name#}</td>"
                            + "<td>{#value#}</td>"
                            + "<td>{#manufacturer#}</td>"
                            + "<td>{#describe#}</td>"
                            + "<td>"
                            + "<button class='btn btn-default' type='button' onclick='InsetShoppingCart({#id#},{#value#})' >加入购物车</button>"
                            + "</td>"
                            + "</tr>";
                        var element = format(html, json);
                        $("#leftcontent").append(element);
                    }
                })
            });
        })
    </script>
    <!--拼接购物车头部-->
    <script type="text/javascript">
        $(function () {
            $("#ShoppingCart").click(function () {
                //发送ajax
                $.ajax({
                    url: "/ShoppingCartHead",
                    type: "post",
                    dataType: "json",
                    success: function (result) {
                        var json = eval(result);
                        $("#righthead").empty();

                        var html = "<tr>"
                            + "<td><span class='qqq'>{#id#}</span></td>"
                            + "<td>{#commodity_id#}</td>"
                            + "<td>{#value#}</td>"
                            + "<td>{#functions#}</td>"
                            + "</tr>";
                        var element = format(html, json);
                        $("#righthead").append(element);
                    }
                })
            });
        })
    </script>
    <!--拼接购物车内容-->
    <script type="text/javascript">
        $(function () {
            $("#ShoppingCart").click(function () {
                CartContent();
            });
        });
    </script>
    <!--拼接修改密码头部-->
    <script type="text/javascript">
        $(function () {
            $("#UpdatePassword").click(function () {
                //发送ajax
                $.ajax({
                    url: "/User/UpdatePasswordHeadServlet",
                    type: "post",
                    dataType: "json",
                    success: function (result) {
                        var json = eval(result);
                        $("#lefthead").empty();
                        $("#righthead").empty();

                        var html = "<tr>"
                            + "<td><span class='qqq'>{#oldPassword#}</span></td>"
                            + "<td>{#newPassword1#}</td>"
                            + "<td>{#newPassword2#}</td>"
                            + "<td></td>"
                            + "</tr>";
                        var element = format(html, json);
                        $("#lefthead").append(element);
                    }
                })
            });
        })
    </script>
    <!--拼接修改密码内容-->
    <script type="text/javascript">
        $(function () {
            $("#UpdatePassword").click(function () {
                $("#leftcontent").empty();
                $("#rightcontent").empty();
                var html = "<tr>"
                    + "<td><input type=\"text\" class=\"input\" id=\"oldPassword\" name=\"oldPassword\"  /></td>"
                    + "<td><input type=\"text\" class=\"input\" id=\"newPassword1\" name=\"newPassword1\"  /></td>"
                    + "<td>"
                    +  "<input type=\"text\" class=\"input\" id=\"newPassword2\" name=\"newPassword2\"  />"
                    + "</td>"
                    + "<td>"
                    + "<button class='btn btn-default' type='button' onclick='UpdatePassword()' >确定</button>"
                    + "</td>"
                    + "</tr>";
                $("#leftcontent").append(html);
            });
        })
    </script>
</head>
<body>

<header class="navbar navbar-static-top bs-docs-nav" id="top">
</header>
<div class="row">
    <div class="col-md-1">

    </div>
    <!-- 功能信息表-->
    <div class="col-md-1">

        <div class="btn-group-vertical" role="group" aria-label="Vertical button group" >
            <button type="button" id="CommodityList" class="btn btn-default">商品列表</button>
            <br>
            <button type="button" id="ShoppingCart" class="btn btn-default">购物车</button>
            <br>
            <button type="button" id="OrderInformation" class="btn btn-default">订单信息</button>
            <br>
            <button type="button" id="UpdatePassword" class="btn btn-default">修改密码</button>
        </div>
    </div>
    <div class="col-md-0.5">

    </div>
    <!--左边为商品信息-->
    <div class="col-md-4">
        <table class="table table-hover table-bordered table-striped table-condensed">

            <!--动态显示 -->
            <thead id="lefthead">
            <!--表头-->

            </tr>
            </thead>

            <!--内容-->
            <tbody id="leftcontent">

            </tbody>

        </table>
    </div>
    <div class="col-md-0.5">

    </div>
    <!--右边为购物车-->
    <div class="col-md-4">
        <table class="table table-hover table-bordered table-striped table-condensed">

            <!--动态显示 -->
            <thead id="righthead">
            <!--表头-->

            </tr>
            </thead>

            <!--内容-->
            <tbody id="rightcontent">

            </tbody>

        </table>
    </div>
    <!--右边下面为购物车-->
    <div class="col-md-1">

    </div>
</div>

</body>
</html>
