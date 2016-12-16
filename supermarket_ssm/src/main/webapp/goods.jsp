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

<!-- 日期样式 -->
<link rel="stylesheet" type="text/css" href="datecss/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="datecss/zzsc.css">
<link rel="stylesheet" href="datecss/dcalendar.picker.css" />

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
									<th class="gName">名称</th>
									<th class="price">价格</th>
									<th class="type">类别</th>
									<th class="discount">优惠信息</th>
									<th class="date">生产日期</th>
									<th class="expired-date">有效期</th>
									<th class="offerBy">生产商</th>
									<th class="size">尺码</th>
									<th class="sum">库存</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="row" items="${goods }">
									<tr>
										<td class="gName">${row.name}</td>
										<td class="price">${row.price}</td>
										<td class="type">${row.goodsType.name}</td>
										<td class="discount">${row.discount}</td>
										<td class="date">${row.creatDate}</td>
										<td class="expired-date">${row.expiryDate}</td>
										<td class="offerBy">${row.producer}</td>
										<td class="size">${row.size}</td>
										<td class="sum">${row.goodsSum.sum }</td>
										<td><a href="#" class="goods-modify">修改</a> <a href="#"
											style="float: right; color: red;"
											onclick="deleteGoods('${row.id}')">删除</a></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
						<button type="submit" id="create-goods"
							class="btn btn-default float-r">创建商品</button>
					</div>
					<div class="col-lg-10">
						<form id="goods-form">

							<div class="col-lg-4">
								<div class="form-group">
									<label>名称</label> <input class="form-control form-gName"
										name="goodsName" id="goodsName">
								</div>

								<div class="form-group">
									<label>价格</label> <input class="form-control form-price"
										name="goodsPrice" id="goodsPrice">
								</div>

								<div class="form-group">
									<label>类别</label><select class="form-control form-type"
										name="goodsType" id="goodsType">
										<c:forEach var="goodsType" items="${goodsTypes }">
											<option value="${goodsType.name }">${goodsType.name }</option>
										</c:forEach>
									</select>
								</div>

								<div class="form-group">
									<label>优惠信息</label> <input class="form-control form-discount"
										name="goodsDiscount" id="goodsDiscount">
								</div>
								<div class="form-group">
									<label>数量</label> <input class="form-control form-sum"
										name="goodsSum" id="goodsSum">
								</div>
							</div>

							<div class="col-lg-4">

								<div class="form-group">
									<label>生产日期</label><br /> <input
										class="form-control form-date" name="goodsCreatDate"
										id="goodsCreatDate">
								</div>
								<div class="form-group">
									<label>有效期</label> <input
										class="form-control form-expired-date" name="goodsExpiryDate"
										id="goodsExpiryDate">
								</div>

								<div class="form-group">
									<label>生产商</label> <input class="form-control form-offerBy"
										name="goodsProducer" id="goodsProducer">
								</div>

								<div class="form-group">
									<label>尺码</label> <input class="form-control form-size"
										name="goodsSize" id="goodsSize">
								</div>
							</div>
							<div class="col-lg-8">
								<button type="button" class="btn btn-default float-r"
									onclick="chGoods()">保存修改</button>
							</div>

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
		function deleteGoods(goodsId) {
			if (confirm("是否删除")) {
				$.ajax({
					type : "post",
					url : "deleteGoods.action",
					data : {
						"id" : goodsId
					},
					dataType : "text",
					success : function(result) {
						if ("success" == result) {
							alert("删除成功");
							location.href = "showGoods.action";
						}
					},
					error : function(msg) {
						console.log(msg);
					}
				});
			}
			;
		};
	</script>

	<script type="text/javascript">
		function chGoods() {
			var message = {
				goodsName : $("#goodsName").val(),
				goodsPrice : $("#goodsPrice").val(),
				goodsType : $("#goodsType").val(),
				goodsDiscount : $("#goodsDiscount").val(),
				goodsSum : $("#goodsSum").val(),
				goodsCreatDate : $("#goodsCreatDate").val(),
				goodsExpiryDate : $("#goodsExpiryDate").val(),
				goodsProducer : $("#goodsProducer").val(),
				goodsSize : $("#goodsSize").val()
			};

			if (message.goodsName.trim() == "") {
				$("#goodsName").attr("placeholder", "请输入名称");
				return false;
			}
			if (message.goodsPrice.trim() == "") {
				$("#goodsPrice").attr("placeholder", "请输入价格");
				return false;
			}
			if (message.goodsType.trim() == "") {
				$("#goodsType").attr("placeholder", "请输入类型");
				return false;
			}
			if (message.goodsDiscount.trim() == "") {
				$("#goodsDiscount").attr("placeholder", "请输入折扣");
				return false;
			}
			if (message.goodsSum.trim() == "") {
				$("#goodsSum").attr("placeholder", "请输入数量");
				return false;
			}
			if (message.goodsCreatDate.trim() == "") {
				$("#goodsCreatDate").attr("placeholder", "请输入生产日期");
				return false;
			}
			if (message.goodsExpiryDate.trim() == "") {
				$("#goodsExpiryDate").attr("placeholder", "请输入有效期");
				return false;
			}
			if (message.goodsProducer.trim() == "") {
				$("#goodsProducer").attr("placeholder", "请输入厂商");
				return false;
			}
			if (message.goodsSize.trim() == "") {
				$("#goodsSize").attr("placeholder", "请输入尺寸");
				return false;
			}

			$.ajax({
				type : "post",
				data : message,
				url : "chGoods.action",
				dataType : "text",
				success : function(result) {
					console.log(result);
					if ("update" == result) {
						alert("修改成功");
						location.href = "showGoods.action";
					}
					if ("insert" == result) {
						alert("增加成功");
						location.href = "showGoods.action";
					}
					if ("error" == result) {
						alert("请输入数字");
					}
				},
				error : function(msg) {
					console.log(msg);
				}
			});
		}
	</script>

	<script src="datejs/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="datejs/dcalendar.picker.js"></script>
	<script type="text/javascript">
		$('#goodsCreatDate').dcalendarpicker({
			format : 'yyyy-mm-dd'
		});
	</script>

</body>
</html>