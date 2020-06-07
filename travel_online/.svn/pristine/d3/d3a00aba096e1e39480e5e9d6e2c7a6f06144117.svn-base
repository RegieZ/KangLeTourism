<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/webbase.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pages-weixinpay.css">
    <title>微信支付</title>
    <script src="${pageContext.request.contextPath}/js/qrcode.min.js"></script>

</head>
<body>
<!--引入头部-->
<%@include file="header.jsp" %>
<div class="container-fluid">
    <div class="cart py-container">
        <!--主内容-->
        <div class="checkout py-container  pay">
            <div class="checkout-tit">
                <h4 class="fl tit-txt"><span class="success-icon"></span><span
                        class="success-info">订单提交成功，请您及时付款！订单号：${oid}</span></h4>
                <span class="fr"><em class="sui-lead">应付金额：</em><em class="orange money">￥${price}</em>元</span>
                <div class="clearfix"></div>
            </div>
            <div class="checkout-steps">
                <div class="fl weixin">微信支付</div>
                <div class="fl sao">
                    <p class="red" style="padding-bottom: 40px">二维码已过期，刷新页面重新获取二维码。</p>
                    <div class="fl code">
                        <%--默认二维码标签--%>
                        <%--<img src="img/erweima.png" alt="">--%>
                        <div id="qrCode"></div>
                        <script>
                            let qrCode = new QRCode('qrCode', '${pay_url}');
                        </script>
                        <div class="saosao">
                            <p>请使用微信扫一扫</p>
                            <p>扫描二维码支付</p>
                        </div>
                    </div>
                    <div class="fl"
                         style="background:url(./img/phone-bg.png) no-repeat;width:350px;height:400px;margin-left:40px">

                    </div>

                </div>
                <div class="clearfix"></div>
            </div>
        </div>

    </div>
</div>
<script>
    // 每间隔5秒查询支付状态
    setInterval(function () {
        // 发送ajax请求
        let url = '${pageContext.request.contextPath}/OrderServlet';
        let data = 'action=findState&oid=${oid}';
        $.post(url, data, function (resp) {
            if (resp.success) {
                // 支付成功
                location.href = '${pageContext.request.contextPath}/pay_success.jsp';
            }
        })
    }, 5000);

    // 用户一直没有支付
    setTimeout(function () {
        location.href = '${pageContext.request.contextPath}/pay_fail.jsp';
    }, 20000);/*这里设置的是20秒，根据PayUtils里的配置，应该是10分钟*/
</script>
<!--引入尾部-->
<%@include file="footer.jsp" %>
</body>
</html>
