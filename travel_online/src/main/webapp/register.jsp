<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
</head>
<body>
<!--引入头部-->
<%@include file="header.jsp" %>
<!-- 头部 end -->
<div class="rg_layout">
    <div class="rg_form clearfix">
        <%--左侧--%>
        <div class="rg_form_left">
            <p>新用户注册</p>
            <p>USER REGISTER</p>
        </div>
        <div class="rg_form_center">
            <!--注册表单-->
            <form id="registerForm" action="${pageContext.request.contextPath}/UserServlet" method="post">
                <!--提交处理请求的标识符-->
                <input type="hidden" name="action" value="register"><!--隐藏域-->
                <table style="margin-top: 25px;width: 558px">
                    <tr>
                        <td class="td_left">
                            <label for="username">用户名</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="username" name="username" placeholder="请输入账号">
                            <span id="userInfo" style="font-size:15px"></span>
                        </td>
                        <script>
                            // 用户名绑定失去焦点事件
                            $('#username').blur(function () {

                                // 获取用户输入的value值
                                let username = $(this).val();
                                // 即时测试
                                // alert(username);

                                // ajax请求
                                let url = '${pageContext.request.contextPath}/UserServlet';
                                // 隐藏域可以放到url里(加?)，比较规范的是放到data里(加&)
                                let data = 'action=findByUsername&username=' + username;
                                $.post(url, data, function (resp) {
                                    // resp 就是返回的json对象（对应的java类就是ResultInfo）
                                    if (resp.success) {
                                        $('#userInfo').css('color', 'green').html('√ 可以使用');
                                    } else {
                                        $('#userInfo').css('color', 'red').html('× 已存在');
                                    }
                                });
                            });
                        </script>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="telephone">手机号</label>
                        </td>
                        <td class="td_right">
                            <input type="text" id="telephone" name="telephone" placeholder="请输入您的手机号">
                            <span id="telephoneInfo" style="font-size:15px"></span>
                        </td>
                        <script>
                            // 用户名绑定失去焦点事件
                            $('#telephone').blur(function () {

                                // 获取用户输入的value值
                                let telephone = $(this).val();
                                // 即时测试
                                // alert(telephone);

                                // ajax请求
                                let url = '${pageContext.request.contextPath}/UserServlet';
                                // 隐藏域可以放到url里(加?)，比较规范的是放到data里(加&)
                                let data = 'action=findByTelephone&telephone=' + telephone;
                                $.post(url, data, function (resp) {
                                    // resp 就是返回的json对象（对应的java类就是ResultInfo）
                                    if (resp.success) {
                                        $('#telephoneInfo').css('color', 'green').html('√ 可以使用');
                                    } else {
                                        $('#telephoneInfo').css('color', 'red').html('× 已存在');
                                    }
                                });
                            });
                        </script>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="password">密码</label>
                        </td>
                        <td class="td_right">
                            <input type="password" id="password" name="password" placeholder="请输入密码">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                            <label for="smsCode">验证码</label>
                        </td>
                        <td class="td_right check">
                            <input type="text" id="smsCode" name="smsCode" class="check" placeholder="请输入验证码">

                            <input id="sendSmsCode" value="发送手机验证码" class="btn btn-link"/><%--disabled="disabled"--%>
                            <script>
                                // 验证码绑定点击事件
                                $('#sendSmsCode').click(function () {

                                    // 获取用户输入的手机号
                                    let telephone = $('#telephone').val();
                                    // alert(telephone);

                                    // 发送ajax请求
                                    let url = '${pageContext.request.contextPath}/UserServlet';
                                    let data = 'action=sendSms&telephone=' + telephone;// SMS(Short Messaging Service)
                                    $.post(url, data, function (resp) {
                                        alert(resp.message);
                                    });

                                    // 调用倒计时函数
                                    countDown(this);
                                });

                                // 按钮倒计时
                                let numRegister = 10; // 声明变量时不能与header.jsp的变量有冲突，否则报错

                                function countDown(obj) {
                                    numRegister--;
                                    if (numRegister <= 0) { // 可以发送短信
                                        $(obj).prop("disabled", false); // 按钮可用
                                        $(obj).val("重新发送短信"); // 提示信息
                                        numRegister = 10; // 重置时间
                                    } else { // 不可以发送短信，重置按钮时间
                                        $(obj).prop("disabled", true); // 按钮不可用
                                        $(obj).val(numRegister + "秒后，可发送短信"); // 提示信息

                                        // 一次性计时器
                                        setTimeout(function () {
                                            // 递归调用
                                            countDown(obj);
                                        }, 1000);
                                    }
                                }
                            </script>
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left">
                        </td>
                        <td class="td_right check">
                            <input type="submit" class="submit" value="注册">
                            <span id="msg" style="color: red;">${resultInfo.message}</span>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <%--右侧--%>
        <div class="rg_form_right">
            <p>
                已有账号？
                <a href="javascript:$('#loginBtn').click()">立即登录</a>
            </p>
        </div>
    </div>
</div>
<!--引入尾部-->
<%@include file="footer.jsp" %>


</body>
</html>
