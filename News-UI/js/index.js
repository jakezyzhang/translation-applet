layui.use(['jquery'], function() {
	var $ = layui.jquery;
	$.ajax({
		url: 'http://localhost:8086/translation/User/getloginuser',
		type: "GET",
		success: function(data) {
			//加载数据
			alert(data.loginUser.userName);
		}
	});
});
