layui.use(['jquery', 'form', 'layer', 'table', 'layedit'], function() {
	var form = layui.form;
	var $ = layui.jquery;
	var layer = layui.layer;
	var table = layui.table;
	var layedit = layui.layedit
	var router = layui.router();
	var index = parent.layer.getFrameIndex(window.name); //修改成功的时候点击 确定 会关闭子窗口，这里获取一下子窗口
	form.render();
	//监听提交
	var rid = GetRid();
	form.on('submit(editArticle)', function(data) { //这块要跟表单中的lay-filter="editArticle"对应
		if (data.field.switch == 'on') {
			publish = 1;
		} else {
			publish = 0
		}
		$.ajax({
			url: "http://localhost:8086/translation/Article/modifyarticle",
			type: "post",
			async: false, //不要让它异步提交
			data: {
				"rId": rid,
				"rLongTitle": data.field.longTitle,
				"rSubheading": data.field.subheading,
				"rSummary": data.field.summary,
				"rContent": data.field.article,
				"rPublish": publish,
				"rStatus": 0,
			},
			success: function(data) {
				if(data.success == true){
					layer.open({
						title: '编辑',
						content: '修改新闻成功',
						yes:function(){
							layer.close(layer.index);
							window.parent.location.reload(); //重新加载父页面，进行数据刷新
						}
					});
				}else{
					layer.open({
						type: 1,
						offset: 'auto',
						content: '<div style="padding: 20px 100px;">' + '修改失败' + '</div>',
						btn: '关闭全部',
						btnAlign: 'c' ,
						shade: 0 ,
						yes: function() {
							layer.closeAll();
						}
					});
				}
				// if (data.msg != '0') {
				// 	layer.alert("修改成功", {
				// 		icon: 1,
				// 		time: 2000
				// 	}, function() {
				// 		layer.close(layer.index);
				// 		window.parent.location.reload(); //重新加载父页面，进行数据刷新
				// 	});
				// } else {
				// 	layer.alert("修改失败", {
				// 		icon: 2,
				// 		time: 2000
				// 	});
				// }
			}
		});
		return false;
	});
});

function GetRid() {
	var url = document.location.toString();
	var arrUrl = url.split("?");
	var para = arrUrl[1];
	var arrRid = para.split("=")
	var rid = arrRid[1]
	return rid;
}
