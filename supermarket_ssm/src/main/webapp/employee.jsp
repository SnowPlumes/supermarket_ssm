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
						<h1 class="page-header">员工管理</h1>
						<ol class="breadcrumb">
							<li><a href="index.jsp">后台管理</a></li>
							<li class="active"><i class="fa fa-table"></i> 员工管理</li>
						</ol>
					</div>
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-6">

						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th class="eID">员工ID</th>
									<th class="eName">姓名</th>
									<th class="phoneNum">电话</th>
									<th class="email">邮箱</th>
									<th class="permission">员工权限</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="row" items="${employees }">
									<tr>
										<td class="eID">${row.eID}</td>
										<td class="eName">${row.name}</td>
										<td class="phoneNum">${row.phone}</td>
										<td class="email">${row.email}</td>
										<td class="permission">${row.employeeLimit.level}</td>
										<td><a href="#" class="employee-modify">修改</a> <a
											href="#" onclick="deleteEmp('${row.eID}')"
											style="float: right; color: red;" class="delete-employee">删除</a></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
						<button type="submit" id="create-employee"
							class="btn btn-default float-r">创建员工</button>
					</div>
					<div class="col-lg-1"></div>
					<div class="col-lg-4">
						<form id="employee-form">

							<div class="form-group">
								<label>员工ID</label> <input class="form-control form-eID"
									name="employeeId" id="employeeId">
							</div>

							<div class="form-group">
								<label>姓名</label> <input class="form-control form-eName"
									name="employeeName" id="employeeName">
							</div>

							<div class="form-group">
								<label>电话</label> <input class="form-control form-phoneNum"
									name="employeePhone" id="employeePhone">
							</div>

							<div class="form-group">
								<label>邮箱</label> <input class="form-control form-email"
									name="employeeEmail" id="employeeEmail">
							</div>

							<div class="form-group">
								<label>员工权限</label> <input class="form-control form-permission"
									name="employeeLimit" id="employeeLimit">
							</div>
							<button type="button" class="btn btn-default"
								onclick="chEmployee()">保存修改</button>

						</form>
					</div>
				</div>

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>
	<script src="js/admin.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<script type="text/javascript">
		function deleteEmp(eID) {
			console.log(eID);
			if (confirm("是否删除")) {
				$.ajax({
					type : "post",
					url : "deleteEmployee.action",
					data : {
						"id" : eID
					},
					dataType : "text",
					success : function(data) {
						console.log(eID);
						console.log(data);
						location.href = "employeeManager.action";
					},
					error : function(msg) {
						console.log(msg);
					},
				});
			}
		}
	</script>

	<script type="text/javascript">
		function chEmployee() {
			var msg = {
				employeeId : $("#employeeId").val(),
				employeeName : $("#employeeName").val(),
				employeePhone : $("#employeePhone").val(),
				employeeEmail : $("#employeeEmail").val(),
				employeeLimit : $("#employeeLimit").val()
			};

			if (!(/^1[34578]\d{9}$/.test(msg.employeePhone))) {
				alert("手机号码有误，请重填");
				return false;
			}

			$.ajax({
				type : "post",
				url : "chEmployee.action",
				data : msg,
				dataType : "text",
				success : function(data) {
					console.log(data);
					alert("操作成功");
					location.href = "employeeManager.action";
				},
				error : function(message) {
					console.log(message);
				}
			});
		};
	</script>

</body>
</html>