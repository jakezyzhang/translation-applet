layui.use(['jquery', 'form', 'layer'], function() {
	var form = layui.form;
	var $ = layui.jquery;
	var layer = layui.layer;
	//监听提交
	$.ajax({
		url: 'http://localhost:8086/translation/User/queryuserbyuserid',
		type: "GET",
		cache: false,
		async: false,
		data:{},
		success: function (data) {
			$("#username").val(data.user.userName);
			$("#password").val(data.user.passWord);
			$("#nickname").val(data.user.nickName);
			$("#phone").val(data.user.phone);
		}
	})
	form.on('submit(updateUser)', function(data) {
		$.ajax({
			url: 'http://localhost:8086/translation/User/modifyuser',
			type: "POST",
			cache: false,
			data: {
				"userName": data.field.username,
				"passWord": data.field.password,
				"nickName": data.field.nickName,
				"phone":data.field.phone,
				"gender": data.field.sex,
				"power":data.field.role
			},
			success: function(data) {
				console.log(data.success)
				if (data.success == true) {
					layer.open({
						title: '编辑',
						content: '修改用户信息成功',
						yes:function(){
							layer.close(layer.index);
							window.parent.location.reload(); //重新加载父页面，进行数据刷新
						}
					});
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
