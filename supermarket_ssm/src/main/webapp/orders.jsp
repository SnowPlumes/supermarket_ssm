<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>QK商城 - 后台管理系统</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/admin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<a class="navbar-brand" href="index.jsp">QK商城 - 后台管理系统</a>
		</div>
		<!-- Top Menu Items -->
		<ul class="nav navbar-right top-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"><i class="fa fa-user"></i>
					${sessionScope.employee.name } <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="personal-info.jsp"><i
							class="fa fa-fw fa-user"></i>个人信息</a></li>
					<li class="divider"></li>
					<li><a href="login.html"><i class="fa fa-fw fa-power-off"></i>退出登陆</a>
					</li>
				</ul></li>
		</ul>
		<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav side-nav">
				<li><a href="personal-info.jsp"><i
						class="fa fa-fw fa-table"></i>个人信息</a></li>
				<li><a href="password.jsp"><i class="fa fa-fw fa-table"></i>修改密码</a>
				</li>
				<!-- <li><a href="employeeManager.action"><i
						class="fa fa-fw fa-table"></i>员工管理</a></li> -->
				<c:if test="${sessionScope.employee.employeeLimit.level == 'A' }">
					<li><a href="employeeManager.action" id="employeeManager"><i
							class="fa fa-fw fa-table"></i>员工管理</a></li>
				</c:if>
				<li><a href="showGoods.action"><i class="fa fa-fw fa-table"></i>商品管理</a>
				</li>
				<li><a href="showOrders.action"><i
						class="fa fa-fw fa-table"></i>订单管理</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse --> </nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">商品管理</h1>
						<ol class="breadcrumb">
							<li><a href="index.jsp">后台管理</a></li>
							<li class="active"><i class="fa fa-table"></i> 商品管理</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-10">

						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th class="">订单号</th>
									<th class="">订单状态</th>
									<th class="">收货地址</th>
									<th></th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="row" items="${orders }">
									<tr>
										<td class="">${row.orderNum }</td>
										<td class="">${row.orderStatus.status }</td>
										<td class="">${row.customer.getAdress.adress }</td>
										<td><c:choose>
												<c:when test="${row.orderStatus.id==2 }">
													<a href="#" onclick="ship('${row.orderNum}')">发货</a>
												</c:when>
												<c:otherwise>
													<a href="javascript:void(0);">-</a>
												</c:otherwise>
											</c:choose><a href="#" style="float: right; color: red;"
											onclick="deleteOrder('${row.orderNum}')">删除</a></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<script type="text/javascript">
		function ship(orderNum) {
			console.log(orderNum);
			$.ajax({
				url : "chip.action",
				data : {
					"orderNum" : orderNum
				},
				dataType : "text",
				success : function(result) {
					if (result == 1) {
						location.href = "showOrders.action";
					} else {
						alert("操作失败");
					}
				},
				error : function(msg) {
					console.log(msg);
				}
			});
		}
	</script>

	<script type="text/javascript">
		function deleteOrder(orderNum) {
			if (confirm("是否删除")) {
				$.ajax({
					url : "deleteOrder.action",
					data : {
						"orderNum" : orderNum
					},
					dataType : "text",
					success : function(result) {
						if (result == 1) {
							location.href = "showOrders.action";
						} else {
							alert("操作失败");
						}
					},
					error : function(msg) {
						console.log(msg);
					}
				});
			}
		}
	</script>

	<!-- jQuery -->
	<script src="js/jquery.js"></script>
	<script src="js/admin.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>