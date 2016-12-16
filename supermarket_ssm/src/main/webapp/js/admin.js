$(".employee-modify").click(function() {
	$("#employee-form").show();
	var eID = $(this).parents("tr").find(".eID").text();
	var eName = $(this).parents("tr").find(".eName").text();
	var phoneNum = $(this).parents("tr").find(".phoneNum").text();
	var email = $(this).parents("tr").find(".email").text();
	var permission = $(this).parents("tr").find(".permission").text();

	$("#employee-form .form-eID").val(eID);
	$("#employee-form .form-eName").val(eName);
	$("#employee-form .form-phoneNum").val(phoneNum);
	$("#employee-form .form-email").val(email);
	$("#employee-form .form-permission").val(permission);

	return false;
});

$("#create-employee").click(function() {
	$("#employee-form").show();

	$("#employee-form .form-eID").val("");
	$("#employee-form .form-eName").val("");
	$("#employee-form .form-phoneNum").val("");
	$("#employee-form .form-email").val("");
	$("#employee-form .form-permission").val("");

	return false;
});

$(".goods-modify").click(function() {
	$("#goods-form").show();
	var gName = $(this).parents("tr").find(".gName").text();
	var price = $(this).parents("tr").find(".price").text();
	var type = $(this).parents("tr").find(".type").text();
	var discount = $(this).parents("tr").find(".discount").text();
	var date = $(this).parents("tr").find(".date").text();
	var expiredDate = $(this).parents("tr").find(".expired-date").text();
	var offerBy = $(this).parents("tr").find(".offerBy").text();
	var size = $(this).parents("tr").find(".size").text();
	var sum = $(this).parents("tr").find(".sum").text();

	
	$("#goods-form .form-gName").val(gName);
	$("#goods-form .form-gName").attr({
		"disabled" : true
	});
	$("#goods-form .form-price").val(price);
	$("#goods-form .form-type").val(type);
	$("#goods-form .form-type").attr({
		"disabled" : true
	});
	$("#goods-form .form-discount").val(discount);
	$("#goods-form .form-date").val(date);
	$("#goods-form .form-date").attr({
		"disabled" : true
	});
	$("#goods-form .form-expired-date").val(expiredDate);
	$("#goods-form .form-expired-date").attr({
		"disabled" : true
	});
	$("#goods-form .form-offerBy").val(offerBy);
	$("#goods-form .form-offerBy").attr({
		"disabled" : true
	});
	$("#goods-form .form-size").val(size);
	$("#goods-form .form-sum").val(sum);
	return false;
});

$("#create-goods").click(function() {
	$("#goods-form").show();

	$("#goods-form .form-gName").val("");
	$("#goods-form .form-gName").attr({
		"disabled" : false
	});
	$("#goods-form .form-price").val("");
	$("#goods-form .form-type").val("");
	$("#goods-form .form-type").attr({
		"disabled" : false
	});
	$("#goods-form .form-discount").val("");
	$("#goods-form .form-date").val("");
	$("#goods-form .form-date").attr({
		"disabled" : false
	});
	$("#goods-form .form-expired-date").val("");
	$("#goods-form .form-expired-date").attr({
		"disabled" : false
	});
	$("#goods-form .form-offerBy").val("");
	$("#goods-form .form-offerBy").attr({
		"disabled" : false
	});
	$("#goods-form .form-size").val("");
	$("#goods-form .form-sum").val("0");
	return false;
});

$("#login-form button").click(function() {
	window.location.href = "index.html";
	return false;
});