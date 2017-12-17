<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <!--<script src="/static/js/jquery.js"></script>-->
    <link href="static/plugins/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script src="static/plugins/jquery-2.1.4/jquery.js"></script>

    <script type="text/javascript">
        /**
         * 事件代理：  如果不用事件代理  动态添加的qqq是没有绑定的
         * 而通过事件代理，则满足了其子元素再怎么动态都是可以绑定的，
         * document可以缩小范围
         * 变成任意你要动态添加的元素的父元素，
         * 但是这个父元素不能是动态添加的。
         */
        $(document).on('dblclick','.qqq',function () {
            alert("123");
        });

    </script>
    <script type="text/javascript">
        $(function () {
            $("#loadStudentBtn").click(function () {
                //发送ajax
                $.ajax({
                    url: "/ajax.do",
                    type: "post",
                    dataType: "json",
                    success: function (result) {
                        //清除原有table_list列表
                        $("#table_list").empty();
                        //alert("123");
                        //result是服务器返回的Json字符串转成的js
                        for(var i=0;i<result.length;i++) {
                            var id = result[i].id;
                            var name = result[i].name;
                            //拼成li
                            var s_li = "<th>"+name+"</th>";
                            var $li = $(s_li); //将字符串转成jquery

                            $li.data("noteId",id); //将id值藏到$li中
                            //将$li添加到ul列表中
                            $("#table_list").append($li);
                        }
                    }
                });
            });
        });
    </script>

    <script type="text/javascript">
        $(function () {
            $("#showStudentBtn").click(function () {
                //发送ajax
                $.ajax({
                    url: "/ajax.do",
                    type: "post",
                    dataType: "json",
                    success: function (result) {
                        //alert("123");
                        //result是服务器返回的Json字符串转成的js

                        for(var i=0;i<result.length;i++) {
                            var id = result[i].id;
                            var name = result[i].name;
                            //拼成li

                            var s_li =  "<tr>"
                                +   "<td><span class=\"qqq\">"+name+"</span></td>"
                                +   "<td>"+id+"</td>"
                                +   "</tr>";
                            var $li = $(s_li); //将字符串转成jquery

                            $li.data("noteId",id); //将id值藏到$li中
                            //将$li添加到ul列表中
                            $("#student_list").append($li);
                        }

                    }
                });
            });
        });
    </script>

</head>

<body>

<div class="row">
    <div class="col-md-4">
        <div class="btn-group-vertical" role="group" aria-label="Vertical button group" >
            <button type="button" id="loadStudentBtn" class="btn btn-default">显示学生列表</button>
            <button type="button" id="showStudentBtn" class="btn btn-default">显示学生信息</button>
        </div>
    </div>

    <div class="col-md-8">
        <div>
            <!--可动态显示-->
            <form class="form-inline">
                <div class="form-group">
                    <label for="exampleInputName2">ID</label>
                    <input type="text" class="form-control" id="exampleInputName2" placeholder="ID">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail2">Name</label>
                    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Name">
                </div>
                <br>
                <button type="submit" class="btn btn-default">增</button>
                <button type="submit" class="btn btn-default">删</button>
                <button type="submit" class="btn btn-default">改</button>
            </form>
        </div>
        <br>
        <br>
        <div>
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
    </div>
</div>
</body>




</html>



