layui.use(['jquery', 'form', 'layer'], function() {
	var form = layui.form;
	var $ = layui.jquery;
	var layer = layui.layer;

	//监听提交
	form.on('submit(register)', function(data) {
		var username = data.field.username;
		var password = data.field.password;
		var nickname = data.field.nickname;
		var phone = data.field.phone;
		var power = data.field.role;
		var sex = data.field.sex;
		form.verify({
			username: function(value, item) { //value：表单的值、item：表单的DOM对象
				if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
					return '用户名不能有特殊字符';
				}
				if (/(^\_)|(\__)|(\_+$)/.test(value)) {
					return '用户名首尾不能出现下划线\'_\'';
				}
				if (/^\d$/.test(value)) {
					return '用户名不能全为数字';
				}
			},
			password: [
				/^[\S]{6,12}$/, '密码必须6到12位，且不能出现空格'
			]
		})
		$.ajax({
			url: 'http://localhost:8086/translation/User/registerUser',
			type: "POST",
			data: {
				"userName": username,
				"passWord": password,
				"nickName": nickname,
				"phone": phone,
				"power": power,
				"gender": sex
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
						yes: function() {
							$(window).attr("location","login.html");
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
		return false;
	});
	// form.on('radio(sex)', function(data){
	// 	console.log(data.value)
	// })
});
