<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/webbase.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pages-seckillOrder.css">
    <title>地址管理</title>

</head>
<body>
<!--引入头部-->
<%@include file="header.jsp" %>
<div class="container-fluid">
    <!--header-->
    <div id="account">
        <div class="py-container">
            <div class="yui3-g home">
                <!--左侧列表-->
                <%@include file="home_left.jsp" %>
                <!--右侧主内容-->
                <div class="yui3-u-5-6 order-pay">
                    <div class="body userAddress">
                        <div class="address-title">
                            <span class="title">地址管理</span>
                            <a data-toggle="modal" data-target="#addressModel" data-keyboard="false"
                               class="sui-btn  btn-info add-new">添加新地址</a>
                            <span class="clearfix"></span>
                        </div>
                        <div class="address-detail">
                            <table class="sui-table table-bordered">
                                <thead>
                                <tr>
                                    <th>姓名</th>
                                    <th>地址</th>
                                    <th>联系电话</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${addressList}" var="address">
                                    <tr>
                                        <td>${address.contact}</td>
                                        <td>${address.address}</td>
                                        <td>${address.telephone}</td>
                                        <td>
                                            <input type="button" data-toggle="modal" data-target="#edit" data-keyboard="false" οnclick="Values('${address}')" value="编辑"/>
                                            <a href="${pageContext.request.contextPath}/AddressServlet?action=deleteByAid&aid=${address.aid}">删除</a>
                                            <c:if test="${address.isdefault==0}">
                                                <a href="${pageContext.request.contextPath}/AddressServlet?action=setAsDefault&aid=${address.aid}">设为默认</a>
                                            </c:if>
                                            <c:if test="${address.isdefault==1}">
                                                <span style="color:#F00">默认地址</span>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>

                        <!-- 地址模态框 -->
                        <div class="modal fade" id="addressModel" tabindex="-1" role="dialog"
                             aria-labelledby="loginModelLable">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <%-- 新增地址--%>
                                    <div class="tab-pane fade in active">
                                        <form id="new" action="${pageContext.request.contextPath}/AddressServlet"
                                              method="post">
                                            <input type="hidden" name="action" value="save">
                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <label>姓名</label>
                                                    <input type="text" class="form-control" name="contact"
                                                           placeholder="姓名">
                                                </div>
                                                <div class="form-group">
                                                    <label>地址</label>
                                                    <input type="text" class="form-control" name="address"
                                                           placeholder="请输入地址">
                                                </div>
                                                <div class="form-group">
                                                    <label>联系电话</label>
                                                    <input type="text" class="form-control" name="telephone"
                                                           placeholder="联系电话">
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <input type="button" class="btn btn-default" data-dismiss="modal"
                                                       value="关闭">
                                                <input type="submit" class="btn btn-primary" value="保存"/>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 地址模态框（编辑用） -->
                        <div class="modal fade" id="edit" tabindex="-1" role="dialog"
                             aria-labelledby="loginModelLable">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <%-- 更改地址--%>
                                    <div class="tab-pane fade in active">
                                        <form id="update" action="${pageContext.request.contextPath}/AddressServlet"
                                              method="post">
                                            <input type="hidden" name="action" value="editByAid">
                                            <input type="hidden" id="aid" name="aid" value="">
                                            <script>
                                                $("#edit").modal("hide"); // 绑定模拟框id
                                                function values(msg) {
                                                    $("#aid").val(msg); // 往带aid标签的input里传入定义好的值
                                                }
                                            </script>
                                            <div class="modal-body">
                                                <div class="form-group">
                                                    <label>姓名</label>
                                                    <input type="text" id="test" class="form-control" name="contact"
                                                           placeholder="姓名">
                                                </div>
                                                <div class="form-group">
                                                    <label>地址</label>
                                                    <input type="text" class="form-control" name="address"
                                                           placeholder="请输入地址">
                                                </div>
                                                <div class="form-group">
                                                    <label>联系电话</label>
                                                    <input type="text" class="form-control" name="telephone"
                                                           placeholder="联系电话">
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <input type="button" class="btn btn-default" data-dismiss="modal"
                                                       value="关闭">
                                                <input type="submit" class="btn btn-primary" value="保存"/>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!--引入尾部-->
<%@include file="footer.jsp" %>
</body>
</html>
