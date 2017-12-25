
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <script type="text/javascript">
        $(function () {
            $("#productList").click(function () {
                $.ajax({
                    url: "/productList.do",
                    type: "post",
                    dataType: "json",
                    success: function (result) {
                        var json = eval(result);

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
                            +   "<td><span class=\"qqq\">{#id#}</span></td>"
                            +   "<td>{#name#}</td>"
                            +   "<td>{#value#}</td>"
                            +   "<td>{#function#}</td>"
                            +   "</tr>";
                        var element = format(html, json);
                        $("#product_list").append(element);
                    }
                });
            });
        });
    </script>

    <script type="text/javascript">
        $(function () {
            $("#productList").click(function () {
                //发送ajax
                $.ajax({
                    url: "/commodity.do",
                    type: "post",
                    success: function (result) {
                        var json = eval(result);
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
                            + "<td>"
                            + "<button class='btn btn-default' type='button' onclick='InsetShoppingCart({#id#})' >添加</button>"
                            + "</td>"
                            + "</tr>";
                        var element = format(html, json);
                        $("#commodity").append(element);
                    }
                })
            });
        })
    </script>

    <script type="text/javascript">
        $(function () {
            $("#ShoppingCart").click(function () {
                //发送ajax
                $.ajax({
                    url: "/ShoppingCartHead",
                    type: "post",
                    success: function (result) {
                        var json = eval(result);
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
                            + "<td>"
                            + "<button class='btn btn-default' type='button' onclick='InsetShoppingCart({#id#})' >添加</button>"
                            + "</td>"
                            + "</tr>";
                        var element = format(html, json);
                        $("#commodity").append(element);
                    }
                })
            });
        })
    </script>






</head>
<body>
<div class="row">
    <!-- 功能信息表-->
    <div class="col-md-3">
        <div class="btn-group-vertical" role="group" aria-label="Vertical button group" >
            <button type="button" id="productList" class="btn btn-default">商品列表</button>
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
            <thead id="product_list">
            <!--表头-->

            </tr>
            </thead>

            <!--内容-->
            <tbody id="commodity">

            </tbody>

        </table>
    </div>

    <!--右边上面的部分为详细信息-->
    <div class="col-md-4">

    </div>
    <!--右边下面为购物车-->
</div>

</body>
</html>