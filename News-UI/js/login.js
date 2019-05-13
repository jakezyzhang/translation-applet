layui.use(['jquery', 'form', 'layer'], function() {
	var form = layui.form;
	var $ = layui.jquery;
	var layer = layui.layer;
	//监听提交
	form.on('submit(login)', function(data) {
		$.ajax({
			url: 'http://localhost:8086/translation/User/loginUser',
			type: "POST",
			cache: false,
			data: {
				"userName": data.field.username,
				"passWord": data.field.password
			},
			success: function(data) {
				if (data.success == true) {
					$(window).attr("location", "queryTable.html");
				} else {
					layer.open({
						type: 1,
						offset: 'auto',
						content: '<div style="padding: 20px 100px;">' + data.errMsg + '</div>',
						btn: '关闭全部',
						btnAlign: 'c' ,
						shade: 0 ,
						yes: function() {
							layer.closeAll();
						}
					});
				}
			}
		});
		return false;
	});
});
