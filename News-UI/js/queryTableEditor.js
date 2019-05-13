layui.use(['jquery', 'form', 'layer', 'table', 'layedit'], function() {
	var form = layui.form;
	var $ = layui.jquery;
	var layer = layui.layer;
	var table = layui.table;
	var layedit = layui.layedit
	var index = parent.layer.getFrameIndex(window.name); //修改成功的时候点击 确定 会关闭子窗口，这里获取一下子窗口
	form.render();
	//监听提交
	
	form.on('submit(editArticle)', function(data) { //这块要跟表单中的lay-filter="editArticle"对应
		console.log(layui.router().search.rId)
		$.ajax({
			url: "${pageContext.request.contextPath}/students/editStudent",
			type: "post",
			async: false, //不要让它异步提交
			data: data.field,
			dataType: "json",
			success: function(data) {
				if (data.msg != '0') {
					layer.alert("修改成功", {
						icon: 1,
						time: 2000
					}, function() {
						layer.close(layer.index);
						window.parent.location.reload(); //重新加载父页面，进行数据刷新
					});
				} else {
					layer.alert("修改失败", {
						icon: 2,
						time: 2000
					});
				}
			}
		});
		return false;
	});
});
