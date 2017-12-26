
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

    <script>
        function InsetShoppingCart(id) {
            $.ajax({
                url:"/User/InsertShoppingCartServlet?id=" + id,
                type: "post",
                success:function () {
                    alert("添加成功！");
                },
                error:function () {
                    alert("添加失败！");
                }
            });
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
                        $("#head").empty();
                        var json = eval(result);

//                        var format = function (str, data) {
//                            var html = '';
//                            if (data instanceof Array) {
//                                for (var i = 0, len = data.length; i < len; i++) {
//                                    html += arguments.callee(str, data[i]);
//                                }
//                                return html;
//                            } else {
//                                return str.replace(/{#(\w+)#}/g, function (match, key) {
//                                    return typeof data === 'string' ? data : (typeof data[key] === 'undefined' ? '' : data[key]);
//                                });
//                            }
//                        };
                        
                        var html = "<tr>"
                            +   "<td><span class=\"qqq\">{#id#}</span></td>"
                            +   "<td>{#name#}</td>"
                            +   "<td>{#value#}</td>"
                            +   "<td>{#manufacturer#}</td>"
                            +   "<td>{#describe#}</td>"
                            +   "<td>{#functions#}</td>"
                            +   "</tr>";
                        var element = format(html, json);
                        $("#head").append(element);
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
                        $("#content").empty();
                        /**
                         * 拼接字符串模板
                         */
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
                        var html = "<tr>"
                            + "<td><span class='qqq'>{#id#}</span></td>"
                            + "<td>{#name#}</td>"
                            + "<td>{#value#}</td>"
                            + "<td>{#manufacturer#}</td>"
                            + "<td>{#describe#}</td>"
                            + "<td>"
                            + "<button class='btn btn-default' type='button' onclick='InsetShoppingCart({#id#})' >添加购物车</button>"
                            + "</td>"
                            + "</tr>";
                        var element = format(html, json);
                        $("#content").append(element);
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
                        $("#head").empty();
                        /**
                         * 拼接字符串模板
                         */
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
                        var html = "<tr>"
                            + "<td><span class='qqq'>{#id#}</span></td>"
                            + "<td>{#user_id#}</td>"
                            + "<td>{#commodity_id#}</td>"
                            + "<td>{#values#}</td>"
                            + "<td>{#functions#}</td>"
                            + "</tr>";
                        var element = format(html, json);
                        $("#head").append(element);
                    }
                })
            });
        })
    </script>
    <!--拼接购物车内容-->
    <script type="text/javascript">
        $(function () {
            $("#ShoppingCart").click(function () {
                //发送ajax
                $.ajax({
                    url: "/cartList",
                    type: "post",
                    dataType: "json",
                    success: function (result) {
                        var json = eval(result);
                        $("#content").empty();
                        /**
                         * 拼接字符串模板
                         */
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
                        var html = "<tr>"
                            + "<td><span class='qqq'>{#id#}</span></td>"
                            + "<td>{#user_id#}</td>"
                            + "<td>{#commodity_id#}</td>"
                            + "<td>{#value#}</td>"
                            + "<td>"
                            + "<button class='btn btn-default' type='button' onclick='InsetShoppingCart({#id#})' >付款</button>"
                            + "</td>"
                            + "</tr>";
                        var element = format(html, json);
                        $("#content").append(element);
                    }
                })
            });
        })
    </script>
    <!--拼接个人信息内容-->

</head>
<body>
<div class="row">
    <!-- 功能信息表-->
    <div class="col-md-3">
        <div class="btn-group-vertical" role="group" aria-label="Vertical button group" >
            <button type="button" id="CommodityList" class="btn btn-default">商品列表</button>
            <br>
            <button type="button" id="ShoppingCart" class="btn btn-default">购物车</button>
            <br>
            <button type="button" id="OrderInformation" class="btn btn-default">订单信息</button>
            <br>
            <button type="button" id="n" class="btn btn-default">个人信息</button>
        </div>
    </div>
    <!--左边为商品信息-->
    <div class="col-md-5">
        <table class="table table-hover table-bordered">

            <!--动态显示 -->
            <thead id="head">
            <!--表头-->

            </tr>
            </thead>

            <!--内容-->
            <tbody id="content">

            </tbody>

        </table>
    </div>

    <!--右边上面的部分为详细信息
    <div class="col-md-4">

    </div>
    <!--右边下面为购物车-->
</div>

</body>
</html>