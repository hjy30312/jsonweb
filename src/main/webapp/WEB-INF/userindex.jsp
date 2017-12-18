
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
<!--
    <script type="text/javascript">
        $(function () {
            $("#productList").click(function () {
                $.ajax({
                    url: "/productList.do",
                    type: "post",
                    dataType: "json",
                    success: function (result) {
                        for(var i=0; i<result.length;i++) {
                            var id = result[i].id;
                            var name = result[i].name;
                            var manufacturer = result[i].manufacturer;
                            var describe = result[i].describe;

                            //拼成li
                            var s_li = "<tr>"
                                +   "<td><span class=\"qqq\">"+id+"</span></td>"
                                +   "<td>" +name+"</td>"
                                +   "<td>" +manufacturer+"</td>"
                                +   "<td>" +describe+"</td>"
                                +   "</tr>";
                            var $li = $(s_li); //将字符串转成jquery
                            //将$li添加到ul列表中
                            $("#product_list").append($li);
                        }
                    }
                })
            })
        })
    </script>
    -->
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
            <thead>
            <!--表头-->
            <tr id="product_list">

            </tr>
            </thead>
            <!--内容-->
            <tbody id="products">

            </tbody>
        </table>
    </div>

    <!--右边上面的部分为详细信息-->
    <div class="col-md-5">
        <table class="table table-hover table-bordered">
            <!--动态显示-->
            <thead>
            <tr id="table_list">
            </tr>
            </thead>
            <tbody  id="student_list">

            </tbody>
        </table>
    </div>
    <!--右边下面为购物车-->
</div>

</body>
</html>
