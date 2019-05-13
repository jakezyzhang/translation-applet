layui.use(['jquery', 'form', 'layer'], function() {
	var form = layui.form;
	var $ = layui.jquery;
	var layer = layui.layer;
	
	//监听提交
	form.on('submit(login)', function(data) {
		var user = data.field.username;
		var pwd = data.field.password;

		$.ajax({
			url: 'http://localhost:8086/translation/User/loginUser',
			type: "POST",
			data: {
				"userName": user,
				"passWord": pwd
			},
			success: function(data) {
				// alert(data.result)
				if (data.success == true) {
					layer.open({
						type: 1,
						offset: 'auto',
						content: '<div style="padding: 20px 100px;">' + '注册成功' + '</div>',
						btn: '关闭全部',
						btnAlign: 'c' ,
						shade: 0 ,
						success: function() {
							$(window).attr("location","index.html");
						}
					});
					
				} else {
					layer.open({
						type: 1,
						offset: 'auto',
						content: '<div style="padding: 20px 100px;">' + data.result + '</div>',
						btn: '关闭全部',
						btnAlign: 'c' ,
						shade: 0 ,
						yes: function() {
							layer.closeAll();
						}
					});
				}
				// 
			},
		});
	});
});
